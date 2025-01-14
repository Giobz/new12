/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booknookstore;

/**
 *
 * @author USER
 */
public class MainApp {
    public static void main(String[] args) {
        BookNookStore store = new BookNookStore();

        User adminUser = new User("admin", "admin123", false);
        store.setLoggedInUser(adminUser);

        // Start the user menu
        store.showUserMenu();
    }
}


