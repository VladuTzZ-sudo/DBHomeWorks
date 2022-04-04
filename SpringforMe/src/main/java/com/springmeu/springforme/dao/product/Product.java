package com.springmeu.springforme.dao.product;

public class Product {
    private int id;
    private String code;
    private String name;
    private String description;
    private int stock;
    private double price;

    public Product(String code, String name, String description, int stock, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
