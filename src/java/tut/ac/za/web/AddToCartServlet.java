/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut.ac.za.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tut.ac.za.business.Utility;
import tut.ac.za.entity.Item;
import tut.ac.za.entity.Product;

/**
 *
 * @author Thembeni
 */
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Utility util = (Utility)request.getSession().getAttribute("util");
        ArrayList<Item> cart = util.getCart();
        
        int index = Integer.parseInt(request.getParameter("index"));
        
        ArrayList<Product> products = Utility.products;
        Product product = products.get(index);
        
        boolean isProductInCart = Utility.isProductInCart(product, cart);
        
        if(!isProductInCart)
        {
            Item item = new Item();
            item.setProduct(product);
            item.calcSubTotal();
            
            cart.add(item);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shop.jsp");
        dispatcher.forward(request, response);
    
    }
}