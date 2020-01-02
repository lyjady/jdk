package com.example.time;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author LinYongJin
 * @date 2020/1/2 13:44
 */
public class Test1 {

    public static void main(String[] args) {
        //LocalDate(年月日)
        //获取当前的时间(getMonth()是获取到当前月份的英文名称)
        LocalDate localDate = LocalDate.now();
        System.out.println("年: " + localDate.getYear() + ", 月: " + localDate.getMonthValue() + ", 日: " + localDate.getDayOfMonth());
        System.out.println("--------------------------");
        //使用指定的年月日进行构造
        localDate = LocalDate.of(2019, 9, 7);
        System.out.println("年: " + localDate.getYear() + ", 月: " + localDate.getMonthValue() + ", 日: " + localDate.getDayOfMonth());
        System.out.println("--------------------------");

        //当月的天数
        System.out.println(localDate.lengthOfMonth());
        //当年的天数
        System.out.println(localDate.lengthOfYear());
        //是否闰年
        System.out.println(localDate.isLeapYear());
        System.out.println("--------------------------");

        //LocalTime(时分秒)
        LocalTime localTime = LocalTime.now();
        System.out.println("时: " + localTime.getHour() + ", 分: " + localTime.getMinute() + ", 秒: " + localTime.getSecond());
        System.out.println("--------------------------");

        //MonthDay(月日)
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay.getMonthValue() + " " + monthDay.getDayOfMonth());

        //plusDays()加上指定的天数
        localDate = localDate.plusDays(4);
        System.out.println(localDate);
        //plusMonths()加上指定的月份
        localDate = localDate.plusMonths(3);
        System.out.println(localDate);
        //plusYears()加上指定的年份
        localDate = localDate.plusYears(2);
        System.out.println(localDate);
        //plusWeeks()加上指定的周
        //LocalTime也拥有类似的api
        localDate = localDate.plusWeeks(4);
        System.out.println(localDate);
        //plus(3, ChronoUnit.DAYS)加上指定单位的指定数值的时间
        localDate = localDate.plus(3, ChronoUnit.DAYS);
        System.out.println(localDate);

        //.minus()对日期进行减操作,使用方法与plus一致
        localDate = localDate.minus(3, ChronoUnit.YEARS);
        System.out.println(localDate);
        System.out.println("---------------------------------------");

        //时间先后顺序的比较, 返回boolean类型
        System.out.println(LocalDate.of(2019, 9, 7).isAfter(LocalDate.of(2019, 1, 7)));
        System.out.println(LocalDate.of(2019, 9, 7).isBefore(LocalDate.of(2019, 1, 7)));


        System.out.println("---------------------------------------");
        //Clock时钟对象
        //得到默认的时区
        Clock clock = Clock.systemDefaultZone();
        //得到时区id
        System.out.println(clock.getZone());
        //得到当前的毫秒数
        System.out.println(clock.millis());
        System.out.println("---------------------------------------");

        //两个日期的差值
        Period period = Period.between(LocalDate.of(2019, 9, 1), LocalDate.now());
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        System.out.println("---------------------------------------");

        //with指定时间
        localDate = LocalDate.now();
        System.out.println(localDate.withYear(1997).withMonth(6).withDayOfMonth(10));
    }
}
