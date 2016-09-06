package mike.java8;

import java.time.*;

/**
 * Created by Devin on 2016/7/14.
 */
public class NewTimeAPI {
    public static void main(String[] args){
        NewTimeAPI newTimeAPI = new NewTimeAPI();
        newTimeAPI.testLocalDateTime();
        newTimeAPI.testZoneDateTime();
    }

    public void testLocalDateTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间：" + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("当地日期：" + date1);
        System.out.println("月：" + currentTime.getMonth() + ", 日：" + currentTime.getDayOfMonth() + ", 时：" + currentTime.getHour());

        LocalDateTime date2  = currentTime.withDayOfMonth(10).withYear(2000);
        System.out.println(date2);

        LocalDate date3 = LocalDate.of(2222, Month.DECEMBER, 22);
        LocalTime date4 = LocalTime.of(11, 11);
        LocalTime date5 = LocalTime.parse("11:11:11");
        System.out.println(date3 + "\n" + date4 + "\n" + date5);
    }

    public void testZoneDateTime(){
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("ZoneDateTime:" + date1);
        ZoneId id = ZoneId.of("Europe/Paris");
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("时区：" + id + "\n当前系统时区：" + currentZone);
    }
}
