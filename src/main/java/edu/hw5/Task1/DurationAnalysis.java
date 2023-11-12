package edu.hw5.Task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public class DurationAnalysis {
    private DurationAnalysis() {
    }

    public static Duration getAverageDuration(@NotNull Collection<String> data) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        long minutes = (long) data.stream().mapToLong(str -> {
            String[] splited = str.split(" - ");
            if (splited.length != 2) {
                throw new IllegalArgumentException();
            }
            LocalDateTime start = LocalDateTime.parse(splited[0], formatter);
            LocalDateTime end = LocalDateTime.parse(splited[1], formatter);
            if (start.isAfter(end)) {
                throw new IllegalArgumentException();
            }
            return Duration.between(start, end).toMinutes();
        }).average().orElse(-1);
        return Duration.ofMinutes(minutes);
    }
}
