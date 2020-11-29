package store.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Basket {" + basket + '}';
    }
}
