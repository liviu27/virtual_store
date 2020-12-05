package store.repo;

import store.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum StockRepository {
    STOCK_REPOSITORY;

    private Map<String, Product> storeStock = new HashMap<>();

    public void addProductToStock(Product product) {
        storeStock.put(product.getName(), product);
    }

    public void updateStock(String productName, int quantity) {
        storeStock.get(productName).setQuantity(quantity);
    }

    public Product getProductByName(String productName) {
        return storeStock.get(productName);
    }

    public List<Product> getAllProductsAlphabetically() {
        return storeStock.values().stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
    }


    public void printStock(){ // test method
        System.out.println(storeStock);
    }



}
