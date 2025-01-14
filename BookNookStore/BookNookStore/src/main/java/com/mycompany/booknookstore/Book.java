/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booknookstore;

/**
 *
 * @author User
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int salesCount;  // Tracks sales of this book
    private Category category;

    public Book(int id, String title, String author, double price, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.salesCount = 0;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getSalesCount() { return salesCount; }
    public Category getCategory() { return category; }

    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void incrementSalesCount() { salesCount++; }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author +
               ", Price: $" + price + ", Category: " + category.getName();
    }
}

