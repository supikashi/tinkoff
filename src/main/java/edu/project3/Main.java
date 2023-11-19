package edu.project3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        String link = "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";
        String strFrom = "2015-05-17T00:00:00";
        String strTo = "2015-05-18T00:00:00";

        var formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime from = LocalDateTime.parse(strFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(strTo, formatter);

        var data = LogParser.logParse(HttpLogsGetter.getLogs(link));
        LogStatistics stats = new LogStatistics(data, from, to);

        ConsoleWriter.printGeneralInformation(from, to, stats.getNumberOfRequests(),
            (int) stats.averageResponseSize().orElse(-1));
        ConsoleWriter.printMostPopularResources(stats.mostPopularResources());
        ConsoleWriter.printMostPopularResponseCodes(stats.mostPopularResponseCodes());
    }
}
