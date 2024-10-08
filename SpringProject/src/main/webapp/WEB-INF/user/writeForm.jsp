<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="../css/user.css">
</head>
<body>
<a href="/spring/"><img src="../image/free-icon-love-4096198.png" alt="홈" width="60" height="60"/></a>
<form name="WriteForm" method="get">
    <table>
        <tr>
            <th>이름</th>
            <td>
                <input type="text" name="name" id="name" placeholder="이름 입력" size="20"/>
                <div id="nameDiv"></div>
            </td>
        </tr>
        
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" name="id" id="id" placeholder="아이디 입력" size="30"/>
                <input type="hidden" id="check" value=""/>
                <div id="idDiv"></div>
            </td>
        </tr>
        
        <tr>
            <th>비밀번호</th>
            <td>
                <input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" size="30"/>
                <div id="pwdDiv"></div>    
            </td>
        </tr>           
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="회원가입" />
                <input type="reset" value="다시입력" />
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/write.js"></script>
</body>
</html>
