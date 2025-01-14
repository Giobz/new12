/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.booknookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookNookStore {
    private List<Book> books = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private User loggedInUser;  // Tracks the currently logged-in user

    public BookNookStore() {
        addSampleData();
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public void addSampleData() {
        // Add sample categories, books, accessories, and a default admin user
        categories.add(new Category(1, "Fiction", "Fictional books"));
        categories.add(new Category(2, "Non-Fiction", "Non-fictional books"));

        books.add(new Book(1, "Java Programming", "Author A", 29.99, categories.get(1)));
        books.add(new Book(2, "Data Structures", "Author B", 35.00, categories.get(1)));

        accessories.add(new Accessory(1, "Bookmark", 2.99));
        accessories.add(new Accessory(2, "Reading Light", 10.50));

        // Create a default admin and a regular user for testing
        users.add(new User("admin", "admin123", true));
        users.add(new User("user", "user123", false));
    }

    // Login method
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                loggedInUser = user;
                System.out.println("Login successful! Welcome, " + username);
                return true;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;
    }

    // Logout method
    public void logout() {
        loggedInUser = null;
        System.out.println("You have been logged out.");
    }

    public void displayAllItems() {
        System.out.println("Books Available:");
        for (Book book : books) {
            System.out.println(book.toString() + " - Sales: " + book.getSalesCount());
        }

        System.out.println("\nAccessories Available:");
        for (Accessory accessory : accessories) {
            System.out.println(accessory.toString() + " - Sales: " + accessory.getSalesCount());
        }
    }

    public void searchBook(String query) {
        System.out.println("Search Results:");
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println(book);
            }
        }
    }

    public void buyBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.incrementSalesCount();
                addOrder("Book: " + book.getTitle(), book.getPrice());
                System.out.println("Book purchased successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void buyAccessory(int id) {
        for (Accessory accessory : accessories) {
            if (accessory.getId() == id) {
                accessory.incrementSalesCount();
                addOrder("Accessory: " + accessory.getName(), accessory.getPrice());
                System.out.println("Accessory purchased successfully!");
                return;
            }
        }
        System.out.println("Accessory not found.");
    }

    public void viewOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : orders) {
                order.viewOrderHistory();
            }
        }
    }

    public void addOrder(String itemName, double price) {
        Order order = new Order();
        order.addItem(itemName, price);
        orders.add(order);
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter New Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter New Password: ");
        String password = scanner.nextLine();
        System.out.print("Is Admin (true/false): ");
        boolean isAdmin = scanner.nextBoolean();

        users.add(new User(username, password, isAdmin));
        System.out.println("Sign-up successful!");
    }

    public void showUserMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (loggedInUser == null) {
                System.out.println("Please log in to continue.");
                if (!login()) {
                    continue; // Retry if login fails
                }
            }

            System.out.println("\nUser Menu:");
            System.out.println("1. Display All Books and Accessories");
            System.out.println("2. Search Book by Title or Author");
            System.out.println("3. Buy a Book");
            System.out.println("4. Buy an Accessory");
            System.out.println("5. View Order History");
            System.out.println("6. Sign Up");
            System.out.println("7. Modify Book or Accessory (Admin Only)");
            System.out.println("8. Delete Book or Accessory (Admin Only)");
            System.out.println("9. Logout");
            System.out.println("10. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> displayAllItems();
                case 2 -> {
                    System.out.print("Enter Title or Author to Search: ");
                    String query = scanner.nextLine();
                    searchBook(query);
                }
                case 3 -> {
                    System.out.print("Enter Book ID to Buy: ");
                    int bookId = scanner.nextInt();
                    buyBook(bookId);
                }
                case 4 -> {
                    System.out.print("Enter Accessory ID to Buy: ");
                    int accessoryId = scanner.nextInt();
                    buyAccessory(accessoryId);
                }
                case 5 -> viewOrderHistory();
                case 6 -> signUp();
                case 7 -> {
                    if (loggedInUser.isAdmin()) {
                        System.out.print("Enter Book or Accessory ID to Modify: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Name or Title: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter New Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Is Book (true/false): ");
                        boolean isBook = scanner.nextBoolean();
                        modifyBookOrAccessory(id, name, price, isBook);
                    } else {
                        System.out.println("Access denied. Admins only.");
                    }
                }
                case 8 -> {
                    if (loggedInUser.isAdmin()) {
                        System.out.print("Enter Book or Accessory ID to Delete: ");
                        int id = scanner.nextInt();
                        System.out.print("Is Book (true/false): ");
                        boolean isBook = scanner.nextBoolean();
                        deleteBookOrAccessory(id, isBook);
                    } else {
                        System.out.println("Access denied. Admins only.");
                    }
                }
                case 9 -> logout();
                case 10 -> {
                    System.out.println("Exiting User Menu.");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void modifyBookOrAccessory(int id, String newName, double newPrice, boolean isBook) {
        if (isBook) {
            for (Book book : books) {
                if (book.getId() == id) {
                    book.setTitle(newName);
                    book.setPrice(newPrice);
                    System.out.println("Book updated successfully!");
                    return;
                }
            }
        } else {
            for (Accessory accessory : accessories) {
                if (accessory.getId() == id) {
                    accessory.setName(newName);
                    accessory.setPrice(newPrice);
                    System.out.println("Accessory updated successfully!");
                    return;
                }
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public void deleteBookOrAccessory(int id, boolean isBook) {
        if (isBook) {
            books.removeIf(book -> book.getId() == id);
            System.out.println("Book deleted successfully!");
        } else {
            accessories.removeIf(accessory -> accessory.getId() == id);
            System.out.println("Accessory deleted successfully!");
        }
    }
}
