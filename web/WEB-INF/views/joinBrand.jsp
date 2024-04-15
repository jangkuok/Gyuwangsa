<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>브랜드 가입</title>
</head>
<body>
<form action="/insertBrandJoin.do" name="joinForm" id="joinForm" method="post">
    <p>브랜드 이름 : <input type="text" name="brand_nm" id="brand_nm" ></p>
    <p>브랜드 로고 : <input type="text" name="brand_img" id="brand_img"></p>
    <p>우편번호 : <input type="text" name="brand_addr_no" id="brand_addr_no"></p>
    <p>주소 : <input type="text" name="brand_addr" id="brand_add"></p>
    <p>상세주소 : <input type="text" name="brand_addr_dtl" id="brand_addr_dtl"></p>
    <p>택배사 : <select name="deli_comp_cd" id="deli_comp_cd">
                <option value="로젠택배">로젠택배</option>
                <option value="CJ택배">CJ택배</option>
                <option value="우체국">우체국</option>
               </select>
    <input type="submit" value="등록">
</form>

</body>
</html>
