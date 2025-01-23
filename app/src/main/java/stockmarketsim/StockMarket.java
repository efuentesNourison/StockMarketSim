package stockmarketsim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.checkerframework.checker.units.qual.radians;

public class StockMarket {
    private final Map<String, Stock> stocks = new ConcurrentHashMap<>();
    private final Random random = new Random();

    public void addStock(Stock stock){
        stocks.put(stock.getName(), stock);
    }

    public void buyStock(String traderName, String stockName, int quantity) {
        Stock stock = stocks.get(stockName);
        if (stock != null && stock.trade(quantity)) {
            System.out.println(traderName + " bought " + quantity + " units of " + stockName + " at $" + stock.getPrice());
            stock.updatePrice(1);
        }else{
            System.out.println(traderName + " failed to buy " + stockName + " (insufficient quantity or invalid stock).");
        }
    }

    public void sellStock(String tradeName, String stockName, int quantity){ 
        Stock stock = stocks.get(stockName);
        if(stock != null){
            System.out.println(tradeName + " sold " + quantity + " units of " + stockName + " at $" + stock.getPrice());
            stock.updatePrice(-1);
        } else {
            System.out.println(tradeName + " failed to sell " + stockName + " (invalid stock).");
        }
    }

    public String getRandomStockName() {
        List<String> stockNames = new ArrayList<>(stocks.keySet());
        return stockNames.get(random.nextInt(stockNames.size()));
    }

    public void printStockSummary() {
        System.out.println("=== Stock Market Summary ===");
        stocks.values().forEach(stock -> System.out.println(stock.getName() + ": $" + stock.getPrice() + ", Quantity: " + stock.getQuantity()));
    }
}
