<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入标准标签库 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<%@include file="../include/top.jsp" %>
<meta charset="utf-8">
<title>小米商城后台管理系统</title>
<script type="text/javascript">
  function dele(){
  confirm("确定删除吗?");
  }
</script>
<body>
<div style="width: 100%;height: 500px;position: absolute;top: 30px;left: 220px">
  <table style="width: 1000px;text-align: center;">
       <tr>
       <th>商品图片</th>
         <th>商品编号</th>
         <th>名称</th>
         <th>价格</th>
         <th>库存</th>
         <th>商品状态</th>
         <th>版本</th>
         <th>颜色</th>
         <th>操作</th>
       </tr>
       
       <!-- 显示商品信息开始 -->
       <c:forEach items="${list}" var="shoes">
       <tr>
         <td><img alt="" src="images/${shoes.shoesimg}" width="80px" height="80px"></td>
         <td>${shoes.shoesid}</td>
         <td>${shoes.shoesname}</td>
         <td>${shoes.shoesprice}</td>
         <td>${shoes.shoescount}</td>
         <td>${shoes.shoesstate}</td>
         <td>${shoes.release}</td>
         <td>${shoes.color}</td>
         <td>
         <a href="${pageContext.request.contextPath}/index_delete.action?shoesid=${shoes.shoesid}" onclick="dele()">删除</a>&nbsp;
         <a href="${pageContext.request.contextPath}/index_toUpdate.action?shoesid=${shoes.shoesid}">修改</a>
         </td>
       </tr>
       </c:forEach>
  </table>
  </div>
</body>
</html>
