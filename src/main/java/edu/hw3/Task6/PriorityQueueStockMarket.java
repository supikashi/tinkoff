package edu.hw3.Task6;

import java.util.PriorityQueue;

public class PriorityQueueStockMarket implements StockMarket {
    private final PriorityQueue<Stock> storage = new PriorityQueue<>(new StocksComparator());

    @Override
    public void add(Stock stock) {
        if (stock != null) {
            storage.offer(stock);
        }
    }

    @Override
    public void remove(Stock stock) {
        storage.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return storage.peek();
    }
}
