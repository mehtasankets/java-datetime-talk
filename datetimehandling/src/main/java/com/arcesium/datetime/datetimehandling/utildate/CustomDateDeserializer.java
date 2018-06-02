package com.arcesium.datetime.datetimehandling.utildate;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String dateStr = p.getText();
        if (dateStr.startsWith("Date(") && dateStr.endsWith(")")) {
            dateStr = dateStr.substring(dateStr.indexOf("Date(") + 5);
            dateStr = dateStr.substring(0, dateStr.length() - 1);
            // System.out.println(dateStr);
            return new Date(Long.parseLong(dateStr));
        }
        return super.deserialize(p, ctxt, null);
    }

}