package store.service;

import store.model.Product;

import java.util.List;

import static store.repo.StockRepository.STOCK_REPOSITORY;

public enum StockService {
    STOCK_SERVICE;

    public void addNewProduct(Product product) {
        STOCK_REPOSITORY.addProductToStock(product);
    }

    public List<Product> getAllProductsInStock() {
        return STOCK_REPOSITORY.getAllProductsAlphabetically();
    }

    public void setStock(String productName, int quantity) {
        STOCK_REPOSITORY.updateStock(productName, quantity);
    }

    public void listStock(){ // test method
        STOCK_REPOSITORY.printStock();
    }

}
