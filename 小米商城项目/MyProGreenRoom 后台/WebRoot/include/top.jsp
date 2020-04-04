<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>小米商城后台管理系统</title>
<script type="text/javascript" src="js/jquery1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		$(".div2").click(function(){ 
			$(this).next("div").slideToggle("slow")  
			.siblings(".div3:visible").slideUp("slow");
		});
	});
</script>
<style>
body{ margin:0;font-family:微软雅黑;}
.left{ width:200px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; color:#000000; font-size:14px; text-align:center;}
.div1{text-align:center; width:200px; padding-top:10px;}
.div2{height:40px; line-height:40px;cursor: pointer; font-size:13px; position:relative;border-bottom:#ccc 1px dotted;}
.jbsz {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/1.png);}
.xwzx {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/2.png);}
.zxcp {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/4.png);}
.lmtj {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/8.png);}
.div3{display: none;cursor:pointer; font-size:13px;}
.div3 ul{margin:0;padding:0;}
.div3 li{ height:30px; line-height:30px; list-style:none; border-bottom:#ccc 1px dotted; text-align:center;}
</style>
</head>
<body>
<div class="left">
<div class="div1">
<div class="left_top"><img src="images/bbb_01.jpg"><img src="images/bbb_02.jpg" id="2"><img src="images/bbb_03.jpg"><img src="images/bbb_04.jpg"> </div>
  <div class="div2"><div class="jbsz"> </div>用户管理</div>
      <div class="div3">
<ul>
		<li style="color: red"> <a href="${pageContext.request.contextPath}/user_addUser">添加用户</a></li>
        <li style="color: red"><a href="user.do?method=query">查看用户</a></li>
</ul>
  </div>
    <div class="div2"><div class="xwzx"> </div>商品管理</div>
      <div class="div3">
      <ul>
		<li style="color: red"><a href="shoes.do?method=toAddShoes">添加商品</a></li>
        <li style="color: red"><a href="shoes.do?method=query">查看商品</a></li>
        </ul>
  </div>
    <div class="div2"><div class="zxcp"> </div>订单管理</div>
      <div class="div3">
      <ul>
		<li style="color: red"><a href="order.do?method=query">查看订单</a></li>
         </ul>
  </div>
  
  <div class="div2"><div class="lmtj"> </div> 管理员管理</div>
      <div class="div3">
      <ul>
		<li style="color: red"><a href="admin.do?method=toAdmin">添加管理员</a></li>
         <li style="color: red"><a href="admin.do?method=query">查看管理员</a></li>
         </ul>
  </div>
  
  <div class="div2"><div class="lmtj"> </div>其他</div>
      <div class="div3">
      <ul>
		<li style="color: red"><a href="GreenGoom/Login.jsp">登录</a></li>
         <li style="color: red"><a href="GreenGoom/reg.jsp">注册</a></li>
         </ul>
  </div>
  
</div>
</div>

</body>
</html>
