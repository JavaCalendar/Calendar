package com.team.eventcalendar;


import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by dmitriy on 7/6/14.
 */
public class Event {

    private final String description;
    private  final List<String> attenders; //user email
    private final GregorianCalendar date;

    private  Event(EventBuilder builder){
        this.description = builder.description;
        this.attenders = builder.attenders;
        this.date = builder.date;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAttenders() {
        return attenders;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                ", attenders=" + attenders +
                ", date=" + date +
                '}';
    }


    public static class EventBuilder{

        private String description;
        private List<String> attenders;
        private GregorianCalendar date;

        public EventBuilder(){}

        public EventBuilder(Event event){
            this.description = event.description;
            this.attenders = event.attenders;
            this.date = event.date;
        }

        public EventBuilder description(String description){
            this.description = description;
            return this;
        }

        public EventBuilder attenders(List<String> attenders){
            this.attenders = attenders;
            return this;
        }

        public EventBuilder date(GregorianCalendar date){
            this.date = date;
            return this;
        }

        public Event build(){return new Event(this);}

    }
}
