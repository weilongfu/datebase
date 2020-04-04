<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入标准标签库 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<%@include file="../include/top.jsp" %>
<meta charset="utf-8">
<title>小米商城后台订单管理系统</title>
<script type="text/javascript">
 
</script>
<body>
<div style="width: 100%;height: 500px;position: absolute;top: 30px;left: 220px">
  <table style="width: 1400px;text-align: center;">
       <tr>
       <th>商品图片 </th>
         <th>订单编号</th>
         <th>商品名称</th>
         <th>商品价格</th>
         <th>购买数量</th>
         <th>下单时间</th>
         <th>收货人姓名</th>
         <th>收货地址</th>
         <th>电话号码</th>
         <th>订单状态</th>
       </tr>
       
       <!-- 显示商品信息开始 -->
       <c:forEach items="${list}" var="order">
       <tr>
         <td><img alt="" src="images/${order.shoesimg}" width="80px" height="80px"></td>
         <td>${order.orderid}</td>
         <td>${order.shoesname}</td>
         <td>${order.shoesprice}</td>
         <td>${order.shoesnum}</td>
         <td>${order.orderDate}</td>
         <td>${order.username}</td>
         <td>${order.orderAddress}</td>
         <td>${order.phoen}</td>
         <td>${order.orderstase}</td>
       </tr>
       </c:forEach>
  </table>
  </div>
</body>
</html>
