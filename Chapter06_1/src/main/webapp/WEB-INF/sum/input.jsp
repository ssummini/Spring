<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	padding: 5px;
}

</style>
</head>
<body>
	<form action="result.do" method="get">
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td width="50" align="center">X</td>
                <td><input type="text" name="x"></td>
            </tr>
            <tr>
                <td width="50" align="center">Y</td>
                <td><input type="text" name="y"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                	<input type="submit" value="계산">
                	<input type="reset" value="취소">
                </td>
            </tr>
        </table>
	</form>
</body>
</html>