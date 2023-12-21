package com.mycompany.cashandcarry;

import java.util.Scanner;


public class Customer extends User
{
    public Customer() 
    {
        super("","","");
    }
    
    public boolean createAccount() 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Create Customer Account ===");
        System.out.print("Enter your desired admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter your desired admin password: ");
        String adminPassword = scanner.nextLine();
        
        // Display "Customer account created successfully" and ask to sign in
        System.out.println("Customer account created successfully!");
        System.out.println("=== Customer Sign In ===");
        System.out.print("Enter your admin username: ");
        String enteredCustomerUsername = scanner.nextLine();
        System.out.print("Enter your admin password: ");
        String enteredCustomerPassword = scanner.nextLine();
        
        // Check if the entered admin username and password match the admin's credentials
        if (enteredCustomerUsername.equals(adminUsername) && enteredCustomerPassword.equals(adminPassword)) {
            System.out.println("Customer sign in successful.");
            return true;
        } else {
            System.out.println("Customer sign in failed. Incorrect admin username or password.");
            return false;
        }
    }

    private Object getPassword() 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

