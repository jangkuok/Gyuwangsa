<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>메인페이지</title>
</head>
<body>


<sec:authorize access="!isAuthenticated()">
    <button onclick="location.href='/joinUser.do'">회원 가입</button>
    <button onclick="location.href='/joinUser.do'">판매자 가입</button>
    <button onclick="location.href='/joinBrand.do'">브랜드 가입</button><br>
    <form action="/user/loginForm.do" id="loginUser" name="loginUser" method="post">
        <p>아이디 : <input type="text" id="user_nm" name="user_nm"></p>
        <p>패스워드 : <input type="text" id="password" name="password"></p>
        <input type="submit" id="loginButton" name="loginButton" value="로그인">
    </form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_BRAND') or hasRole('ROLE_ADMIN')">
    <form action="logoutForm.do" id="logoutForm" name="logoutForm" method="get">
        <input type="submit" id="logout" name="logout" value="로그아웃">
    </form>
</sec:authorize>
</body>
</html>