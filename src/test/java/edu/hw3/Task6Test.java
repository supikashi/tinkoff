package edu.hw3;

import edu.hw3.Task6.PriorityQueueStockMarket;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Тест биржи 1")
    void MarketTest1() {
        // given
        PriorityQueueStockMarket market = new PriorityQueueStockMarket();

        // when
        market.add(new Stock("SBER", 269.7));
        market.add(new Stock("GAZP", 167.42));
        market.add(new Stock("YNDX", 2669.6));
        market.remove(new Stock("GAZP", 167.42));

        // then
        assertThat(market.mostValuableStock()).isEqualTo(new Stock("YNDX", 2669.6));
    }

    @Test
    @DisplayName("Тест биржи 2")
    void MarketTest2() {
        // given
        PriorityQueueStockMarket market = new PriorityQueueStockMarket();

        // when
        market.add(new Stock("SBER", 269.7));
        market.add(new Stock("GAZP", 167.42));
        market.add(new Stock("YNDX", 2669.6));
        market.remove(new Stock("YNDX", 2669.6));

        // then
        assertThat(market.mostValuableStock()).isEqualTo(new Stock("SBER", 269.7));
    }

    @Test
    @DisplayName("Тест биржи 3")
    void MarketTest3() {
        // given
        PriorityQueueStockMarket market = new PriorityQueueStockMarket();

        // when
        market.add(new Stock("YNDX", 2669.6));
        market.remove(new Stock("YNDX", 2669.6));

        // then
        assertThat(market.mostValuableStock()).isEqualTo(null);
    }
}
