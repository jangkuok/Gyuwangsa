<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/loginForm.do" id="loginUser" name="loginUser" method="post">
        <p>아이디 : <input type="text" id="user_nm" name="user_nm"></p>
        <p>패스워드 : <input type="text" id="password" name="password"></p>
    <input type="submit" id="loginButton" name="loginButton" value="로그인">
</form>
</body>
</html>
