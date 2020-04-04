<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<%@include file="../include/top.jsp"%>
<meta charset="utf-8">
<title>修改用户信息</title>

</head>

<body>
	<div
		style="width: 100%;height: 500px;position: absolute;top: 20px;left: 420px">
		<form action="user.do?method=updateUser&userid=${user.userid}" method="post">
		<table style="width: 400px;text-align: center">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="uname" value="${user.uname}" /></td>
			</tr>

		<tr>
				<td>用户密码:</td>
				<td><input type="text" name="pwd" value="${user.pwd}" /></td>
			</tr>
		
		<tr>
				<td>电话号码:</td>
				<td><input type="text" name="uphone" value="${user.uphone}" /></td>
			</tr>
		
             <tr>
			<td><input type="reset" value="重置" /> </td>
			<td><input type="submit" name="Submit2" value="提交" /> 
			<input type="button" onclick="javascript:window.location='shoes.do?method=query'" value="首页" /></td>
			</tr>
			
		</table>
		</form>
	</div>
</body>
</html>
