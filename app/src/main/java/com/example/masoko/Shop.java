package com.example.masoko;

public class Shop {
    private String id;
    private String shoppermit;
    private String pin;
    private String location;
    private String delivery;


    public Shop(){

    }

    public Shop(String id, String shoppermit, String pin, String location, String delivery) {
        this.id = id;
        this.shoppermit = shoppermit;
        this.pin = pin;
        this.location = location;
        this.delivery = delivery;
    }

    public String getId() {
        return id;
    }

    public String getShoppermit() {
        return shoppermit;
    }

    public String getPin() {
        return pin;
    }

    public String getLocation() {
        return location;
    }

    public String getDelivery() {
        return delivery;
    }
}
