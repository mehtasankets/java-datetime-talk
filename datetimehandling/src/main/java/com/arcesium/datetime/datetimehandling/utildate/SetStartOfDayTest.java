package com.arcesium.datetime.datetimehandling.utildate;

import java.util.Date;
import java.util.TimeZone;

public class SetStartOfDayTest {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
        Date d1 = new Date();

        // d1.toString(); // <-- Comment out this line to check out fun part.

        TimeZone.setDefault(TimeZone.getTimeZone("EST"));

        d1.setHours(0); d1.setMinutes(0); d1.setSeconds(0);

        System.out.println(d1);
    }
}
