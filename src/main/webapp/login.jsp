<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影租赁系统</title>
</head>
<body>
	<div style="margin-left: 100px">
		<h1>电影租赁系统</h1>
	</div>
	<div style="margin-left: 300px">
		<fieldset style="width: 300px">
		
		<!-- 后期完善功能 -->
		<legend>登录信息 <span id="userspan" style="color: #FF0000">${sessionScope.exception }</span></legend>
		<c:remove var="exception"  scope="session"/>

			<form action="LoginServlet" method=post name="login" >
				<table style="margin: 20px">
					<tr>
						<td><label for="username">用户名:</label></td>
						<td><input type="text" id="username" name="username" > </td>
					</tr>
					<tr>
						<td><label for="password">密码:</label></td>
						<td><input type="password" id="password" name="password"></td>
					</tr>
				</table>
				<div align="center">
					<input type="submit"  value="登录" >
					<input type="reset" value="重置">
				</div>
			</form>
		</fieldset>
	</div>






</body>
</html>