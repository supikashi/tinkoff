package edu.hw4;

import org.jetbrains.annotations.NotNull;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalMethods {
    private AnimalMethods() {
    }

    public static List<Animal> task1(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> task2(@NotNull Collection<Animal> collection, int k) {
        return collection.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(@NotNull Collection<Animal> collection) {
        Map<Animal.Type, Integer> map = new HashMap<>();
        Arrays.stream(Animal.Type.values()).forEach(x -> map.put(x, 0));
        collection.forEach(x -> map.compute(x.type(), (a, b) -> b + 1));
        return map;
    }

    public static Animal task4(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .max(Comparator.comparingInt(x -> x.name().length()))
            .orElse(null);
    }

    public static Animal.Sex task5(@NotNull Collection<Animal> collection) {
        int sum = collection.stream()
            .mapToInt(x -> x.sex().equals(Animal.Sex.M) ? 1 : -1)
            .sum();
        return (sum > 0) ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> task6(@NotNull Collection<Animal> collection) {
        Map<Animal.Type, Animal> map = new HashMap<>();
        Arrays.stream(Animal.Type.values()).forEach(x -> map.put(x, null));
        collection.forEach(x -> map.compute(x.type(), (a, b) -> (b == null || x.weight() > b.weight()) ? x : b));
        return map;
    }

    public static Animal task7(@NotNull Collection<Animal> collection, int k) {
        List<Animal> list = collection.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .toList();
        return (list.size() < k) ? null : list.get(k - 1);
    }

    public static Optional<Animal> task8(@NotNull Collection<Animal> collection, int k) {
        return collection.stream()
            .filter(x -> x.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> task10(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .filter(x -> x.age() != x.paws())
            .toList();
    }

    public static List<Animal> task11(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .filter(Animal::bites)
            .filter(x -> x.height() > 100)
            .toList();
    }

    public static Integer task12(@NotNull Collection<Animal> collection) {
        return (int) collection.stream()
            .filter(x -> x.weight() > x.height())
            .count();
    }

    public static List<Animal> task13(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .filter(x -> x.name().split(" ").length > 2)
            .toList();
    }

    public static Boolean task14(@NotNull Collection<Animal> collection, int k) {
        return collection.stream()
            .anyMatch(x -> x.type().equals(Animal.Type.DOG) && x.height() > k);
    }

    public static @NotNull Map<Animal.Type, Integer> task15(Collection<Animal> collection, int k, int l) {
        Map<Animal.Type, Integer> map = new HashMap<>();
        Arrays.stream(Animal.Type.values()).forEach(x -> {
            map.put(x, collection.stream().filter(y -> y.type().equals(x))
                .filter(y -> k <= y.age() && y.age() < l)
                .mapToInt(Animal::weight).sum());
        });
        return map;
    }

    public static List<Animal> task16(@NotNull Collection<Animal> collection) {
        return collection.stream()
            .sorted(Comparator
            .comparing(Animal::type)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::name))
            .toList();
    }

    public static Boolean task17(@NotNull Collection<Animal> collection) {
        OptionalDouble spiderBites = collection.stream()
            .filter(x -> x.type().equals(Animal.Type.SPIDER))
            .mapToInt(x -> x.bites() ? 1 : 0).average();
        OptionalDouble dogBites = collection.stream()
            .filter(x -> x.type().equals(Animal.Type.DOG))
            .mapToInt(x -> x.bites() ? 1 : 0).average();
        if (spiderBites.isEmpty() || dogBites.isEmpty()) {
            return false;
        } else {
            return spiderBites.getAsDouble() > dogBites.getAsDouble();
        }
    }

    public static Animal task18(Collection<Animal>... collections) {
        return Arrays.stream(collections)
            .flatMap(Collection::stream)
            .filter(x -> x.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    //public static Map<String, Set<ValidationError>> Task19(Collection<Animal> collection) {

    //}
}
