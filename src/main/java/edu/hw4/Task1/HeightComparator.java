package edu.hw4.Task1;

import edu.hw4.Animal;
import java.util.Comparator;

public class HeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.height() - o2.height();
    }
}
