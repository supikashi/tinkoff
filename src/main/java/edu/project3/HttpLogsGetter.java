package edu.project3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;
import static java.net.http.HttpClient.newHttpClient;

public class HttpLogsGetter {
    private HttpLogsGetter() {
    }

    public static Stream<String> getLogs(String url) {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
            return newHttpClient().send(request, HttpResponse.BodyHandlers.ofLines()).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            return Stream.of();
        }
    }
}
