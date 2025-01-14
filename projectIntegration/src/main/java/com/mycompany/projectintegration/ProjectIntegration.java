/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectintegration;
import com.mycompany.memberb.MemberB;
import java.util.Scanner;


/**
 *
 * @author User
 */
public class ProjectIntegration {

    public static void main(String[] args) {
        
      
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome ");
        System.out.println("================");
        System.out.println("1. Load Member A");
        System.out.println("2. Load Member B");
        System.out.println("3. Load Member C");
        System.out.println("4. Exit");
        
        while (true) {
            System.out.print("\nEnter menu choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    MemberB.main(args);
                    break;
                case 3:
                    
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

    

