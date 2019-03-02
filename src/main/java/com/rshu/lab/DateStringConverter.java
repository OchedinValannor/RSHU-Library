package com.rshu.lab;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateStringConverter {

    private static String datePattern;
    private static Locale locale;
    private static DateFormat dateFormat;

    static {
        datePattern = "dd.MM.yyyy";
        locale = Locale.ENGLISH;
        dateFormat = new SimpleDateFormat(datePattern, locale);
    }

    public static String convertToString(Date date) {
        return dateFormat.format(date);
    }
}
