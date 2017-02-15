<html>
<body>
<h2>Add User Form</h2>
<p>${error}</p>
<form action="/addUser" method="post">
    Username:<br/>
    <input type="text" name="username"/>
    <br/>
    Password:<br/>
    <input type="password" name="password">
    <br><br>
    <input type="submit" value="add user">
</form>
</body>
</html>