<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米手机列表</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		 <link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="MyShoes/ShopCar.jsp">购物车</a></div>
					<div class="fr">
						<ul>
							<c:choose>
						    <c:when test="${empty user }">
							<li><a href="login.jsp" target="_blank">登录</a></li>
							</c:when>
							
							<c:otherwise>
							<li><span style="color: red">${user.uname},欢迎您</span></li>
							<li><a href="../login.do?method=logout" target="_blank">注销</a></li>
							</c:otherwise>
							</c:choose>
							
							<li>|</li>
							<li><a href="MyShoes/reg.jsp" target="_blank" >注册</a></li>
							<li>|</li>
							<li><a href="queryOrders.do?method=queryOrder"><span style="color: red">订单中心</span></a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
				<li><a href="liebiao.do?type=小米手机" target="_blank">小米手机</a></li>
					<li><a href="liebiao.do?type=红米手机">红米</a></li>
					<li><a href="liebiao.do?type=平板笔记本">平板·笔记本</a></li>
					<li><a href="liebiao.do?type=电视">电视</a></li>
					<li><a href="liebiao.do?type=小米手机">盒子·影音</a></li>
					<li><a href="liebiao.do?type=路由器">路由器</a></li>
					<li><a href="liebiao.do?type=小米手机">智能硬件</a></li>
					<li><a href="liebiao.do?type=小米手机">服务</a></li>
					<li><a href="liebiao.do?type=小米手机">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="liebiao.do" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货" name="key"/>
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	<!-- start banner_y -->
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">小米手机</div>
			<div class="main center">
			<!-- 循环加载商品信息 -->
			<c:forEach items="${pagination.list}" var="shoes" varStatus="vst">
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="info.do?method=shoes&shoesid=${shoes.shoesid}" target="_blank"><img src="./image/${shoes.shoesimg}" alt=""></a></div>
					<div class="pinpai"><a href="info.do?method=shoes&shoesid=${shoes.shoesid}" target="_blank">${shoes.shoesname}</a></div>
					<div class="youhui">${shoes.shoesintr}</div>
					<div class="jiage">${shoes.shoesprice}元</div>
					
				</div>
				</c:forEach>
				<div class="clear"></div>
			</div>
		</div>
		
      <div class="clear"></div>
      <!-- 商品加载完毕 -->
      
      
      <!-- 跳转页码 -->
           <form action="liebiao.do" method="post">
		<div align="right" class="font2" style="clear:both">
			总记录数：${pagination.rowCount } &nbsp;&nbsp;
			${pagination.currentPage}/${pagination.pageCount } 
			<a href="liebiao.do?page=1&key=${param.key}">首页 </a> <a
				href="liebiao.do?page=${pagination.prevPage}&key=${param.key}"> 上一页 </a> <a
				href="liebiao.do?page=${pagination.nextPage}&key=${param.key}">下一页 </a> <a
				href="liebiao.do?page=${pagination.lastPage}&key=${param.key}">尾页</a> 
				<input name="page" type="text" size="1" id="page" value="${pagination.currentPage}"/> 
				<input type="submit" name="Submit" value="Go" />
		</div>
		</form>
		<footer class="mt20 center">			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

		</footer>

	<!-- end danpin -->


	</body>
</html>
