package services;

import io.swagger.client.model.AppointmentInfo;
import io.swagger.client.model.AppointmentRequest;
import io.swagger.client.model.Doctor;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fixtures {

    /**
     * A generic schedule with 3 appointment in it for different doctors
     * @return
     */
    public static List<AppointmentInfo> getScheduleA() {
        ArrayList<AppointmentInfo> currentSchedule = new ArrayList<>();

        AppointmentInfo a = new AppointmentInfo();
        a.setDoctorId(Doctor.NUMBER_1);
        a.setPersonId(0);
        a.setAppointmentTime(OffsetDateTime.parse("2024-02-26T03:51:02.503Z"));
        a.setIsNewPatientAppointment(true);
        currentSchedule.add(a);

        AppointmentInfo b = new AppointmentInfo();
        b.setDoctorId(Doctor.NUMBER_2);
        b.setPersonId(0);
        b.setAppointmentTime(OffsetDateTime.parse("2024-02-26T03:51:02.503Z"));
        b.setIsNewPatientAppointment(true);
        currentSchedule.add(b);

        AppointmentInfo c = new AppointmentInfo();
        c.setDoctorId(Doctor.NUMBER_3);
        c.setPersonId(0);
        c.setAppointmentTime(OffsetDateTime.parse("2024-02-26T03:51:02.503Z"));
        c.setIsNewPatientAppointment(true);
        currentSchedule.add(c);

        return currentSchedule;
    }

    /**
     * A list of two appointment requests to make
     * @return
     */
    public static List<AppointmentRequest> getRequestsA() {
        ArrayList<AppointmentRequest> requests = new ArrayList<>();

        AppointmentRequest a = new AppointmentRequest();
        a.setRequestId(0);
        a.personId(4);
        a.setPreferredDays(
                Arrays.asList(
                    OffsetDateTime.parse("2024-02-27T03:51:02.503Z"),
                    OffsetDateTime.parse("2024-02-28T03:51:02.503Z")
                )
        );
        a.setPreferredDocs(Arrays.asList(1, 2));
        a.setIsNew(true);
        requests.add(a);

        AppointmentRequest b = new AppointmentRequest();
        b.setRequestId(0);
        b.personId(5);
        b.setPreferredDays(
                Arrays.asList(
                    OffsetDateTime.parse("2024-02-27T03:51:02.503Z"),
                    OffsetDateTime.parse("2024-02-28T03:51:02.503Z")
                )
        );
        b.setPreferredDocs(Arrays.asList(1, 2));
        b.setIsNew(true);
        requests.add(b);

        return requests;
    }
}
