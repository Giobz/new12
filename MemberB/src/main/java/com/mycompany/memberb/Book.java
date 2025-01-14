/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.memberb;

public class Book {
    
    private String title;
    private String author;
    private Category category; // This has to remain a Category object.
    private double price;

    public Book(String title, String author, Category category, double price) {
        this.title = title;
        this.author = author;
        this.category = category; // Assign directly.
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Category: " + category + ", Price: $" + price;
    }
}
