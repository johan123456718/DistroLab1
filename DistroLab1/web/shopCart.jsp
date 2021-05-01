<%-- 
    Document   : login.jsp
    Created on : 2020-okt-01, 13:58:08
    Author     : Johan C
--%>

<%@page import="java.util.Iterator"%>
<%@page import="bo.cart.CartItemHandler"%>
<%@page import="ui.CartItemInfo"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webshop.com</title>
        <link href ="css/shopCart.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>

        <nav class = "navBar">

            <a href ="shop.jsp">SHOP</a>

            <div class = "userLoginInfoPane">
                <% if (session.getAttribute("userid") != null) {
                          if (!session.getAttribute("userid").equals("")) {%>
                <div>

                    <form method="post" action="index.jsp">
                        <p> Inloggad som: <%= session.getAttribute("userid")%> </p>
                        <input type="submit" name="logout" value="Logga ut"/> 
                    </form>
                </div>
                <%} else { %>
                <div>
                    <form method="post" action="index.jsp">
                        <p> Du behöver logga in </p>
                        <input type="submit" name="logout" value="Logga in"/> 
                    </form>
                </div>
                <% }
             }%> 
            </div>
        </nav>

        <%
            if(session.getAttribute("userid") != null){
                
            if(!session.getAttribute("userid").equals("")){
                
            if(request.getParameter("sub")!= null){
               CartItemHandler.removeItemFromCart(request.getParameter("sub"), (String) session.getAttribute("userid"));
            }
 
            if(request.getParameter("logout") != null){   
                session.setAttribute("userid", "");
            }
            
            String query = (String) session.getAttribute("userid");
            Collection<CartItemInfo> cartItems = CartItemHandler.getCartItemsForUser(query);
            
            if (!cartItems.isEmpty()) {
                Iterator<CartItemInfo> iter = cartItems.iterator();
            %>
            
            <div class = "orderTable"> 
                <h1> Dina varor som du har handlat</h1>
                    <table border="2" width="100%" bordercolor="brown">
                        <tbody>
                        <th>Frukter</th>
                        <th>Antal </th>
                        <th>Ta bort</th>
                        
                        <% for (; iter.hasNext();) {
                               CartItemInfo cartInfo = iter.next();%>

                               <tr>
                                   <td><%=cartInfo.getItemName()%></td>
                                   <td><%=cartInfo.getQuantity()%></td>
                                   
                                   <form method="post" action="shopCart.jsp">
                                       <input type ="hidden" name ="sub" value =<%= cartInfo.getItemName()%> >  
                                        <td><input type="submit" class ="removeButton" name="sub" value="-"/> </td>
                                        </input>
                                   </form>
                               
                               </tr>
                        <% }%>
                        
                        </tbody>
                        </table>

            </div>
                        
            <% } else { %>
                <p> Din lista är tom <p/>                 
            <%}%>
            <% }
            }   
            %>
    </body>
</html>