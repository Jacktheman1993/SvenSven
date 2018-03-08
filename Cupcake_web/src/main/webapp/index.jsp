<%-- 
    Document   : index
    Created on : 05-03-2018, 10:57:27
    Author     : The Overlord
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
     
        
        <h1>WebProject Cupcake</h1>
        
        <h2>SEARCH USER</h2>
        
        <form id="formSearch" action="Servlet" method="post">
            <label id="labelUsername" for="username">Username</label>
            <input type="text" name="username" />
            <input type="hidden" name="origin" value="search" />
            <input type="submit" value="SEARCH USER" />
        </form>
        
        <h2>CREATE USER</h2>
        
        <form id="formCreate" action="Servlet" method="post">
            <label id="labelUsername" for="username">Username</label>
            <input type="text" name="username" />
            <label id="labelPassword" for="password">Password</label>
            <input type="text" name="password" />
            <input type="hidden" name="origin" value="create" />
            <input type="submit" value="CREATE USER" />
        </form>
        
    </body>
</html>
