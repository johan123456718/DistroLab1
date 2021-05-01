<%-- 
    Document   : login.jsp
    Created on : 2020-okt-01, 13:58:08
    Author     : Johan C
--%>

<%@page import="ui.UserInfo"%>
<%@page import="bo.UserHandler"%>
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
        <link href ="css/index.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>
        <%
            String userid = request.getParameter("uname");
            String pwd = request.getParameter("pass");
            
            if(request.getParameter("logout")!= null){
                session.setAttribute("userid", "");
            }
            
            
            if (pwd != null && userid != null) {
                if(UserHandler.getUser(userid, pwd) != null){
                   UserInfo user = UserHandler.getUser(userid, pwd);
                   session.setAttribute("userid", user.getUserName());
        %>
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
                                 
                <div class = "dialogPane">
                    <h1> Välkommen <%=session.getAttribute("userid")%>! </h1>
                    <p> Börja handla genom att klicka på shop. </p>
                    <p> När du har handlat klart så kan du bara klicka på varukorgen och kolla om du har allt med dig </p>
                    <p> Om du vill registrera ett nytt konto så kan du be IT-adminstratören att fixa ett åt dig. </p>
                </div>
            <%} else {%>
            
            <form method="post" class="loginScreen" action="index.jsp">
                <table border="1" >
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td><input type="text" name="uname" value=""/></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="pass" value=""/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Login"/></td>
                        </tr>
                    </tbody>
                </table>
                    <p> Fel användarnamn eller lösenord! <p>
            </form>
            <%}%>
            
            <% } else {%>      
            <form method="post" class="loginScreen" action= "index.jsp" >
                <table border="1" >
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td><input type="text" name="uname" value=""/></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="pass" value=""/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Login"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <% } %>
    </body>
</html>