package edu.project3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LogParser {
    private LogParser() {
    }

    private static final Pattern LOG_PATTERN =
        Pattern.compile(" - .* \\[(.*)] \".*\" (\\d{3}) (\\d+) \".*\" \"(.*)\"$");
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    @SuppressWarnings("MagicNumber")
    public static List<LogRecord> logParse(Stream<String> stream) {
        return stream.map(str -> {
            Matcher matcher = LOG_PATTERN.matcher(str);
            if (!matcher.find()) {
                throw new IllegalArgumentException();
            }
            return new LogRecord(LocalDateTime.parse(matcher.group(1), FORMATTER),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                matcher.group(4));
        }).toList();
    }
}
