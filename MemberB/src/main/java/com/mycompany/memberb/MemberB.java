/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.memberb;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class MemberB {
    
    
    private ArrayList<User> users = new ArrayList<>();   //private List<User> users = new ArrayList<>();
    private User loggedInUser;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Accessory> accessories = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public MemberB() {
        // Populate sample data
        users.add(new User("Admin", "admin123", true));
        users.add(new User("User", "user123", false));
              
        
        
        // Sample categories with IDs
        categories.add(new Category(1, "Fiction"));
        
    }

    // login method to differentiate Admin from ordering users
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        // user validation checking
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                loggedInUser = user;
                System.out.println("Login successful. Welcome " + (loggedInUser.isAdmin() ? "Admin" : "User") + " " + username);
                return;
            } 
        }
        System.out.println("Invalid login. Try again.");
        login();
    }

    // menu applied to Admin user only
    public void showAdminMenu() {
        Scanner scanner = new Scanner(System.in);        
    while (true) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Add Accessory");
        System.out.println("3. Add Category");
        System.out.println("4. View Users");
        System.out.println("5. Edit User");
        System.out.println("6. Delete User");
        System.out.println("7. View Books");
        System.out.println("8. View Accessories");
        System.out.println("9. Logout");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> addBook();
            case 2 -> addAccessory();
            case 3 -> addCategory();
            case 4 -> viewUsers();
            case 5 -> editUser();
            case 6 -> deleteUser();
            case 7 -> viewBooks();
            case 8 -> viewAccessories();
            case 9 -> {
                loggedInUser = null;
                System.out.println("Logged out.");
                return;
            }
            default -> System.out.println("Invalid option.");
        }
      }
    }

    //program start, check loggeg and if Admin user
    public void start() {
        login();
        if (loggedInUser != null && loggedInUser.isAdmin()) {
            showAdminMenu();
        } else {
            System.out.println("User features not implemented yet.");
            login();
        }
    }
    
    //main method instantiate MemberB program logic
    public static void main(String[] args) {
        MemberB app = new MemberB();
        app.start();
    }
    
    // method insert book into book's arraylist
    public void addBook() {
        //user validation
    if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter book title: ");
    String title = scanner.nextLine();
    System.out.print("Enter author: ");
    String author = scanner.nextLine();
    
    System.out.println("Available categories:");
    for (Category cat : categories) {
        System.out.println(cat); // This will use the toString method defined in Category
    }
    
    System.out.print("Enter category ID: ");
    int categoryId = scanner.nextInt();
    
    // Find the category by ID
    Category selectedCategory = null;
    for (Category cat : categories) {
        if (cat.getId() == categoryId) {
            selectedCategory = cat;
            break;
        }
    }

    //category existent checking
    if (selectedCategory == null) {
        System.out.println("Category not found. Please add a new Category or choose an existent one.");
        return;
    }

    System.out.print("Enter price: ");
    double price = scanner.nextDouble();

    // Create and add the book
    Book newBook = new Book(title, author, selectedCategory, price);
    books.add(newBook);
    System.out.println("Book added successfully.");
}
    public void addAccessory() {
        //user validation        
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
        }
        
        Scanner scanner = new Scanner(System.in);
    System.out.print("Enter accessory name: ");
    String name = scanner.nextLine();
    //System.out.print("Enter category: ");
    //String category = scanner.nextLine();
    System.out.print("Enter price: ");
    double price = scanner.nextDouble();
    
    // Create and add accessory in the accessory's arrayList
    Accessory newAccessory = new Accessory(name, price);
    accessories.add(newAccessory);
    System.out.println("Accessory added successfully.");
    }
    
    public void addCategory() {
        // user validation
    if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter category ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    System.out.print("Enter category name: ");
    String name = scanner.nextLine();

    // Create and add the new category in the arraylist
    Category newCategory = new Category(id, name);
    categories.add(newCategory);
    System.out.println("Category added successfully.");
}
    
    public void viewUsers() {
        //user validation
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
        }
        // retrieving users registered
        System.out.println("List of registered users:");
        for (User user : users) {
        System.out.println(user);
        }
    }
    
    public void editUser() {
        //user validation
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username to edit: ");
        String username = scanner.nextLine();
        
        // setting new user details
        for (User user : users) {
        if (user.getUsername().equals(username)) {
            System.out.print("Enter new username: ");
            user.setUsername(scanner.nextLine());
            System.out.print("Enter new password: ");
            user.setPassword(scanner.nextLine());
            System.out.println("User updated successfully.");
            return;
        }
        }
        
       System.out.println("User not found.");
    }
    
    public void deleteUser() {
        //user validation
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
        }
        // getting specific user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username to delete: ");
        String username = scanner.nextLine();
        
        // removing operation
        users.removeIf(user -> user.getUsername().equals(username));
        System.out.println("User deleted successfully.");
    }
    
    public void viewBooks() {
        // user validation**
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
        }
        //retrieving books inserted**
        System.out.println("List of registered books:");
        for (Book book : books) {
        System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                           ", Category: " + book.getCategory().getName() + ", Price: $" + book.getPrice());
        }
    }
    
    public void viewAccessories() {
        // user validation**
    if (loggedInUser == null || !loggedInUser.isAdmin()) {
        System.out.println("Access denied.");
        return;
    }
    //retrieving accessories inserted**
    System.out.println("List of registered accessories:");
    for (Accessory accessory : accessories) {
        System.out.println("Accessory Name: " + accessory.getName() + ", Price: $" + accessory.getPrice());
    }
}
    

}
