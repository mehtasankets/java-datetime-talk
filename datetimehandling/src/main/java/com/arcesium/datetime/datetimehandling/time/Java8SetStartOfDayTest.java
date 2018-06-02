package com.arcesium.datetime.datetimehandling.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class Java8SetStartOfDayTest {

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
        LocalDateTime dt1 = LocalDateTime.now();
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println(dt1);
        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
        dt1 = dt1.withHour(0);
        dt1 = dt1.withMinute(0);
        dt1 = dt1.withSecond(0);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println(dt1);
        System.out.println("------------------------------");

        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
        LocalDateTime dt2 = LocalDateTime.now();
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println(dt2);
        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
        dt2 = dt2.truncatedTo(ChronoUnit.DAYS);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println(dt2);
        System.out.println("------------------------------");
    }
}
