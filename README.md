# DateTime handling

To discuss about handling dates and timestamps in Java

## Structure of the session
* Session 1
    * Explain basic concepts
    * Repository of controversial statements

* Session 2
    * Migration plans (from bad to good date support)
    * Challenges with migrations
    * Best practices

## Basic concepts
* java.util.Date
* java.sql.Date
* org.joda.time
* java.time.*
* date serialization
* date deserialization
* system time
* date toString
* Cross system date management
* Formatting date as a string
* ISO-8601 format
* date constructors
* database level date data-types (postgres, sqlserver)
* Timezones (GMT vs UTC, EST vs EDT)
* Convert java8 dates <-> java.util dates
* Date conversions in persistance frameworks / ORMs
* Date arithmatics


## Repository of controversial statements
* java.util.Date always prints date in UTC timezone
* java.sql.Date represents just Date information (without time), unlike java.util.Date
