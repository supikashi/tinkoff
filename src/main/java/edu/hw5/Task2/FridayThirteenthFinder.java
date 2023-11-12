package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class FridayThirteenthFinder {
    private static final int MONTHS_IN_YEAR = 12;
    private static final int THIRTEENTH = 13;

    private FridayThirteenthFinder() {
    }

    public static Collection<LocalDate> getAllInYear(int year) {
        List<LocalDate> list = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, THIRTEENTH);
        for (int i = 0; i < MONTHS_IN_YEAR; i++) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                list.add(date);
            }
            date = date.plusMonths(1);
        }
        return list;
    }

    public static LocalDate getNext(@NotNull LocalDate date) {
        List<LocalDate> fridays = (List<LocalDate>) getAllInYear(date.getYear());
        for (var friday : fridays) {
            if (friday.isAfter(date)) {
                return friday;
            }
        }
        return getAllInYear(date.getYear() + 1).stream().toList().get(0);
    }
}
