package stockmarketsim;

import java.util.Random;

public class Trader implements Runnable {
    private final String traderName;
    private final StockMarket market;
    private final Random random = new Random();

    public Trader(String tradeName, StockMarket market) {
        this.traderName = tradeName;
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            String stockName = market.getRandomStockName();
            int quantity = random.nextInt(5) + 1;
            boolean isBuy = random.nextBoolean();

            if (isBuy) {
                market.buyStock(traderName, stockName, quantity);
            } else {
                market.buyStock(traderName, stockName, quantity);
            }

            try{
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
