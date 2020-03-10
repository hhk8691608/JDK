package com.ace.Date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/***
 *
 *@Author Mark
 *@Date 2020/3/10 11 58
 *@Source 慕课网
 *@Desciption
 * //1. LocalDate、LocalTime、LocalDateTime
 * 2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
 */
public class LocalDate {

    @Test
    public void test1(){

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toString());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);


    }






    @Test
    public void test2(){

//        LocalDateTime ldt = LocalDateTime.of(2016,10,26,11,20);
//        System.out.println(ldt.toString());
//
//        LocalTime localTime = LocalTime.of(3,3,10);
//        System.out.println(localTime);
//
//        LocalDateTime localDateTime = LocalDateTime.of(2020,3,10,13,48,55);
//        System.out.println(localDateTime);



        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        System.out.println(ld2);

        LocalDateTime ldt3 = ld2.plusYears(4);
        System.out.println(ldt3);


        LocalDateTime ldt4 = ld2.minusMonths(2);
        System.out.println(ldt4);

        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());



    }



    @Test
    public void test3(){

        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);


        System.out.println(ins.getNano());

        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println(ins2);

    }


    @Test
    public void test5(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        LocalDateTime newLdt = ldt.parse(strDate,dtf);
        System.out.println(newLdt);

    }






}
