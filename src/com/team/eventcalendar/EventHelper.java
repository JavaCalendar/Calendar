package com.team.eventcalendar;

import java.util.*;

/**
 * Created by dmitriy on 7/6/14.
 */
public interface EventHelper {

    Event findEventById(UUID id);

    Event removeEvent(UUID id);

    Event createEvent(String description, List<String> attenders, GregorianCalendar date);

    void addEvent(Event event);
}
