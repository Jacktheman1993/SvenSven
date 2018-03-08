<%@include file="includes/header.jsp" %>
        <form action="Control" method="post">
            <input type="text" name="username" value="" placeholder="Username" />
            <input type="password" name="password" value="" placeholder="Password" />
            <input type="hidden" name="origin" value="login" />
            <input type="submit" value="Log in" />
        </form>
        
<%@include file="includes/footer.jsp" %>
