<%-- 
    Document   : status
    Created on : 03 May 2017, 2:08:47 AM
    Author     : Thembeni
--%>

<%@page import="tut.ac.za.business.Utility"%>
<%@page import="tut.ac.za.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Status Page</title>
    </head>
    <body>
        <h1>Item(s)successfully added to cart</h1>
        <br>
         <table>     
             <th>Product Name</th><th>Quantity</th><th>Price</th><th>Total</th>               
        <%
            Utility util = (Utility)request.getSession().getAttribute("util");
            ArrayList<Item> cart = util.getCart();
            if(util == null)
            {
                util = new Utility();
            }
            
            if(cart == null)
            {
                cart = new ArrayList<Item>();
            }
            
            for(int i = 0; i < cart.size(); i++)
            {
                          
        %>
                <tr>
                    <td>
                        <form action="UpdateQuantityServlet.do" method="POST">
                            <input type="hidden" name="index" value="<%=i%>">
                            <input type="number" min="1" name="quantity" value="<%=cart.get(i).getQuantity()%>" onchange="this.form.submit()" width="80px"/>     
                        </form>
                    </td>
                    <td>R<%=cart.get(i).getProduct().getPrice()%>0</td>
                    <td>R<%=cart.get(i).getSubtotal()%>0</td>                   
                    <td>
                        <form action="RemoveServlet.do" method="POST">
                            <input type="hidden" name="index" value="<%=i%>">
                            <input type="submit" value="Remove"/>
                        </form>
                    </td>
                </tr>
                <%}%>
         </table>
        <br>
        To continue Shopping, click <a href="shop.html">here</a>
    </body>
</html>
