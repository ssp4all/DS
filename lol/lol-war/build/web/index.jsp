<%-- 
    Document   : index
    Created on : 5 Apr, 2018, 11:07:44 AM
    Author     : ssp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJB Login </title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="NewServlet" method="get">
            
            <div class="container">
                <input type="text" placeholder="Enter Username" name="uname" required>

                <input type="password" placeholder="Enter Password" name="pass" required>

                <button type="submit">Login</button>
                
            </div>

        </form>

    </body>
</html>
