package com.example18440611.a1.util;

import java.sql.Time;
import java.util.Date;

public class DateTimeUtil {

    public static Time convertToTime(String str) {
        String[] components = str.split(":");
        return new Time(Integer.parseInt(components[0]), Integer.parseInt(components[1]), 0);
    }

    public static Date convertToDate(String date) {
        return new Date(date);
    }

    public static String convertToDisplay(Time time) {
        int hour = time.getHours();
        int min = time.getMinutes();

        String amOrpm;
        if (hour == 0) {
            hour += 12;
            amOrpm = "AM";
        } else if (hour == 12) {
            amOrpm = "PM";
        } else if (hour > 12) {
            hour -= 12;
            amOrpm = "PM";
        } else {
            amOrpm = "AM";
        }
        return get2CharFormat(hour) + ":" + get2CharFormat(min) + " " + amOrpm;
    }

    private static String get2CharFormat(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return "" + i;
    }
}
