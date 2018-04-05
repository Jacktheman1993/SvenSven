<%@include file="includes/header.jsp" %>
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
            <button type="submit">Update User</button>
        </form>
        
        <br>
        <br>
        <br>
        
        <form action="shop.jsp" method="post">
            <h2>GO TO WEBSHOP</h2>
            <button type="submit">GO</button>
        </form>
        
        <h2>DELETE USER</h2>
        
        <form action="Control" method="post">
            <input type="hidden" name="origin" value="delete" />
            <button type="submit">Delete User</button>
        </form>
        
        <a href="index.jsp">BACK...</a>

<%@include file="includes/footer.jsp" %>
