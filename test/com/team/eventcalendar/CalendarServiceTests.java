//small change to be deleted later
package com.team.eventcalendar;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by dmitriy on 7/6/14.
 */
public class CalendarServiceTests {

    @Test
    public void testCreateEvent() throws Exception{

        String inputName = "Team meeting";
        String [] attenders = new String[]{"mike@mail.com", "troy@i.ua", "jimmy@gmail.com"};
        List<String> attendersList = Arrays.asList(attenders);

        Event expectedEvent = new Event.EventBuilder().description(inputName).attenders(attendersList).date(new GregorianCalendar(2014, 10, 25)).uuid(UUID.randomUUID()).build();

        CalendarService calendarService = mock(CalendarService.class);
        when(calendarService.createEvent(inputName,attendersList,new GregorianCalendar(2014, 10, 25), expectedEvent.getEventUuid())).thenReturn(expectedEvent);

        EventHelperImpl eventHelper = new EventHelperImpl();
        CalendarService calendarServiceReal = new CalendarService(eventHelper);

        Event realEvent = calendarServiceReal.createEvent(inputName,attendersList,new GregorianCalendar(2014, 10, 25), expectedEvent.getEventUuid());
        Assert.assertEquals("", expectedEvent ,realEvent);
    }

    @Test
    public void testOnceCreateEventMethodInvocationAndArgumentsAssertionWithArgumentCaptor() throws Exception {

        String inputName = "Team meeting";
        String[] attenders = new String[]{"mike@mail.com", "troy@i.ua", "jimmy@gmail.com"};
        List<String> attendersList = Arrays.asList(attenders);

        Event expectedEvent = new Event.EventBuilder().description(inputName).attenders(attendersList).date(new GregorianCalendar(2014, 10, 25)).uuid(UUID.randomUUID()).build();

        EventHelperImpl eventHelper = mock(EventHelperImpl.class);
        ArgumentCaptor<String> arg0 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<List> arg1 = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<GregorianCalendar> arg2 = ArgumentCaptor.forClass(GregorianCalendar.class);
        ArgumentCaptor<UUID> arg3 = ArgumentCaptor.forClass(UUID.class);

        CalendarService calendarService = new CalendarService(eventHelper);
        calendarService.createEvent(inputName, attendersList, new GregorianCalendar(2014, 10, 25), expectedEvent.getEventUuid());

        verify(eventHelper, times(1)).createEvent(arg0.capture(), arg1.capture(), arg2.capture(), arg3.capture());

        assertEquals(inputName, arg0.getValue());
        assertEquals(attendersList, arg1.getValue());
        assertEquals(new GregorianCalendar(2014, 10, 25), arg2.getValue());
        assertEquals(expectedEvent.getEventUuid(), arg3.getValue());
    }
}
