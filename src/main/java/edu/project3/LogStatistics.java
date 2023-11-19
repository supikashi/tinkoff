package edu.project3;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class LogStatistics {
    private final List<LogRecord> data;

    public LogStatistics(List<LogRecord> data) {
        this.data = data;
    }

    public LogStatistics(List<LogRecord> data, LocalDateTime from, LocalDateTime to) {
        this(data.stream().filter(x -> !x.date().isBefore(from) && !x.date().isAfter(to)).toList());
    }

    public int getNumberOfRequests() {

        return data.size();
    }

    public List<Map.Entry<String, Integer>> mostPopularResources() {
        Map<String, Integer> map = new HashMap<>();
        for (LogRecord log : data) {
            map.compute(log.requestedResource(), (k, v) -> (v == null) ? 1 : v + 1);
        }
        return map.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .toList();
    }

    public List<Map.Entry<Integer, Integer>> mostPopularResponseCodes() {
        Map<Integer, Integer> map = new HashMap<>();
        for (LogRecord log : data) {
            map.compute(log.responseCode(), (k, v) -> (v == null) ? 1 : v + 1);
        }
        return map.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .toList();
    }

    public OptionalDouble averageResponseSize() {
        return data.stream().mapToInt(LogRecord::responseSize).average();
    }
}
