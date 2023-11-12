package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class MyDateParser {
    private static final DateTimeFormatter[] FORMATTERS = {
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("yyyy-d-M"),
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("d/M/yy")};

    private MyDateParser() {
    }

    public static Optional<LocalDate> parseDate(@NotNull String string) {
        for (var formatter : FORMATTERS) {
            try {
                return Optional.of(LocalDate.parse(string, formatter));
            } catch (DateTimeParseException ignored) {
            }
        }

        Pattern pattern = Pattern.compile("^(\\d+) day ago$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(matcher.group(1))));
        }

        return switch (string) {
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default -> Optional.empty();
        };
    }
}
