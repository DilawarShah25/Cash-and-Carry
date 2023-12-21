package com.mycompany.cashandcarry;


import java.util.Scanner;

public class Admin 

{
    
    // Create a new account
    public boolean createAccount() 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Create Admin Account ===");
        System.out.print("Enter your desired admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter your desired admin password: ");
        String adminPassword = scanner.nextLine();
        
        // Display "Admin account created successfully" and ask to sign in
        System.out.println("Admin account created successfully!");
        System.out.println("=== Admin Sign In ===");
        System.out.print("Enter your admin username: ");
        String enteredAdminUsername = scanner.nextLine();
        System.out.print("Enter your admin password: ");
        String enteredAdminPassword = scanner.nextLine();
        
        // Check if the entered admin username and password match the admin's credentials
        if (enteredAdminUsername.equals(adminUsername) && enteredAdminPassword.equals(adminPassword)) {
            System.out.println("Admin sign in successful.");
            return true;
        } else {
            System.out.println("Admin sign in failed. Incorrect admin username or password.");
            return false;
        }
    }

}
