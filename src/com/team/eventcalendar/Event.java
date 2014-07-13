package com.team.eventcalendar;


import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by dmitriy on 7/6/14.
 */
public class Event {
    private final String description;
    private final List<String> attenders; //user email
    private final GregorianCalendar date;
    private final UUID eventUuid;

    private  Event(EventBuilder builder){
        this.description = builder.description;
        this.attenders = builder.attenders;
        this.date = builder.date;
        this.eventUuid = builder.eventUuid;
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

    public UUID getEventUuid() {
        return eventUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (eventUuid != null ? !eventUuid.equals(event.eventUuid) : event.eventUuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (eventUuid != null ? eventUuid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("description='").append(description).append('\'');
        sb.append(", attenders=").append(attenders);
        sb.append(", date=[").append(dateToString(date)).append("]");
        sb.append(", eventUuid=").append(eventUuid);
        sb.append('}');
        return sb.toString();
    }

    public String dateToString(GregorianCalendar date) {
        return date.getTime().toString();
    }

    public static class EventBuilder{
        private String description;
        private List<String> attenders;
        private GregorianCalendar date;
        private UUID eventUuid;

        public EventBuilder() {
        }

        public EventBuilder(Event event){
            this.description = event.description;
            this.attenders = event.attenders;
            this.date = event.date;
            this.eventUuid = event.eventUuid;
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

        public EventBuilder uuid(UUID eventUuid){
            this.eventUuid = eventUuid;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
