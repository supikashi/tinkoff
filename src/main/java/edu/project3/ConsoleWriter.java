package edu.project3;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.util.Strings;
import static java.lang.Math.max;

@SuppressWarnings({"RegexpSinglelineJava", "MagicNumber", "MultipleStringLiterals"})
public class ConsoleWriter {
    private ConsoleWriter() {
    }

    public static void printGeneralInformation(
        LocalDateTime from, LocalDateTime to, int numberOfRequests, int averageResponseSize) {
        System.out.println("\n#### Общая информация\n");
        System.out.printf("| %-21s | %-16s |\n", "Метрика", "Значение");
        System.out.println("|-----------------------|------------------|");
        System.out.printf("| %-21s | %-16s |\n", "Начальная дата", from.toString());
        System.out.printf("| %-21s | %-16s |\n", "Конечная дата", to.toString());
        System.out.printf("| %-21s | %-16d |\n", "Количество запросов", numberOfRequests);
        System.out.printf("| %-21s | %-16d |\n", "Средний размер ответа", averageResponseSize);

    }


    public static void printMostPopularResources(List<Map.Entry<String, Integer>> data) {
        int maxLength1 = max(data.stream()
            .mapToInt(x -> x.getKey().length())
            .max().orElse(6), 6);
        int maxLength2 = max(data.stream()
            .mapToInt(x -> x.getValue().toString().length())
            .max().orElse(10), 10);
        System.out.println("\n#### Запрашиваемые ресурсы\n");
        System.out.printf("| %-" + maxLength1 + "s | %-" + maxLength2 + "s |\n", "Ресурс", "Количество");
        System.out.println("|" + Strings.repeat("-", maxLength1 + 2) + "|" + Strings.repeat("-", maxLength2 + 2) + "|");
        data.forEach(x -> {
            System.out.printf("| %-" + maxLength1 + "s | %-" + maxLength2 + "s |\n", x.getKey(), x.getValue());
        });
    }

    public static void printMostPopularResponseCodes(List<Map.Entry<Integer, Integer>> data) {
        int maxLength = max(data.stream()
            .mapToInt(x -> x.getValue().toString().length())
            .max()
            .orElse(10), 10);
        System.out.println("\n#### Коды ответа\n");
        System.out.printf("| %-3s | %-" + maxLength + "s |\n", "Код", "Количество");
        System.out.println("|-----|" + Strings.repeat("-", maxLength + 2) + "|");
        data.forEach(x -> {
            System.out.printf("| %-3s | %-" + maxLength + "s |\n", x.getKey(), x.getValue());
        });
    }
}
