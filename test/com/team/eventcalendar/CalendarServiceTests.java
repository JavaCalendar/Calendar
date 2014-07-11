package com.team.eventcalendar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dmitriy on 7/6/14.
 */
public class CalendarServiceTests {

    @Test
    public void testCreateEvent() throws Exception{

        String inputName = "Team meeting";
        String [] attenders = new String[]{"mike@mail.com", "troy@i.ua", "jimmy@gmail.com"};
        List<String> attendersList = Arrays.asList(attenders);

        Event expectedEvent = new Event.EventBuilder().description(inputName).attenders(attendersList).date(new GregorianCalendar(2014, 10, 25)).build();

        CalendarService calendarService = mock(CalendarService.class);
        when(calendarService.createEvent(inputName,attendersList,new GregorianCalendar(2014, 10, 25))).thenReturn(expectedEvent);

        EventHelperImpl eventHelper = new EventHelperImpl();
        CalendarService calendarServiceReal = new CalendarService(eventHelper);

        Event realEvent = calendarServiceReal.createEvent(inputName,attendersList,new GregorianCalendar(2014, 10, 25));

        Assert.assertEquals("", expectedEvent ,realEvent);
    }
}
