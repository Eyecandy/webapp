<html>
<body>
<h2>Edit User Form</h2>
<p>${error}</p>
<form action="/editUser" method="post">
    Current Username:<br/>
    <input type="text" name="current username"/>
    <br/>
    New Username<br/>
    <input type="text" name="new username"/>
    <br/>
    <input type="submit" value="edit user">
</form>
</body>
</html>