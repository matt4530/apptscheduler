package services;

import io.swagger.client.api.SchedulingApi;
import io.swagger.client.model.AppointmentInfo;
import io.swagger.client.model.AppointmentRequest;
import io.swagger.client.model.Doctor;
import org.threeten.bp.OffsetDateTime;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SchedulingTest {




    @org.junit.jupiter.api.Test
    void scheduleAppointments() throws ServiceException {
        /* Fixtures */
        List<AppointmentInfo> currentSchedule = Fixtures.getScheduleA();
        List<AppointmentRequest> requests = Fixtures.getRequestsA();

        /* Mock out the API dependency */
        Scheduling schedulingService = spy(new Scheduling());
        SchedulingApi mockAPI = mock(SchedulingApi.class);
        when(schedulingService.getApi()).thenReturn(mockAPI);

        /* Invoke */
        for(int i = 0; i < requests.size(); i++)
            schedulingService.scheduleAppointments(currentSchedule, requests.get(i));

        // TODO: Write actual tests, but for now just print invocations
        mockingDetails(mockAPI).printInvocations();
    }
}