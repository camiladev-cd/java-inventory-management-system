package com.camila.dev;

public class Product {

    private static int productCounter;
    private int id;
    private String name;
    private double price;
    private int stock;
    private Category category;

    public Product( String name, double price, int stock, Category category) {
        productCounter++;
        this.id = productCounter;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public Category getCategory() { return category; }

    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        String availability = (stock > 0 ? "DISPONIBLE" : "AGOTADO");
        return id + ". " + availability + " " + name + " " + price + " " + stock + " " + category + ")";
    }

}

