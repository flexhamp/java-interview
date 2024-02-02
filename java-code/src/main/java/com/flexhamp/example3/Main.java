package com.flexhamp.example3;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
////        ISum iSum = (a, b) -> a + b;
//        ISum iSum = Integer::sum;
//        iSum.sum(1, 2);

        LocalDateTime startDate = Instant.ofEpochMilli(1701088158549L)
                .atZone(ZoneId.of("GMT+3"))
                .toLocalDateTime();

        LocalDateTime endDate = Instant.ofEpochMilli(1706690538480L)
                .atZone(ZoneId.of("GMT+3"))
                .toLocalDateTime();

//        final long between = ChronoUnit.DAYS.between(startDate, endDate);
//        System.out.println(between + "days");

        Period period = Period.between(startDate.toLocalDate(), endDate.toLocalDate());
        Duration duration = Duration.between(startDate, endDate);

        System.out.println(
                period.getYears() + " years, " +
                        period.getMonths()  + " months, " +
                        period.getDays()  + " days, " +
                        duration.toHoursPart() + " hours, " +
                        duration.toMinutesPart()  + " minutes, " +
                        duration.toSecondsPart() + " seconds"
        );

//        final Date from = new Date(1702260529980L);
//        final Date to = new Date(1706690538480L);
//
//        Period.between(LocalDateTime.now(), LocalDateTime.now());
    }

    @FunctionalInterface
    public interface ISum {
        int sum(int a, int b);
    }
}
