<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<%@include file="../include/top.jsp"%>
<meta charset="utf-8">
<title>添加管理员信息</title>
</head>
<body>
	<div
		style="width: 100%;height:800px;position: absolute;top: 20px;left: 420px">
		<form action="admin.do?method=addAdmin" method="post">
		<table style="width: 400px;text-align: center">

			<tr>
				<td>管理员名称:</td>
				<td><input type="text" name="adminName" value="" /></td>
			</tr>

			<tr>
				<td>管理员密码:</td>
				<td><input type="password" value="" name="adminPwd"/></td>
			</tr>
			
			<tr>
				<td>确认密码:</td>
				<td><input type="password" value="" name=""/></td>
			</tr>
			
				<tr>
				<td>电话号码:</td>
				<td><input type="text" value="" name="adminPhone"/></td>
			</tr>
			

            <!--显示管理员性别-->
         <tr>
         <td>管理员性别:</td>
         <td><input type="radio" name="adminSex" value="男" checked="checked"/>男 
         <input type="radio" name="adminSex" value="女"/>女
		 </td>
         </tr>
    
           <!-- 下拉框显示管理员等级 -->
          <tr>
          <td>管理员等级:</td>
         <td>
         <select name="adminGrade"> 
           <option value="普通管理员">普通管理员</option>
           <option value="超级管理员">超级管理员</option>
         </select>
         </td>
          </tr>
   
	
            <tr>
			<td><input type="reset" value="重置" /> </td>
			<td><input type="submit" name="" value="提交" /> 
			<input type="button" onclick="javascript:window.location='shoes.do?method=query'" value="首页" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
