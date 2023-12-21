package com.mycompany.cashandcarry;

import java.util.ArrayList;

public class ProductManager 
{
    private static ProductManager instance = null;
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Cart> cart = new ArrayList<>(); // New cart ArrayList

   public static ProductManager getInstance() 
   {
        if (instance == null) 
        {
            instance = new ProductManager();
        }
        return instance;
   }

    // Add a product to the list
    public void addProduct(Product product) 
    {
//        Product product = new Product();
        productList.add(product);
    }
    

    // Update a product in the list
    public void updateProduct(int productId, Product updatedProduct) 
    {
        for (int i = 0; i < productList.size(); i++) 
        {
            if (productList.get(i).getId() == productId) 
            {
                productList.set(i, updatedProduct);
                break;
            }
        }
    }

    // Remove a product from the list
    public void removeProduct(int productId) 
    {
        productList.removeIf(product -> product.getId() == productId);
    }
    
    // View the current items in the list
    public void viewProducts() 
    {
        for (Product product : productList) 
        {
            System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " qty");
            //System.out.println(product);
        }
    }
    
    // Find a product by its ID
    public Product findProductById(int productId) 
    {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    // Decrease the quantity of a product by a specified amount
    public void decreaseQuantity(int productId, int amount) 
    {
        Product productToUpdate = findProductById(productId);

        if (productToUpdate != null) {
            int currentQuantity = productToUpdate.getQuantity();
            if (currentQuantity >= amount) {
                productToUpdate.setQuantity(currentQuantity - amount+2);
            } else {
                // Handle the case where the amount is greater than the current quantity, e.g., set quantity to 0
                productToUpdate.setQuantity(0);
            }
        }
    }

    
    // Get the list of products
    public ArrayList<Product> getProductList() {
        return productList;
    }

    // Get the cart
    public ArrayList<Cart> getCart() {
        return cart;
    }
    
}
