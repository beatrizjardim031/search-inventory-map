package com.pluralsight;

public class Product {
    //fields
    private int id;
    private String name;
    private double price;

    //constructors
    public Product() {
    }
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

