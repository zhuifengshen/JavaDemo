package mike.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Devin on 8/16/2016.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        Calendar birth = Calendar.getInstance();
        birth.set(1991, Calendar.AUGUST, 1);
        Calendar now = Calendar.getInstance();
        System.out.println(daysBetween(birth, now));
        System.out.println(birth.equals(now));

        Clock clock = Clock.systemDefaultZone();//Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);

        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zoneId1 = ZoneId.of("Europe/Berlin");
        ZoneId zoneId2 = ZoneId.of("Brazil/East");
        System.out.println(zoneId1.getRules());
        System.out.println(zoneId2.getRules());

        LocalTime time = LocalTime.now();
        LocalTime timeClock = LocalTime.now(clock);
        LocalTime timeZone = LocalTime.now(zoneId1);
        System.out.println(time);
        System.out.println(timeClock);
        System.out.println(timeZone);

        LocalTime localTime = LocalTime.of(22, 12, 18);
        System.out.println(localTime);
        DateTimeFormatter geermanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("12:03", geermanFormatter);
        System.out.println(leetTime);

        LocalDate localDate = LocalDate.now();
        LocalDate localDateClock = LocalDate.now(clock);
        //DateTimeFormatter geermanFormatter1 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        DateTimeFormatter geermanFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate parseLocalDate = LocalDate.parse("16.08.2016", geermanFormatter1);
        System.out.println(localDate);
        System.out.println(localDateClock);
        System.out.println(parseLocalDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.now(clock);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        LocalDateTime guangzhou = LocalDateTime.of(2016, 12, 31, 23, 59, 59);
        System.out.println(guangzhou);
        DayOfWeek dayOfWeek = guangzhou.getDayOfWeek();
        System.out.println(dayOfWeek);
        Month month = guangzhou.getMonth();
        System.out.println(month);
        long minuteOfHour = guangzhou.getMinute();
        System.out.println(minuteOfHour);
        long minuteOfDay = guangzhou.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instantGuangzhou = guangzhou.atZone(ZoneId.systemDefault()).toInstant();
        Date dateGuangzhou = Date.from(instant);
        System.out.println(dateGuangzhou);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("05 03, 2006 - 07:13", formatter);
        System.out.println(formatter.format(parsed));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeClock = ZonedDateTime.now(clock);
        ZonedDateTime zonedDateTimeZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeClock);
        System.out.println(zonedDateTimeZone);

        LocalDateTime start = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2015, 4, 16,23, 59, 59);
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());

        LocalTime now1 = LocalTime.now(ZoneId.of("America/Cuiaba"));
        LocalTime now2 = LocalTime.now(ZoneId.of("Brazil/East"));
        long hours = ChronoUnit.HOURS.between(now1, now2);
        long minutes = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hours + "  " + minutes);

        Clock clockTime = Clock.systemUTC();
        System.out.println(clockTime);
        System.out.println(clockTime.instant());
        System.out.println(clockTime.millis());
    }

    private static long daysBetween(Calendar begin, Calendar end) {
        long days = 0;
        while (begin.before(end)){
            begin.add(Calendar.DAY_OF_MONTH, 1);
            days++;
        }
        return days;
    }
}
