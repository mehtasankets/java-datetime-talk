# Know thy self, know thy enemy

## Questions/Statement to ponder on

### In what ways can one create a `java.util.Date` object?

Compare and contrast between pre-jdk8 and post-jdk methods

### What is the default timezone of a JVM?

### What is the canonical source of TZ strings?

As an example, what is the correct string to be used for the New York timezone. What is the difference between `UTC` and `GMT`.

Reference to the source of timezones:
`strings /usr/local/java/jdk9/lib/tzdb.dat | grep UTC` ==> `Etc/UTC`

### What is a `java.util.Calendar`?

What is a Gregorian calendar? Are there some other calendars in vogue in the JVM?

### What is the difference between `java.util.Date` and `java.util.Calendar`?

Date arithmetic deprecated in `java.util.Date`

### What is a `java.sql.Date`?

Precision difference.

### What is the `toString` implementation of `java.util.Date` and `java.sql.Date`?

### What are some of the deprecated methods of `java.util.Date`?

If you are using deprecated methods of `java.util.Date`, you are almost always doing something incorrect.

### What is `joda-time` library?

Is it still relevant?

### What is `java.time.Instant`?

What is the relation to `java.util.Date`?

### What is `deshaw.common.util.Day`?

Discuss use of `deshaw.commmon.datelib.defaultLibraryPath`

### What are the database types available to represent date and time?

Discuss mssql and postgres data types:

* https://msdn.microsoft.com/en-us/library/ms378878(v=sql.110).aspx
* https://documentation.progress.com/output/DataDirect/DataDirectCloud/index.html#page/queries/postgresql-data-types.html

### What are the jdbc types available to represent date and time?

### If db datatype doesn't have a timezone, what does mybatis do to create a `java.util.Date` from it?

Similiarly, what does mybatis do when a `java.util.Date` is to be converted to a db datatype that doesn't have timezone.

### What is the default serialization format for `java.util.Date` by jackson?

Discuss ISO-8601 format, and need for optimized network payload using epochs.

### Does jackson support serialization/deserialization of java.time.* classes?

### Should I ever convert a `java.util.Date` to another `java.util.Date` object using a `java.util.Calendar`?

Discuss with concrete example

### Why is dropping the time part from a `java.util.Date` not safe without considering timezone?

### How should we display dates/times in our webapps?

## References:

* https://codeblog.jonskeet.uk/2017/04/23/all-about-java-util-date/
* https://hackernoon.com/going-on-a-date-with-java-9bdac2c950b3
* https://msdn.microsoft.com/en-us/library/ms378878(v=sql.110).aspx
* https://documentation.progress.com/output/DataDirect/DataDirectCloud/index.html#page/queries/postgresql-data-types.html

