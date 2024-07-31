package edu.wgu.d387_sample_code.addservices;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class TimeConv {

    public String convertTimes(ZonedDateTime dateTime) {
        ZonedDateTime etTime = dateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime mtTime = dateTime.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utcTime = dateTime.withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return "ET: " + etTime.format(formatter) + ", MT: " + mtTime.format(formatter) + ", UTC: " + utcTime.format(formatter);
    }
}
