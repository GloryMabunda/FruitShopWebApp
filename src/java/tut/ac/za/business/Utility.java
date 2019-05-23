/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tut.ac.za.business;

import java.util.ArrayList;
import tut.ac.za.entity.Item;
import tut.ac.za.entity.Product;

/**
 *
 * @author LAB0040PC031
 */
public class Utility 
{
    public static ArrayList<Product> products;
    private ArrayList<Item> cart;

    public Utility()
    {
        products = new ArrayList<>();
        products.add(new Product(1L, "Apples", 0.50, "Fruit", "images/apples.jpg"));
        products.add(new Product(2L, "Bananas", 1.00, "Fruit",  "images/bananas.jpg"));
        products.add(new Product(3L, "Potatoes", 2.00, "Vegetable", "images/potatoes.jpg"));
        products.add(new Product(4L, "Tomatoes", 3.00, "Vegetable", "images/tomatoes.jpg"));
        
        cart = new ArrayList<>();
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        Utility.products = products;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
    
    public static boolean isProductInCart(Product p, ArrayList<Item> cart) 
    {    
        for(Item item : cart)
        {
            if(item.getProduct().getId() == p.getId())
            {
            
                item.setQuantity(item.getQuantity()+1);
                item.calcSubTotal();
                return true;
            }
            
        }
        return false;
    }
    
}
