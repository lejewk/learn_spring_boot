package com.devwook88.learn_spring_boot.model;

public class Product {
    private String color;
    private String name;
    private int price;

    public Product(String color, String name, int price) {
        this.color = color;
        this.name = name;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
