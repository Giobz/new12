/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MemberProjectLoader;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class MemberProjectLoader {

    // Member B object
    private static com.mycompany.memberb.MemberB memberB = new com.mycompany.memberb.MemberB();

    // Member A's project code
    public static void memberAProject() {
        System.out.println("Loading Member A's project...");
        // Add specific code for Member A here
        System.out.println("Member A's project executed successfully!");
    }

    // Member B's project code
    public static void memberBProject() {
        System.out.println("Loading Member B's project...");
        // Start the Member B project logic
        memberB.start();
    }

    // Member C's project code
    public static void memberCProject() {
        System.out.println("Loading Member C's project...");
        // Add specific code for Member C here
        System.out.println("Member C's project executed successfully!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome ");
        System.out.println("=======");
        System.out.println("1. Load Member A");
        System.out.println("2. Load Member B");
        System.out.println("3. Load Member C");
        System.out.println("4. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    memberAProject();
                    break;
                case 2:
                    memberBProject();
                    break;
                case 3:
                    memberCProject();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
