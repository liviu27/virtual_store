package store.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Basket {" + basket + '}';
    }
}
