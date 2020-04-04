<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<%@include file="../include/top.jsp"%>
<meta charset="utf-8">
<title>修改商品信息</title>

</head>

<body>
	<div
		style="width: 100%;height: 500px;position: absolute;top: 20px;left: 420px">
		<form action="${pageContext.request.contextPath}/index_update.action?shoesid=${shoes.shoesid}" method="post">
		<table style="width: 400px;text-align: center">
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="shoesname" value="${shoes.shoesname}" /></td>
			</tr>

			<tr>
				<td>商品价格:</td>
				<td><input type="text" name="shoesprice" value="${shoes.shoesprice}" /></td>
			</tr>

			<tr>
				<td>商品库存:</td>
				<td><input type="text" name="shoescount" value="${shoes.shoescount}" /></td>
			</tr>


			<tr>
				<td>商品版本:</td>
				<td><input type="text" name="release" value="${shoes.release}" /></td>
			</tr>

			<tr>
				<td>颜色:</td>
				<td><input type="text" name="color" value="${shoes.color}" /></td>
			</tr>

			<tr>
				<td>商品状态:</td>
				<td><select name="shoesstate">
						<option value="${shoes.shoesstate}">${shoes.shoesstate}</option>
						<option value="上架">上架</option>
						<option value="下架">下架</option>
				</select></td>
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
