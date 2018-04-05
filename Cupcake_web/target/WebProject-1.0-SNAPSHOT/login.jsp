<%@include file="includes/header.jsp" %>
<form action="Control" method="post">

    <div class="imgcontainer">
        <img src="data:image/png;base64,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" alt="Avatar" class="avatar">
    </div>

    <input type="text" name="username" value="" placeholder="Username" />
    <input type="password" name="password" value="" placeholder="Password" />
    <input type="hidden" name="origin" value="login" />
    <button type="submit">Log in</button>
</form>

<%@include file="includes/footer.jsp" %>