<%-- 
    Document   : shop
    Created on : 03 May 2017, 11:38:31 AM
    Author     : LAB0033CPC12
--%>

<%@page import="tut.ac.za.business.Utility"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop Page</title>
    </head>
    <body>
        <h3>Start Shopping</h3>
            <table>     
                <th>Picture</th><th>Product Name</th><th>Price</th><th>Add to Cart</th>  
        <%
            Utility util = (Utility)request.getSession().getAttribute("util");
            if(util == null)
            {
                util = new Utility();
                request.getSession().setAttribute("util", util);
            }
            
            
            for(int i = 0; i < Utility.products.size(); i++)
            {
                          
        %>
                    <tr>
                        <td><img src="<%=Utility.getProducts().get(i).getImage()%>" width="163" height="123"/></td>
                        <td><%=Utility.products.get(i).getName()%></td>
                        <td><%=Utility.products.get(i).getType()%></td>
                        <td><%=Utility.products.get(i).getPrice()%></td>
                        <td>
                            <form action="AddToCartServlet.do" method="POST">
                                <input type="hidden" name="index" value="<%=i%>">
                                <input type="submit" value="Add To Cart"/>
                            </form>
                        </td>
                    </tr>               
                    
                    <%}%>       
            </table>
            <form action="status.jsp" method="POST">
                <input type="submit" value="View Cart"/>
            </form>
    </body>
</html>
