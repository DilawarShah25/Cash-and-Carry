package com.mycompany.cashandcarry;

import java.util.ArrayList;
import java.util.List;

public class Product 
{
    private String name;
    private double price;
    private int quantity, id;
    
    // Default constructor with default values
    public Product() 
    {
        // Initialize default values
        this.id = 0; // Default ID
        this.name = "Default Product"; // Default name
        this.price = 0.0; // Default price
        this.quantity = 0; // Default quantity
    }
    
    // Constructor
    public Product( int id, String name, double price, int quantity) 
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }
   
    // Decrease the quantity of a product by a specified amount
public void decreaseQuantity(int productId, int amount) {
    ProductManager manager = new ProductManager();
    ArrayList<Product> productList = manager.getProductList();  // Get the productList from the manager
    
    for (Product product : productList) {
        if (product.getId() == productId) {
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= amount) {
                product.setQuantity(currentQuantity - amount);
            }
            break;
        }
    }
}

    
    

    // Getters and Setters
    
    public int getId()
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    // Method to add a new product to a list
    public static void addNewProduct(List<Product> productList, Product newProduct) 
    {
        productList.add(newProduct);
    }

    @Override
    public String toString() 
    {
        return "Product Name: " + name + "\nPrice: $" + price + "\nQuantity: " + quantity;
    }

    void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}



