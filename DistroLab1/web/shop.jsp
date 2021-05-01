<%-- 
    Document   : index
    Created on : 2020-sep-30, 15:00:45
    Author     : Johan C
--%>


<%@page import="bo.cart.CartItemHandler"%>
<%@page import="java.util.Iterator"%>
<%@page import="ui.ItemInfo"%>
<%@page import="java.util.Collection"%>
<%@page import="bo.ItemHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href ="css/shop.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>
        <nav class = "navBar">
            <a href ="shop.jsp">SHOP</a>
            
            <div class = "shopCartDiv"> 
                <a href = "shopCart.jsp">
                    <image class ="shopCartImg" src ="images/shopcart.jpg"/>
                </a>          
            </div>
            <div class = "userLoginInfoPane">
                  <% if(session.getAttribute("userid")!=null){
                      if(!session.getAttribute("userid").equals("")){ %>
                  <div>
                      
                  <form method="post" action="index.jsp">
                   <p> Inloggad som: <%= session.getAttribute("userid")%> </p>
                       <input type="submit" name="logout" value="Logga ut"/> 
                   </form>
                  </div>
                   <%}else { %>
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
        <h1>Frukt shop</h1>

        <%  
            if(session.getAttribute("userid") != null){
                
            if(!session.getAttribute("userid").equals("")){
                
            if(request.getParameter("add")!= null){
               CartItemHandler.addItemToCart(request.getParameter("add"), (String) session.getAttribute("userid"));
            }
 
            if(request.getParameter("logout") != null){   
                session.setAttribute("userid", "");
            }
            
            Collection<ItemInfo> items = ItemHandler.getAllItems();
                Iterator<ItemInfo> it = items.iterator();
                for (; it.hasNext();) {
                    ItemInfo item = it.next();%>
                    
                    <div class = "fruitPane">
                        <h1><%=item.getName()%></h1>
                        <image  class = "fruitImg" src = <%= "\"images/" + item.getName() + ".jpg\"" %> > </image>

                        <form method="post" action="shop.jsp">
                        <input type ="hidden" name ="add" value =<%= item.getName()%> >  
                        <td><input type="submit" value="+" class = "quantityButton"/></td>
                        </input> 
                        <div class ="fruitDescPane">
                            <p><%=item.getDescription()%> </p>
                        </div>
                        </form>
                    </div>
            <% }
            }   
        }%>
    </div>

    </body>
</html>