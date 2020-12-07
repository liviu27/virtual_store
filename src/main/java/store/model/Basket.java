package store.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public List<Product> getBasketContent() {
        return basket;
    }

    public void addToBasket(Product product) {
        basket.add(product);
    }

    @Override
    public String toString() {
        return "Basket {" + basket + '}';
    }
}
