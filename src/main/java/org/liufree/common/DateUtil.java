package org.liufree.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dny on 2017/6/9.
 */
public class DateUtil {
    /** 默认的格式化方式 */
    private static final String defaultFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String format = "yyyy-MM-dd";

    public static String getStringDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(defaultFormat);
        Date currentDate = new Date();
        String formatCurrentDate = dateFormat.format(currentDate).toString();

        return formatCurrentDate;
    }

    public static Date getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(defaultFormat);
        try {
            return dateFormat.parse(getStringDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    public static Date fomat(String dateString){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
