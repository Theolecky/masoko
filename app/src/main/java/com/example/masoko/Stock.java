package com.example.masoko;

public class Stock {

    private String id;
    private String name;
    private String quantity;

    public Stock(){

    }

    public Stock(String id, String name, String quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }
}
