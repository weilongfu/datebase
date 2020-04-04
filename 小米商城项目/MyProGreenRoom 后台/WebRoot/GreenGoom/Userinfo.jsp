<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入标准标签库 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<%@include file="../include/top.jsp" %>
<meta charset="utf-8">
<title>小米商城  后台用户管理</title>
<script type="text/javascript">
  function dele(){
  confirm("确定删除吗?");
  }
</script>
<body>
<div style="width: 100%;height: 500px;position: absolute;top: 30px;left: 220px">
  <table style="width: 1000px;text-align: center;">
       <tr>
       <th>用户编号</th>
         <th>用户名</th>
         <th>用户密码</th>
         <th>电话号码</th>
          <th>操作</th>
       </tr>
       
       <!-- 显示商品信息开始 -->
       <c:forEach items="${list}" var="user">
       <tr>
         <td>${user.userid}</td>
         <td>${user.uname}</td>
         <td>${user.pwd}</td>
         <td>${user.uphone}</td>
         <td>
         <a href="user.do?method=delete&userid=${user.userid}" onclick="dele()">删除</a>&nbsp;
         <a href="user.do?method=toUpdate&userid=${user.userid}">修改</a>
         </td>
       </tr>
       </c:forEach>
  </table>
  </div>
</body>
</html>
