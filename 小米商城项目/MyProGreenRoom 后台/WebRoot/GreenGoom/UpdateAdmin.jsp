<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入标准标签库 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<%@include file="../include/top.jsp" %>
<meta charset="utf-8">
<title>小米商城后台管理系统</title>
<script type="text/javascript">
 
</script>
<body>
<div style="width: 100%;height: 500px;position: absolute;top: 30px;left: 220px">
<form action="admin.do?method=update&adminId=${admin.adminId}" method="post">
  <table style="width: 1000px;text-align: center;">
      <tr>
         <th>管理员名称</th>
         <th>管理员密码</th>
         <th>性别</th>
         <th>电话号码</th>
         <th>管理员等级</th>
         <th>操作</th>
       </tr>
       
       <!-- 显示管理员信息开始 -->
       <tr>
         <td><input type="text" value="${admin.adminName}" name="adminName"/></td>
         <td><input type="text" value="${admin.adminPwd}" name="adminPwd"/></td>
         
         <!--显示管理员性别-->
         <td><input type="radio" name="adminSex" value="男"
		 <c:if test="${admin.adminSex=='男'}">checked="checked"</c:if>/>男 
         
         <input type="radio" name="adminSex" value="女"
		 <c:if test="${admin.adminSex=='女'}">checked="checked"</c:if>/>女
         </td>
         
         <td><input type="text" value="${admin.adminPhone}" name="adminPhone"/></td>
         
         <!-- 下拉框显示管理员等级 -->
         <td>
         <select name="adminGrade"> 
           <option value="${admin.adminGrade}">${admin.adminGrade}</option>
           <option value="普通管理员">普通管理员</option>
           <option value="超级管理员">超级管理员</option>
         </select>
         </td>
         
         <td>
         <input type="submit" value="保存"/> &nbsp;
         
         <a href="admin.do?method=query">取消</a>
         </td>
       </tr>
  </table>
  </form>
  </div>
</body>
</html>
