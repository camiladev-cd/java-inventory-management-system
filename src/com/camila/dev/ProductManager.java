package com.camila.dev;

import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> productList;

    public ProductManager(){ this.productList = new ArrayList<>(); }

    public void addProduct(Product newProduct) {productList.add(newProduct); }

    public ArrayList<Product> getProducts() { return new ArrayList<>(productList); }

    public boolean deleteProduct(int productId) { return productList.removeIf(p -> p.getId() == productId); }

    public Product findProductById(int productId) {
        for (Product p : productList) {
            if (p.getId() == productId) {
                return p;
            }
        }
        return null;
    }
}


