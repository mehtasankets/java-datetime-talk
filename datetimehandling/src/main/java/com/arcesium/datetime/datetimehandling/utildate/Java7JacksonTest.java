package com.arcesium.datetime.datetimehandling.utildate;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class Java7JacksonTest {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Date date1 = new Date();
        System.out.println("Date to be serialized: " + date1);
        System.out.println("Timestamp of the date: " + date1.getTime());
        System.out.println("------------------------------");

        ObjectMapper mapper = new ObjectMapper();
        String date1Str = mapper.writeValueAsString(date1);
        System.out.println("Serialized string with jackson with default settings: " + date1Str);

        Date date2 = mapper.readValue(date1Str, Date.class);
        System.out.println("Deserialized string with jackson with default settings: " + date2);
        System.out.println("------------------------------");

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        date1Str = mapper.writeValueAsString(date1);
        System.out.println("Serialized string with jackson in ISO format: " + date1Str);

        date2 = mapper.readValue(date1Str, Date.class);
        System.out.println("Deserialized string with jackson in ISO format: " + date2);
        System.out.println("------------------------------");

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz"));

        date1Str = mapper.writeValueAsString(date1);
        System.out.println("Serialized string with jackson with set date format: " + date1Str);

        date2 = mapper.readValue(date1Str, Date.class);
        System.out.println("Deserialized string with jackson with set date format: " + date2);
        System.out.println("------------------------------");

        mapper = new ObjectMapper();
        SimpleModule testModule = new SimpleModule();
        testModule.addSerializer(Date.class, new CustomDateSerializer());
        testModule.addDeserializer(Date.class, new CustomDateDeserializer());
        mapper.registerModule(testModule);

        date1Str = mapper.writeValueAsString(date1);
        System.out.println("Serialized string with jackson with custom module: " + date1Str);

        date2 = mapper.readValue(date1Str, Date.class);
        System.out.println("Deserialized string with jackson with custom module: " + date2);
        System.out.println("------------------------------");
    }
}
