<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	padding: 10px;
}
</style>
</head>
<body>
	<table border="1" style="border-collapse: collapse;">
	    <tr>
	        <td colspan="2" width="70" style="text-align: center;">${sungJukDTO.name}님의 성적</td>
	    </tr>
	    <tr>
	        <td width="70" align="center">총점</td>
	        <td>${sungJukDTO.tot}</td>
	    </tr>
	    <tr>
	        <td width="70" align="center">평균</td>
	        <td><fmt:formatNumber pattern="#.##">${sungJukDTO.avg}</fmt:formatNumber></td>
	    </tr>
	</table>
</body>
</html>