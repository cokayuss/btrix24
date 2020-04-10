package com.btrix.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtilities {
    /**
     * MM - to specify month like: 01, 02, 03
     * MMM - to specify month like: Jan, Feb, Mar
     *
     * dd - to specify day, like: 01, 02, 03
     *
     * yyyy - to specify year like: 2010, 2020
     *
     * @param format for example MMM dd, yyyy = Mar 29, 2020
     * @return current date as a String
     */

    public static String getCurrentDate (String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public static String convertTo24HourTime(String time) throws ParseException {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = parseFormat.parse(time);
        return displayFormat.format(date);
    }

    /**
     * This method returns difference between end and start time
     * @param start time
     * @param end time
     * @param format like h:m a
     * @return difference between end time and start time as a long
     */
    public static long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
