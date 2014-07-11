package com.team.eventcalendar;

import java.util.*;

/**
 * Created by dmitriy on 7/6/14.
 */
public class CalendarService {

    private final EventHelperImpl eventResource;


    public CalendarService(EventHelperImpl eventResource){this.eventResource = eventResource;}

    public Event findEventById(UUID id) {
        return eventResource.findEventById(id);
    }

    public Event removeEvent(UUID id) {
        return eventResource.removeEvent(id);
    }

    public Event createEvent(String description, List<String> attenders, GregorianCalendar date) {
       return eventResource.createEvent(description, attenders, date);
    }

    public void addEvent(UUID id, Event event){
        eventResource.addEvent(id, event);
    }

    public void showCalendar(){
        eventResource.showCalendar();
    }
}
