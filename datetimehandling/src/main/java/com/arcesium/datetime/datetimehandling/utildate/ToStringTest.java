package com.arcesium.datetime.datetimehandling.utildate;

import java.util.Date;
import java.util.TimeZone;

public class ToStringTest {

    public static void main(String[] args) {

        System.out.println(TimeZone.getDefault());
        Date d1 = new Date();
        System.out.println(d1);
        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
        System.out.println(TimeZone.getDefault());
        System.out.println(d1);
        System.out.println("------------------------------");
    }
}
