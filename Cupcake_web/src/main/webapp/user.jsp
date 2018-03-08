<%@page import="Datbase.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebProject - User</title>
    </head>
    <body>
        
        <h1>USER</h1>
            
        <%
            User user = (User) session.getAttribute("user");
            
            if (user != null)
            {
                out.print("Login worked");
            }
            else
            {
                out.print("Login failed");
                
                user = new User("Anonymous", "none");
            }
        %>

        <p>
            Logged in as: <%= user.getUsername() %><br>
            Password: <%= user.getPassword() %><br>
        </p>
        
        <h2>UPDATE USER</h2>
        
        <form action="Control" method="post">
            <input type="text" name="username" placeholder="Username" />
            <input type="text" name="password" placeholder="Password" />
            <input type="text" name="admin" placeholder="Admin" />            
            <input type="hidden" name="origin" value="update" />
            <input type="submit" value="UPDATE USER" />
        </form>
        
        <br>
        <br>
        <br>
        
        <form action="Control" method="post">
            <h3>Go to webshop</h3>
            <input type="button" name="origin" value="GO" />
        </form>
        
        <h2>DELETE USER</h2>
        
        <form action="Control" method="post">
            <input type="hidden" name="origin" value="delete" />
            <input type="submit" value="DELETE USER" />
        </form>
        
        <a href="index.jsp">BACK...</a>

    </body>
</html>
