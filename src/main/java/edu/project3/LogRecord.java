package edu.project3;

import java.time.LocalDateTime;

public record LogRecord(LocalDateTime date, int responseCode, int responseSize, String requestedResource) {
}
