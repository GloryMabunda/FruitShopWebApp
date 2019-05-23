/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tut.ac.za.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tut.ac.za.business.Utility;
import tut.ac.za.entity.Item;

/**
 *
 * @author LAB0033CPC12
 */
public class RemoveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utility util = (Utility)request.getSession().getAttribute("util");
        ArrayList<Item>cart = util.getCart();
        
        int index = Integer.parseInt(request.getParameter("index"));
        Item item = cart.get(index);
        
        cart.remove(item);
        
        RequestDispatcher disp = request.getRequestDispatcher("/status.jsp");
        disp.forward(request, response);
    }
}
