/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.memberb;

/**
 *
 * @author User
 */
public class User {
    
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() { return username; }
    public boolean checkPassword(String password) { return this.password.equals(password); }
    public boolean isAdmin() { return isAdmin; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Username: " + username + ", Role: " + (isAdmin ? "Admin" : "User");
    }


    
}
