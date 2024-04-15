<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>

const brandValue = ${brandValue};

if(brandValue === '2'){
    const subForm = document.getElementById('joinForm');
    const input = document.createElement('input');

    input.type = 'text';
    input.name = 'brand_cd';
    input.value = '';
    subForm.appendChild(input);
}

</script>
<html>
<head>
    <title>회 원 가 입</title>
</head>
<body>

<form action="/insertUserJoin.do" name="joinForm" id="joinForm" method="post">
    <p>성명 : <input type="text" name="name" id="name" ></p>
    <p>아이디 : <input type="text" name="user_nm" id="user_nm" maxlength="20"></p>
    <p>비밀번호 : <input type="text" name="password" id="password" maxlength="20"></p>
    <p>비밀번호 확인 : <input type="text" name="password_ck" id="password_ck" maxlength="20"></p>
    <p>이메일 주소 : <input type="text" name="email" id="email"></p>
    <p>휴대폰 번호 : <input type="text" name="phone" id="phone"></p>
    <p>성별 : <label>남자<input type="radio" name="sex_cd" value="남자" checked></label>
             <label>여자<input type="radio" name="sex_cd" value="여자" checked></label>
    <p>우편번호 : <input type="text" name="addr_no" id="addr_no"></p>
    <p>주소 : <input type="text" name="addr" id="add"></p>
    <p>상세주소 : <input type="text" name="addr_dtl" id="addr_dtl"></p>
    <input type="hidden" name="join_type" id="join_type" value="규왕사">
    <input type="submit" value="등록">
</form>

</body>
</html>
