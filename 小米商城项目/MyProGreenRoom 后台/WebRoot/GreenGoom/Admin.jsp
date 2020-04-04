<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入标准标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<%@include file="../include/top.jsp" %>
<meta charset="utf-8">
<title>小米商城后台管理员系统</title>
<script type="text/javascript">
  function dele(){
  confirm("确定删除吗?");
  }
</script>
<body>
<div style="width: 100%;height: 500px;position: absolute;top: 30px;left: 220px">
  <table style="width: 1000px;text-align: center;">
       <tr>
       <th>管理员编号</th>
         <th>管理员名称</th>
         <th>管理员密码</th>
         <th>性别</th>
         <th>电话号码</th>
         <th>管理员等级</th>
         <th>操作</th>
       </tr>
       
       <!-- 显示商品信息开始 -->
       <c:forEach items="${list}"  var="admin">
       <tr>
         <td>${admin.adminId}</td>
         <td>${admin.adminName}</td>
         <td>${admin.adminPwd}</td>
      
         <td>${admin.adminSex}</td>
		 
         <td>${admin.adminPhone}</td>
         <td>${admin.adminGrade}</td>
         <td>
         <a href="admin.do?method=delete&adminId=${admin.adminId}" onclick="dele()">删除</a>&nbsp;
         <a href="admin.do?method=toupdate&adminId=${admin.adminId}">修改</a>
         </td>
       </tr>
       </c:forEach>
  </table>
  </div>
</body>
</html>

