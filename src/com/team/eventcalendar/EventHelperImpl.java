package com.team.eventcalendar;

import java.util.*;

/**
 * Created by dmitriy on 7/6/14.
 */
public class EventHelperImpl implements EventHelper {

    private Map<UUID,Event> dataSource = new HashMap<>();

    @Override
    public Event findEventById(UUID id) {
        if (dataSource.containsKey(id)) {
            return dataSource.get(id);
        } else {
            return null;
        }
    }

    @Override
    public Event removeEvent(UUID id) {
        if (dataSource.containsKey(id)) {
            return dataSource.remove(id);
        } else {
            return null;
        }
    }

    @Override
    public Event createEvent(String description, List<String> attenders, GregorianCalendar date, UUID eventUuid) {
        return new Event.EventBuilder().description(description).attenders(attenders).date(date).uuid(eventUuid).build();
    }

    @Override
    public void addEvent(Event event) {
        dataSource.put(event.getEventUuid(), event);
        /*System.out.println("MAPA==>"+dataSource.toString());
        System.out.println("KEYs==>"+dataSource.keySet().toString());*/
    }

    public void showCalendar() {
        System.out.println("Calendar events:  " + dataSource.values().toString());
    }
}
