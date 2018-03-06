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

<form action="/action_page.php">
  <div class="imgcontainer">
    <img src="https://openclipart.org/download/247324/abstract-user-flat-1.svg" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <a href="createUser.jsp" class="createbtn"><span>Create a user</span></a>
    <span class="psw">Forgot <a href="http://s2.quickmeme.com/img/a5/a54267c7f569dfe5fe69dd93805c57cbc71c43c63e1b6578f68a43400c814217.jpg">password?</a></span>
  </div>
</form>
    </body>
</html>
