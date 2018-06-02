package com.arcesium.datetime.datetimehandling.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Java8JacksonTest {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        LocalDate d1 = LocalDate.now();
        System.out.println("LocalDate: " + d1);

        String d1Str = mapper.writeValueAsString(d1);
        System.out.println("Serialized LocalDate: " + d1Str);

        LocalDate d2 = mapper.readValue(d1Str, LocalDate.class);
        System.out.println("Deserialized LocalDate: " + d2);
        System.out.println("------------------------------");

        LocalDateTime dt1 = LocalDateTime.now();
        System.out.println("LocalDateTime: " + dt1);

        String dt1Str = mapper.writeValueAsString(dt1);
        System.out.println("Serialized LocalDateTime: " + dt1Str);

        LocalDateTime dt2 = mapper.readValue(dt1Str, LocalDateTime.class);
        System.out.println("Deserialized LocalDateTime: " + dt2);
        System.out.println("------------------------------");

        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zdt1);

        String zdt1Str = mapper.writeValueAsString(zdt1);
        System.out.println("Serialized ZonedDateTime: " + zdt1Str);

        ZonedDateTime zdt2 = mapper.readValue(zdt1Str, ZonedDateTime.class);
        System.out.println("Deserialized ZonedDateTime: " + zdt2);
        System.out.println("------------------------------");

        Instant i1 = Instant.now();
        System.out.println("Instant: " + i1);

        String i1Str = mapper.writeValueAsString(i1);
        System.out.println("Serialized Instant: " + i1Str);

        Instant i2 = mapper.readValue(i1Str, Instant.class);
        System.out.println("Deserialized Instant: " + i2);
        System.out.println("------------------------------");

    }
}
