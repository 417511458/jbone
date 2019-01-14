package cn.jbone.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil extends DateUtils {


	private final static String DATE_FORMAT = "yyyy-MM-dd";

    private final static String DATEPICKER_FORMAT = "MM/dd/yyyy";

    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static Date getDate(String pattern){
        if(pattern == null){
            return null;
        }
        SimpleDateFormat dateFormat = null;
        if(pattern.indexOf("/") != -1){
            dateFormat = new SimpleDateFormat(DATEPICKER_FORMAT);
        }else{
            dateFormat = new SimpleDateFormat(DATE_FORMAT);
        }
        try {
            return dateFormat.parse(pattern);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 根据格式得到格式化后的日期
     *
     * @param date    要格式化的日期
     * @param pattern 日期格式，如yyyy-MM-dd
     * @return String 返回格式化后的日期，格式由参数<code>format</code>
     * 定义，如yyyy-MM-dd，如2006-02-15
     */

    public static String formateDate(Date date, String pattern) {
        if (null == date) {
            return StringUtils.EMPTY;
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(pattern);
            return dtFormatdB.format(date);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            try {
                return dtFormatdB.format(date);
            } catch (Exception ex) {
            }
        }
        return null;
    }



}
