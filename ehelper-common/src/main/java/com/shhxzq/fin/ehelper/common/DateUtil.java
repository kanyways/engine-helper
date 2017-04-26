package com.shhxzq.fin.ehelper.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kangyonggan
 * @since 4/7/17
 */
public class DateUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final SimpleDateFormat fullDatetimeFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static String toXmlDateTime(Date date) {
        return dateFormat.format(date) + "T" + timeFormat.format(date) + "Z";
    }

    public static String getCurrentFullDateTime() {
        return fullDatetimeFormat.format(new Date());
    }
}
