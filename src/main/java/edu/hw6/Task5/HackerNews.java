package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class HackerNews {
    private HackerNews() {
    }

    private static Pattern newsName = Pattern.compile(",\"title\":\"(.*)\",\"type\":\"");

    public static long[] hackerNewsTopStories() {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                .GET()
                .build();
            var response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return Arrays.stream(response.body().substring(1, response.body().length() - 1)
                    .split(","))
                .mapToLong(Long::parseLong).toArray();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            return new long[0];
        }
    }

    public static String news(long id) {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
                .GET()
                .build();
            var response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            Matcher matcher = newsName.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "";
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            return "";
        }
    }
}
