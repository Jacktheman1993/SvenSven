<%@include file="includes/header.jsp" %>



<h1>Front Page</h1>

<center><h2>SEARCH USER</h2></center>

<form id="formSearch" action="Control" method="post">
    <label id="labelUsername" for="username">Username</label>
    <input type="text" name="username" />
    <input type="hidden" name="origin" value="search" />
    <input type="submit" value="SEARCH USER" />
</form>

<center><h2>CREATE USER</h2></center>

<form id="formCreate" action="Control" method="post">
    <label id="labelUsername" for="username">Username</label>
    <input type="text" name="username" />
    <label id="labelPassword" for="password">Password</label>
    <input type="text" name="password" />
    <input type="hidden" name="origin" value="create" />
    <input type="submit" value="CREATE USER" />
</form>

<%@include file="includes/footer.jsp" %>
