package stockmarketsim;

import java.util.concurrent.atomic.AtomicInteger;

public class Stock {
    private final String name;
    private final AtomicInteger price;
    private final AtomicInteger quantity;

    public Stock (String name, int initialPrice, int initialQuantity) {
        this.name = name;
        this.price = new AtomicInteger(initialPrice);
        this.quantity = new AtomicInteger(initialQuantity);
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
        return price.get();
    }

    public void updatePrice(int delta){
        price.addAndGet(delta);
    }

    public boolean trade(int tradeQuantity) {
        if (quantity.get() >= tradeQuantity){
            quantity.addAndGet(-tradeQuantity);
            return true;
        }
        return false;
    }

    public int getQuantity(){
        return quantity.get();
    }

}
