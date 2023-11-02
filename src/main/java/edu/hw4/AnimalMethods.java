package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalMethods {
    private AnimalMethods() {
    }

    public static List<Animal> sortByHeight(Collection<Animal> collection) {
        return collection.stream().sorted((o1, o2) -> o1.height() - o2.height()).collect(Collectors.toList());
    }

    public static List<Animal> getTheHeaviestAnimals(Collection<Animal> collection, int k) {
        return collection.stream().sorted((o1, o2) -> o2.weight() - o1.weight()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> Task3(Collection<Animal> collection) {
        Map<Animal.Type, Integer> map = new HashMap<>();
        Arrays.stream(Animal.Type.values()).forEach(x -> map.put(x, 0));
        collection.forEach(x -> map.compute(x.type(), (a, b) -> b + 1));
        return map;
    }

    /*public static Animal Task4(Collection<Animal> collection) {
        Animal animal = ;
        return collection.stream().
    }*/
}
