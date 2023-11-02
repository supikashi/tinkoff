package edu.hw3.Task6;

import java.util.Comparator;

public class StocksComparator implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
        return (int) -(o1.value() - o2.value());
    }
}
