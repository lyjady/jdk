package com.example.time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author LinYongJin
 * @date 2020/1/2 14:47
 */
public class Test2 {

    public static void main(String[] args) {
        String dateStr = "2019-12-16 15:36:45";
        String format = "yyyy-MM-dd HH:mm:ss";

        //1.String -> LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime str2Local = LocalDateTime.parse(dateStr, formatter);
        System.out.println(str2Local);

        //2.LocalDateTime -> String
        String date2Str = formatter.format(LocalDateTime.now());
        System.out.println(date2Str);

        //3.Date -> LocalDateTime (Date -> String -> LocalDateTime)
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);

        //4.LocalDateTime -> Date (LocalDateTime -> String -> Date)
        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(from);
    }
}
