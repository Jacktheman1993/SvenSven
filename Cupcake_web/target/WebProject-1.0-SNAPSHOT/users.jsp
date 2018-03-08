<%@include file="includes/header.jsp" %>
        <h1>USERS</h1>
        
        <%
            ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
            
            if(users.size() > 0)
            {
                out.println("<p>Users found...</p>");
                out.println("<p>");
                
                for(User u : users)
                {
                    out.println(u.getUsername() + "<br>");
                }
                
                out.println("</p>");
            }
            else
            {
                out.println("<p>No users found...</p>");
            }
            
        %>
        
        <a href="index.jsp">BACK...</a>
<%@include file="includes/footer.jsp" %>
