<%-- 
    Document   : createUser
    Created on : Mar 6, 2018, 3:50:04 PM
    Author     : Alek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE A USER</title>
    </head>
    <body>
        <center><h1>CREATE USER</h1></center>
        
        <form id="formCreate" action="usercreated.jsp" method="post">
            <label id="labelUsername" for="username">Username</label>
            <input type="text" name="username" />
            <label id="labelPassword" for="password">Password</label>
            <input type="text" name="password" />
            <label id="labelAdmin" for="admin">Admin</label>
            <input type="text" name="admin" />
            <input type="submit" value="CREATE" />
            <span class="psw"><a href="login.jsp">Go Back</a></span>
        </form>
    </body>
</html>
