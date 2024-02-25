package services;

import io.swagger.client.ApiException;
import io.swagger.client.api.SchedulingApi;
import io.swagger.client.model.AppointmentInfo;
import io.swagger.client.model.AppointmentInfoRequest;
import io.swagger.client.model.AppointmentRequest;
import io.swagger.client.model.Doctor;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.OffsetDateTime;

import java.util.*;

/**
 * This class provides high-level Scheduling capabilities
 */
public class Scheduling {
    public static final SchedulingApi api = new SchedulingApi();

    public final UUID API_KEY;

    public Scheduling() {
        String environmentAPIKey = System.getenv("BREVIUM_API_KEY");
        if(environmentAPIKey == null)
            throw new RuntimeException("Cannot find Brevium API key");

        API_KEY = UUID.fromString(environmentAPIKey);
    }

    /**
     * Tells the brevium service to start
     * @throws ServiceException
     */
    public void start() throws ServiceException {
        try {
            getApi().apiSchedulingStartPost(API_KEY);
        } catch (ApiException e) {
            throw new ServiceException(e);
        }
    }
    /**
     * Tells the brevium service to end
     * @return A list of the appointments which have already been scheduled
     * @throws ServiceException
     */
    public List<AppointmentInfo> stop() throws ServiceException  {
        try {
            return getApi().apiSchedulingStopPost(API_KEY);
        } catch (ApiException e) {
            throw new ServiceException(e);
        }
    }


    /**
     * Load the initial monthly schedule
     * @return A list of the appointments which have already been scheduled
     */
    public List<AppointmentInfo> getInitialSchedule() throws ServiceException {
        try {
            return getApi().apiSchedulingScheduleGet(API_KEY);
        } catch (ApiException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets all the appointment requests which are queued
     * @return A list of the queued appointment requests
     */
    public AppointmentRequest getAppointmentRequest() throws ServiceException {
        try {
            return getApi().apiSchedulingAppointmentRequestGet(API_KEY);
        } catch (ApiException e) {
            if(e.getCode() == 204)
                return null;
            throw new ServiceException(e);
        }
    }

    /**
     * Schedules a new appointment, according to the rules provided by the business.
     * @param currentSchedule The current schedule of the doctors
     * @param request The request to be schedule a new appointment for
     */
    public void scheduleAppointments(List<AppointmentInfo> currentSchedule, AppointmentRequest request) throws ServiceException {
        // Find appointment times that satisfy the business requirements
        AppointmentInfoRequest generatedAppt = getPreferredAppointment(currentSchedule, request);

        if(generatedAppt == null)
            throw new ServiceException("Could not schedule an appointment");

        try {
            getApi().apiSchedulingSchedulePost(generatedAppt, API_KEY);
        } catch (ApiException e) {
            // TODO: Rather than throw an exception, perhaps return a list of those which could not be serviced
            throw new ServiceException(e);
        }

    }


    /**
     * Helper function to find a preferred appointment from a set of doctors. Follows the business rules, which are
     *  Those are:
     *    1. Appointments may only be scheduled on the hour.
     *    2. Appointments can be scheduled as early as 8 am UTC and as late as 4 pm UTC.
     *    3. Appointments may only be scheduled on weekdays during the months of November and December 2021.
     *    4. Appointments can be scheduled on holidays.
     *    5. For a given doctor, you may only have one appointment scheduled per hour (though different doctors may have
     *            appointments at the same time).
     *    6. For a given patient, each appointment must be separated by at least one week. For example, if Bob Smith has
     *            an appointment on 11/17 you may schedule another appointment on or before 11/10 or on or after 11/24.
     *    7. Appointments for new patients may only be scheduled for 3 pm and 4 pm.
     */
    private AppointmentInfoRequest getPreferredAppointment(List<AppointmentInfo> currentSchedule, AppointmentRequest request) {
        // Build up a data structure which has quick access to what we need (schedules by doctor and time)
        Map<String, AppointmentInfo> scheduleMap = new HashMap<>();
        for(int i = 0; i < currentSchedule.size(); i++) {
            AppointmentInfo apptInfo = currentSchedule.get(i);

            String key = getMultiKey(
                    apptInfo.getDoctorId(),
                    apptInfo.getAppointmentTime().getYear(),
                    apptInfo.getAppointmentTime().getMonthValue(),
                    apptInfo.getAppointmentTime().getDayOfMonth(),
                    apptInfo.getAppointmentTime().getHour()
            );
            scheduleMap.put(key, apptInfo);
        }

        int earliestHour = 8;
        int latestHour = 16;


        // iterate over days they prefer
        dates: for(int dateIndex = 0; dateIndex < request.getPreferredDays().size(); dateIndex++) {
            OffsetDateTime preferredDate = request.getPreferredDays().get(dateIndex);

            // validate preferred date is M-F, skip this preferred date if not
            if(preferredDate.getDayOfWeek() == DayOfWeek.SUNDAY || preferredDate.getDayOfWeek() == DayOfWeek.SATURDAY)
                continue dates;

            // validate preferred hour is 8am to 4pm, skip this preferred date if not
            if(preferredDate.getHour() < earliestHour && preferredDate.getHour() > latestHour)
                continue dates;

            // if is new, can only schedule 3 and 4pm, skip this preferred date if not
            if(request.isIsNew() && (preferredDate.getHour() != 3 || preferredDate.getHour() != 4))
                continue dates;

            // iterate over doctors they prefer
            doctors: for(int i = 0; i < request.getPreferredDocs().size(); i++) {
                Doctor doc = Doctor.fromValue(request.getPreferredDocs().get(i));

                // see if the person had an appointment less than a week ago, and if so, skip this preferred date
                // TODO: loop over doc schedule to find out, skip doctor if so.

                // check if that hour is open
                String key = getMultiKey(doc, preferredDate.getYear(), preferredDate.getMonthValue(), preferredDate.getDayOfMonth(), preferredDate.getHour());
                if (scheduleMap.getOrDefault(key, null) == null)
                    return generateNewAppointmentInfoRequest(request.getRequestId(), preferredDate, request.getPersonId(), doc, request.isIsNew());
            }
        }

        return null;
    }

    private AppointmentInfoRequest generateNewAppointmentInfoRequest(int requestId, OffsetDateTime time, int personId, Doctor doctorId, boolean isNew) {
        AppointmentInfoRequest req = new AppointmentInfoRequest();
        req.setRequestId(requestId);
        req.setAppointmentTime(time);
        req.setIsNewPatientAppointment(isNew);
        req.setPersonId(personId);
        req.setDoctorId(doctorId);
        return req;
    }

    private String getMultiKey(Doctor doctor, int year, int month, int day, int hour) {
        return doctor.getValue() + "|" + year + "|" + month + "|" + day + "|" + hour;
    }

    /**
     * Helper method to allow mocking
     * @return
     */
    public SchedulingApi getApi() {
        return api;
    }






}
