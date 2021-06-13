package com.example18440611.a1.dto;


import com.example18440611.a1.util.Checks;
import com.example18440611.a1.util.DateTimeUtil;

import java.sql.Time;
import java.time.LocalDate;

public class Event {

    public static String EVENT_NAME = "eventName";
    public static String EVENT_DESCRIPTION = "description";
    public static String EVENT_LOCATION = "location";
    public static String EVENT_DATE = "eventDate";
    public static String EVENT_START_TIME = "startTime";
    public static String EVENT_END_TIME = "endTime";

    public int id;
    private String eventName;
    private String description;
    private String location;
    private LocalDate date;
    private Time startTime;
    private Time endTime;
    private boolean reminder1;
    private boolean reminder2;
    private boolean reminder3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean getReminder1() {
        return reminder1;
    }

    public void setReminder1(boolean reminder1) {
        this.reminder1 = reminder1;
    }

    public boolean getReminder2() {
        return reminder2;
    }

    public void setReminder2(boolean reminder2) {
        this.reminder2 = reminder2;
    }

    public boolean getReminder3() {
        return reminder3;
    }

    public void setReminder3(boolean reminder3) {
        this.reminder3 = reminder3;
    }

    public boolean isValid() {
        return Checks.isNotNullAndNonEmpty(eventName) &&
                Checks.isNotNullAndNonEmpty(description) &&
                Checks.isNotNullAndNonEmpty(location) &&
                Checks.isNotNull(date) &&
                Checks.isNotNull(startTime) &&
                Checks.isNotNull(endTime);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Event : ");
        builder.append(eventName);
        builder.append("\n");
        builder.append("Location : ");
        builder.append(location);
        builder.append("\n");
        builder.append("Description : ");
        builder.append(description);
        builder.append("\n");
        builder.append("Date : ");
        builder.append(date.toString());
        builder.append("\n");
        builder.append("From ");
        builder.append(DateTimeUtil.convertToDisplay(startTime));
        builder.append(" To ");
        builder.append(DateTimeUtil.convertToDisplay(endTime));
        builder.append("\n");
        builder.append("Remind before 1 hr : ");
        builder.append(reminder1 ? "Set" : "Not Set");
        builder.append("\n");
        builder.append("Remind before 3 hrs : ");
        builder.append(reminder2 ? "Set" : "Not Set");
        builder.append("\n");
        builder.append("Remind before 6 hrs : ");
        builder.append(reminder3 ? "Set" : "Not Set");


        return builder.toString();
    }
}
