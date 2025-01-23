package stockmarketsim;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockMarketSimulation {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        //add some stocks 
        market.addStock(new Stock("AAPL", 150, 1000));
        market.addStock(new Stock("GOOG", 2800, 500));
        market.addStock(new Stock("TSLA", 700, 800));

        //create a thread pool for traders
        ExecutorService executor = Executors.newFixedThreadPool(5);

        //add traders
        for (int i = 1; i <= 5; i++){
            executor.submit(new Trader("Trader-" + i, market));
        }

        executor.shutdown();
        while (!executor.isTerminated()){
            //wait for all threads to finish 
        }

        //print the final market summary 
        market.printStockSummary();
    }
}
