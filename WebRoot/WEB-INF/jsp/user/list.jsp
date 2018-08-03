<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>'list.jsp'</title>
    
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

  </head>
  
  <body>
    <div class="container">
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  <h1>欢迎访问</h1>
		  </div>
		</div>
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  <table>
		  	<tr>
		  		<th>ID</th>
		  		<th>用户名</th>
		  		<th>密码</th>
		  		<th>角色</th>
		  		<th>操作</th>
		  	</tr>
		  <%-- 	<c:forEach item="${userList}" var="user"></c:forEach> --%>
		  	<tr>
		  		<td></td>
		  	</tr>
		  	
		  </table>
		  </div>
		</div>

	</div>
  </body>
</html>
