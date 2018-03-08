<%-- 
    Document   : login
    Created on : Mar 6, 2018, 3:32:10 PM
    Author     : Alek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="logstyle.css" rel="stylesheet" type="text/css"/>
        <title>LOGIN IN PAGE</title>
    </head>
    <body>
        <h2>Login Form</h2>
        <form action="Control" method="post">
            <input type="text" name="username" value="" placeholder="Username" />
            <input type="password" name="password" value="" placeholder="Password" />
            <input type="hidden" name="origin" value="login" />
            <input type="submit" value="Log in" />
        </form>
    </body>
</html>
