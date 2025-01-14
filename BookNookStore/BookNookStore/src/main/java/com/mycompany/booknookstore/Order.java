/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booknookstore;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<String> items = new ArrayList<>();
    private double totalAmount = 0;

    public void addItem(String itemName, double price) {
        items.add(itemName);
        totalAmount += price;
    }

    public void viewOrderHistory() {
        System.out.println("Order History:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

