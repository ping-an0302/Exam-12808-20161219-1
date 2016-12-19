<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
			<div style="width:200px ; float: right;">欢迎你，<span style="color: #FF0000"></span> </div>
		</div>
		<div>
			<div style=" width: 15%; height:1000px; float: left;">
	
			</div>
			<div style="float: left; width: 75%"> <!-- 右边框 -->
				<form action="DeleteItemServlet" method="post">
					<div>
						<a href="FindLanguageServlet" style="text-decoration:none"><input type="button" value="新增"></a> 
<!-- 						<a href="" style="text-decoration:none"><input type="button" value="更新"></a>  -->
<!-- 						<input type="submit" value="删除"> -->
							<a href="ShowIndexServlet?curPage=${sessionScope.curPage+1 }" >下一页</a>
							<a href="ShowIndexServlet?curPage=${sessionScope.curPage-1 }" >上一页</a>
							<a href="ShowIndexServlet?curPage=${sessionScope.pageCount }" >尾页</a>
							<a href="ShowIndexServlet?curPage=0" >首页</a>
						<br><br>
					</div>
					<div style="border-bottom: 3px; border-style: solid; border-color: #000000; width: 100%;height: 100%;" >
						<table style="width: 100%">
							<tr>
								<td>序号</td>
								<td>电影标题</td>
								<td>电影内容</td>
								<td>语言</td>
							</tr>
							<c:forEach items="${sessionScope.filmlist }" var="film" varStatus="status">
								<tr>
									<td>
									<!-- 使用复选框实现一次删除多条数据 -->
<%-- 										<input type="checkbox" name="${status.index+1 }" value="${item.todo_item_id }"> --%>
										${status.index+1 }
									</td>
									<td>${film.title }</td>
									<td>${film.description }</td>
									<td>${film.languageName }</td>
									<td><a href="${film.film_id }" style="text-decoration:none"><input type="button" value="删除"></a> </td>
								</tr>
							</c:forEach>
						</table>
					</div>
					

				</form>
			</div>
		</div>
	</div>


</body>
</html>