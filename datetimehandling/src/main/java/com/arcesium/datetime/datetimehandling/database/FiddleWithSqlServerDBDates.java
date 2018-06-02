package com.arcesium.datetime.datetimehandling.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

public class FiddleWithSqlServerDBDates {

    public static void main(String[] args) {
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            Date date = new Date(0);
            System.out.println(date);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

            insertDates("DBCLDEV1DS5", timestamp);
            insertDates("PALIO", timestamp);

            readDates("DBCLDEV1DS5");
            readDates("PALIO");

            TimeZone.setDefault(TimeZone.getTimeZone("EST5EDT"));
            readDates("DBCLDEV1DS5");
            readDates("PALIO");

            System.out.println("Goodbye!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertDates(String dbServerName, java.sql.Timestamp timestamp) throws Exception {

        Properties connectionProps = new Properties();
        connectionProps.put("applicationName", "reporting_infra");
        connectionProps.put("useKerberos", "true");
        Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + dbServerName + "/reporting_infra",
                connectionProps);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS ZZZZZ")
                .withZone(ZoneId.systemDefault());

        PreparedStatement s = conn.prepareStatement("INSERT INTO test_date_time(mydate, mydatetime, mydatetime2, "
                + "mydatetimeoffset, mysmalldatetime, mytime) values (?,?,?,?,?,?)");
        s.setTimestamp(1, timestamp);
        s.setTimestamp(2, timestamp);
        s.setTimestamp(3, timestamp);
        // s.setTimestamp(4, timestamp); <-- This doesn't work correctly
        s.setString(4, dtf.format(timestamp.toInstant()));
        s.setTimestamp(5, timestamp);
        s.setTimestamp(6, timestamp);
        s.executeUpdate();
        conn.close();
    }

    private static void readDates(String dbServerName) throws Exception {
        Properties connectionProps = new Properties();
        connectionProps.put("applicationName", "reporting_infra");
        connectionProps.put("useKerberos", "true");
        Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + dbServerName + "/reporting_infra",
                connectionProps);

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT TOP 1 * FROM test_date_time ORDER BY mytimestamp DESC");
        while (rs.next())
            System.out.printf("||%s||%s||%s||%s||%s||%s||%s||%n", new Date(rs.getTimestamp(1).getTime()),
                    new Date(rs.getTimestamp(2).getTime()), new Date(rs.getTimestamp(3).getTime()), rs.getString(4),
                    new Date(rs.getTimestamp(5).getTime()), new Date(rs.getTimestamp(6).getTime()), rs.getString(7));

        rs.close();
        s.close();
        conn.close();
    }
}
