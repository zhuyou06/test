package com.cubc.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter BASICE_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public static String formatDateTime(String dateTime) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateTime);
        LocalDateTime localDateTime = offsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Taipei")).toLocalDateTime();
        return localDateTime.format(BASICE_FORMAT);
    }
}
