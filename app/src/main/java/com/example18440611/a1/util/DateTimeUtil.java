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
}
