package com.mycompany.cashandcarry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();
    private ProductManager productManager; // Add this instance variable

    public Cart(ProductManager productManager) 
    {
        this.productManager = productManager; // Initialize the ProductManager
    }

    public void addProductById(int productId, int quantity) 
    {
        Product productToAdd = findProductById(productId);
        if (productToAdd != null && productToAdd.getQuantity() >= quantity) {
            // Decrease the quantity of the product in the ProductManager by the amount added to the cart
            productToAdd.setQuantity(productToAdd.getQuantity() - quantity);

            // Create a new product with the same details as the original and add it to the cart
            Product productInCart = new Product(productToAdd.getId(), productToAdd.getName(), productToAdd.getPrice(), quantity);
            products.add(productInCart);

            System.out.println(quantity + " item(s) added to the cart.");
        } else {
            System.out.println("Product with ID " + productId + " not found or insufficient quantity.");
        }
    }



    // Remove a product from the cart by product ID
    public boolean removeProductById(int productId) {
        Product productToRemove = findProductById(productId);
        if (productToRemove != null) {
            if (products.remove(productToRemove)) {
                System.out.println("Item removed from the cart.");
            } else {
                System.out.println("Item not found in the cart.");
            }
        } else {
            System.out.println("Product with ID " + productId + " not found in the cart.");
        }
        return true;
    }

    // Get the total price of all products in the cart
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    // Get a list of all products in the cart
    public List<Product> getProducts() {
        return products;
    }

    // Helper method to find a product by ID
    private Product findProductById(int productId) {
        for (Product product : productManager.getProductList()) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    // Print the products in the cart, their prices, and the total price
  
    /*public String printCart() 
    {
        double totalCartPrice = 0;
        System.out.println("\t=== INVOICE ===");

        // Get the current date and time
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        System.out.println("\t------------");
        String formattedDateTime = formatter.format(now);
        System.out.println("Date and Time: " + formattedDateTime);
        System.out.println("-----------------------------");
        for (Product product : products) {
            double itemPrice = product.getPrice();
            int itemQuantity = product.getQuantity();
            double itemTotalPrice = itemPrice * itemQuantity;

            System.out.println(product.getName() + " - $" + itemPrice + " x " + itemQuantity + " = $" + itemTotalPrice);
            totalCartPrice += itemTotalPrice;
           System.out.println("-----------------------------");
        }
        System.out.println("Total Amount: $" + totalCartPrice);
        System.out.println("-----------------------------");
        return "";
    }*/
    public String printCart() 
    {
        double totalCartPrice = 0;
        StringBuilder emailText = new StringBuilder();

        emailText.append("\t\t=== INVOICE ===\n\n");

        // Get the current date and time
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        String formattedDateTime = formatter.format(now);

        emailText.append("Date and Time: ").append(formattedDateTime).append("\n");
        emailText.append("------------------------------------------------------------\n");

        for (Product product : products) {
            double itemPrice = product.getPrice();
            int itemQuantity = product.getQuantity();
            double itemTotalPrice = itemPrice * itemQuantity;

            emailText.append("#").append(product.getId()).append(" ").append(product.getName()).append(" - $").append(itemPrice).append(" x ").append(itemQuantity).append(" = $").append(itemTotalPrice).append("\n");
            totalCartPrice += itemTotalPrice;
            emailText.append("------------------------------------------------------------\n");
        }

        emailText.append("Total Amount: $").append(totalCartPrice).append("\n");
        emailText.append("------------------------------------------------------------\n");

        return emailText.toString();
    }
}

