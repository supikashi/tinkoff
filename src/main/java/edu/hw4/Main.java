package edu.hw4;

import edu.hw4.Task1.HeightComparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] argc) {
        List<Animal> list = new ArrayList<>(List.of(new Animal("qwe", Animal.Type.BIRD, Animal.Sex.F, 1, 2, 9, true)
            , new Animal("qwerty", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 10, true)));
        System.out.println(AnimalMethods.sortByHeight(list));
        System.out.println(list);
        System.out.println(AnimalMethods.getTheHeaviestAnimals(list, 1));
        System.out.println(Arrays.toString(Animal.Type.values()));
        System.out.println(AnimalMethods.Task3(list));
        //List<Integer> userList = Arrays.asList(9, 8, 7, 65, 4, 3, 2, 1);
        //userList.stream().sorted().collect(Collectors.toList());
        //System.out.println(userList.stream().sorted().toList());
        //System.out.println(userList.stream().sorted().collect(Collectors.toList()));

    }
}
