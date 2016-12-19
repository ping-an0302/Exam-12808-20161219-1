<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div >
		<div style="height: 20px">
			<div style="width:200px ; float: right;">欢迎你，<span style="color: #FF0000">${sessionScope.user.iser_name}</span> </div>
		</div>
		<div>
			<div style=" width: 15%; height:1000px; float: left;">
				
			</div>
			<div style="float: left; width: 75%"> <!-- 右边框 -->
				<form action="InsertFilmServlet" method="post">
					<div>
						<input type="submit" value="保存">
						<br><br>
					</div>
					<div style="border-bottom: 3px; border-style: solid; border-color: #000000; width: 100%;height: 500px;" >
						<div style="width: 100%; height: 80%; margin-top: 2%; margin-left: 3%" align="center">
							<table style="width: 100%">
								<tr>
									<td align="center" valign="top">电影标题</td>
									<td><input type="text" name="title" style="width: 89%"> </td>
								</tr>
								<tr>
									<td align="center"  valign="top">电影内容</td>
									<td><textarea rows="7" cols="100%" name="description"></textarea> </td>
								</tr>
								<tr>
									<td align="center" valign="top">电音语言</td>
									<td>
										<select name="language_id" style="width: 89%">
											<c:forEach items="${sessionScope.languagelist }" var="language" varStatus="status">
												<option value="${language.language_id }" selected>${language.name }</option>
											</c:forEach>
										</select> 
									</td>
								</tr>
							</table>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



</body>
</html>