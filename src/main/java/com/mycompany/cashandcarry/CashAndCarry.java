package com.mycompany.cashandcarry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CashAndCarry 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Art art = new Art();
        ProductManager manager = ProductManager.getInstance();
        ArrayList<Product> addedProducts = new ArrayList<>();
         // Access the cart
//      ArrayList<Cart> cart = new ArrayList<>();
        Cart cart = new Cart(manager);
        Product newProduct; 
        
        // Copy products to the cart
        //manager.copyProductsToCart();
        
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println(art.cashAndCarry);
        System.out.println("============================");
        boolean isTrue = false;

        while (!isTrue) 
        {
            System.out.println("=====================");
            System.out.println("===M=A=I=N==M=E=N=U==");
            System.out.println("1. ADMIN");
            System.out.println("2. CUSTOMER");
            System.out.println("3. EXIT");
            choice = input.nextInt();
            System.out.println("=====================");
            switch (choice) 
            {
                case 1 -> 
                {
                    System.out.println("=====================");
                    System.out.println("\tADMIN");
                    System.out.println("1. VIEW ITEMS");
                    System.out.println("2. ADD ITEMS");
                    System.out.println("3. UPDATE ITEMS.");
                    System.out.println("4. REMOVE ITEM");
                    System.out.println("=====================");
                    choice = input.nextInt();
                    
                    switch (choice) 
                    {
                        case 1 -> 
                        {
                            // View products
                            System.out.println("\tProduct List");
                           // Product product1 = new Product(1, "Laptop", 132, 10);
                            System.out.println("\t------------");
                            for(Product product : manager.getProductList()) 
                            {
                                System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " qty");
                            }
                        }

                        case 2 -> 
                        {
                            // Add products

                            boolean isEnd = false;
                            do
                            {
                                System.out.print("Enter product id: ");
                                int id = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter product name: ");
                                String name = input.nextLine();
                                System.out.print("Enter product price: ");
                                double price = input.nextDouble();
                                System.out.print("Enter product quantity: ");
                                int quantity = input.nextInt();
                                input.nextLine();
                                newProduct = new Product(id, name, price, quantity);
                                manager.addProduct(newProduct);
                                
                                addedProducts.add(newProduct);
                                
                                System.out.print("Do you want to add more products? (y/n): ");
                                String continueAdding = input.nextLine().trim().toLowerCase();

                                if (continueAdding.equals("n")) 
                                {
                                    isEnd = true;  // Exit the loop if the input is not 'y'
                                }
                            }while(!isEnd);
                        }
                        case 3 -> 
                        {
                          
                            boolean isEnd = false;
                            do
                            {
                                System.out.print("Enter product id to update: ");
                                int id = input.nextInt();
                                input.nextLine();
                                Product updatedProduct = null;

                                // Find the product in the addedProducts list
                                for (Product product : addedProducts) 
                                {
                                    if (product.getId() == id) 
                                    {
                                        System.out.print("Enter new product name: ");
                                        String name = input.nextLine();
                                        System.out.print("Enter new product price: ");
                                        double price = input.nextDouble();
                                        System.out.print("Enter new product quantity: ");
                                        int quantity = input.nextInt();
                                        input.nextLine();  // Consume the newline character

                                        updatedProduct = new Product(id, name, price, quantity);
                                        break;
                                    }
                                }

                                if (updatedProduct != null) 
                                {
                                    // Update the product in the manager
                                    manager.updateProduct(id, updatedProduct);
                                } else 
                                {
                                    System.out.println("Product not found in the added products list.");
                                }

                                System.out.print("Do you want to update more products (y/n): ");
                                String continueUpdating = input.nextLine().trim().toLowerCase();
                                if (continueUpdating.equals("n"))
                                {
                                    isEnd = true;
                                }
                            }while (!isEnd);
                        }
                        case 4 -> 
                        {
                            boolean isEnd = false;
                            System.out.print("Enter product id to remove: ");
                            int id = input.nextInt();
                            input.nextLine();  // Consume the newline character

                            boolean removed = addedProducts.removeIf(product -> product.getId() == id);

                            if (removed) {
                                System.out.println("Product with ID " + id + " has been removed.");
                            } else {
                                System.out.println("Product with ID " + id + " not found in the added products list.");
                            }

                            System.out.print("Do you want to delete more products (y/n): ");
                            String continueUpdating = input.nextLine().trim().toLowerCase();
                            if (continueUpdating.equals("n"))
                            {
                                isEnd = true;
                            }
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                
                }
                
                case 2 -> 
                {
                    System.out.println("=====================");
                    System.out.println("\t\tCUSTOMER");
                    System.out.println("1. VIEW ITEMS");
                    System.out.println("2. ADD TO CART");
                    System.out.println("3. VIEW CART");
                    System.out.println("4. REMOVE ITEM FROM CART");
                    System.out.println("5. EMAIL THE INVOICE."); //   Email invoice to your account
                    System.out.println("6. EXIT");
                            
                    System.out.println("=====================");
                    choice = input.nextInt();
                    
                    switch(choice)
                    {
                        case 1 ->
                        {
                            // View products
                            System.out.println("\tProduct List");
                            System.out.println("\t------------");
                           
                            for (Product product : manager.getProductList()) 
                            {
                                System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " qty");
                            }
                        }
                        case 2 ->
                        {
                            
                            System.out.print("Enter product ID to add to the cart: ");
                            int productId = input.nextInt();
                            System.out.print("Enter the quantity you want to add to the cart: ");
                            int quantityToAdd = input.nextInt();

                            // Decrease the quantity in the ProductManager
                            manager.decreaseQuantity(productId, quantityToAdd);
                            // Add the product to the cart
                            cart.addProductById(productId, quantityToAdd);
                                
                        }
                        case 3 ->
                        {
                            System.out.println("Current Cart Items:");
                            for (Product product : cart.getProducts()) {
                                System.out.println(product.getId() + " - " + product.getName() + " - $" +
                                product.getPrice() + " - " + product.getQuantity() + " qty");
                            }
                        }
                        case 4 ->
                        {
                            System.out.print("Enter product id to remove from the cart: ");
                            int id = input.nextInt();
                            cart.removeProductById(id);
                        }
                        case 5 ->
                        {
//                            System.out.println("Enter your email: ");
//                            String to = input.nextLine();
                            String to = "basharat.hussain@gmail.com";
                            String from = "csdilawar@gmail.com";
                            String subject = "CASH AND CARRY INVOICE";

                            // Get the invoice text
                            String emailText = cart.printCart();

                            // Check if the emailText is not empty before sending the email
                            if (!emailText.isEmpty()) 
                            {
                                File file = new File("E:\\download1.png");
                                EmailSender e = new EmailSender();
                                boolean b = e.sendEmailWithAttachment(to, from, subject, emailText, file);

                                if (b) 
                                {
                                    System.out.println("Email is sent Successfully");
                                } 
                                else 
                                {
                                    System.out.println("Error in Sending Email");
                                }
                            } 
                            else 
                            {
                                System.out.println("No items in the cart. Email not sent.");
                            }

                        }
                        case 6 ->
                        {
                             isTrue = true;
                        }
                    }
                }

                case 3 -> isTrue = true;

                default -> System.out.println("Invalid choice.");
            }
            // Implement customer logic
        }
    }
}
