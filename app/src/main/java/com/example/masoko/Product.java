package com.example.masoko;

public class Product {

    private String id;
    private String name;
    private String price;
    private String category;
    private String brand;
    private String quantity;
    private String units;

    public Product(){

    }

    public Product(String id, String name, String price, String category, String brand, String quantity, String units) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnits() {
        return units;
    }
}
