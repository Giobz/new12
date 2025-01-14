/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booknookstore;

/**
 *
 * @author User
 */
public class Accessory {
    private int id;
    private String name;
    private double price;
    private int salesCount;

    public Accessory(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.salesCount = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getSalesCount() { return salesCount; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void incrementSalesCount() { salesCount++; }

    @Override
    public String toString() {
        return "Accessory ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}
