package com.arcesium.datetime.datetimehandling.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.TimeZone;

public class FiddleWithPostgresDBDates {

    public static void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");

            Date date = new Date(0);
            System.out.println(date);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

            insertDates("narada09.hdc1.des.co:20056",timestamp);
            insertDates("marconi09.toa.des.co:20056",timestamp);

            readDates("narada09.hdc1.des.co:20056");
            readDates("marconi09.toa.des.co:20056");

            TimeZone.setDefault(TimeZone.getTimeZone("EST5EDT"));
            readDates("narada09.hdc1.des.co:20056");
            readDates("marconi09.toa.des.co:20056");

            System.out.println("Goodbye!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertDates(String dbServerName, java.sql.Timestamp timestamp) throws Exception {

        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + dbServerName + "/test", "mehtasan",
                "test_mehtasan");

        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS ZZZZZ")
        // .withZone(ZoneId.systemDefault());

        PreparedStatement s = conn.prepareStatement("INSERT INTO test_date_time( mytimestamp, mytimestamptz, mydate, "
                + "mytime, mytimetz) values (?,?,?,?,?)");
        s.setTimestamp(1, timestamp);
        s.setTimestamp(2, timestamp);
        s.setTimestamp(3, timestamp);
        s.setTimestamp(4, timestamp);
        s.setTimestamp(5, timestamp);
        s.executeUpdate();
        conn.close();
    }

    private static void readDates(String dbServerName) throws Exception {

        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + dbServerName + "/test", "mehtasan",
                "test_mehtasan");

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM test_date_time ORDER BY mytimestamp DESC LIMIT 1");
        while (rs.next())
            System.out.printf("||%s||%s||%s||%s||%s||%n", new Date(rs.getTimestamp(1).getTime()),
                    new Date(rs.getTimestamp(2).getTime()), new Date(rs.getTimestamp(3).getTime()), rs.getString(4),
                    new Date(rs.getTimestamp(5).getTime()));

        rs.close();
        s.close();
        conn.close();
    }
}
