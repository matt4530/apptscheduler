import io.swagger.client.model.AppointmentInfo;
import io.swagger.client.model.AppointmentRequest;
import services.Scheduling;
import services.ServiceException;

import java.time.OffsetDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ServiceException {
        System.out.println("Starting.");
        Scheduling schedulingService = new Scheduling();
        schedulingService.start();

        List<AppointmentInfo> initialSchedule = schedulingService.getInitialSchedule();

        while(true) {
            AppointmentRequest request = schedulingService.getAppointmentRequest();

            // if there are no more requests in the queue
            if(request == null)
                break;

            schedulingService.scheduleAppointments(initialSchedule, request);
        }

        System.out.println("Stopping. Fetching existing schedule:");
        List<AppointmentInfo> appointmentsAtStop = schedulingService.stop();
        for(int i = 0; i < appointmentsAtStop.size(); i++) {
            System.out.println(appointmentsAtStop.get(i));
        }

    }
}