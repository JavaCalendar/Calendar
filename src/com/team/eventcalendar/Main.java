package com.team.eventcalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by dmitriy on 7/6/14.
 */
public class Main {

    public static void main(String [] descriptions){

        List<String> descriptionsList = Arrays.asList(new String[]{"Mike's birthday", "Independence Day", "Project meeting"});//Arrays.asList(descriptions);
        String [] attenders = new String[]{"mike@mail.com", "troy@i.ua", "jimmy@gmail.com"};
        List<String> attendersList = Arrays.asList(attenders);

        List<GregorianCalendar> datesList = new ArrayList<>();
        for (int i = 0; i < descriptionsList.size(); i++) {
            datesList.add(new GregorianCalendar(2014, (int) ((Math.random() * 120)/10), (int) ((Math.random() * 100)/4), (int) ((Math.random() * 120)/2), (int) ((Math.random() * 120)/2)));
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*EventHelperImpl eventHelper = new EventHelperImpl();
        CalendarService calendarService = new CalendarService(eventHelper);*/

        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        for(int k = 0; k < descriptionsList.size(); k++){
        calendarService.addEvent(calendarService.createEvent(descriptionsList.get(k), attendersList, datesList.get(k), UUID.randomUUID()));
        }

        calendarService.showCalendar();

    }
}
