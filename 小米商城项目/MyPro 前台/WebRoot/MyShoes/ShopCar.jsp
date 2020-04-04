<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<script type="text/javascript">
	function check(id) {
		//获取复选框的id
		var id = document.getElementById("oncheck");
		if (id.checked) {
           
		}

	}

	function quanxuan() {
		var oncheck1 = document.getElementById("quanxuan");
		var oncheck = document.getElementsByName("oncheck");
		if (oncheck1.checked=true) {
			for (var i = 0; i < oncheck.length; i++) {
				oncheck[i].checked = true;
			}
		} 
	}

	function changeNum(n, index) {
		var num = document.getElementsByName("num")[index].value;
		if (num < 2 && n < 0) {
			document.getElementsByName("num")[index].value = 1;
		} else {
			document.getElementsByName("num")[index].value = parseInt(num) + n;
		}

		var id = document.getElementsByName("id")[index].value;
		var amount = document.getElementsByName("num")[index].value;
		window.location.href = "../shopCar.do?method=update&shoesid=" + id
				+ "&num=" + amount;
	}
</script>
<head>
<meta charset="UTF-8">
<meta name="author" content="order by dede58.com" />
<title>我的购物车</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<!-- start header -->
	<!--end header -->

	<!-- start banner_x -->
	<div class="banner_x center">
		<a href="./index.html" target="_blank"><div class="logo fl"></div></a>

		<div class="wdgwc fl ml40">我的购物车</div>
		<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
		<div class="dlzc fr">
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
				<li><a href="reg.jsp" target="_blank">注册</a></li>
			</ul>

		</div>
		<div class="clear"></div>
	</div>
	<div class="xiantiao"></div>
	<div class="gwcxqbj">
		<div class="gwcxd center">
			<div class="top2 center">
				<div class="sub_top fl">
					<input type="checkbox" value="quanxuan" class="quanxuan"
						id="quanxuan" name="quanxuan" onclick="quanxuan()" />全选
				</div>
				<div class="sub_top fl">商品名称</div>
				<div class="sub_top fl">单价</div>
				<div class="sub_top fl">数量</div>
				<div class="sub_top fl">小计</div>
				<div class="sub_top fr">操作</div>
				<div class="clear"></div>
			</div>

			<!-- 遍历购物车商品信息 -->
			<c:forEach items="${car.items}" var="entity" varStatus="vst">
				<div class="content2 center">
					<div class="sub_content fl ">

						<!-- 通过商品编号循环获取购物车商品列表选中项 -->
						<input type="checkbox" value="quanxuan" class="quanxuan"
							name="oncheck" onclick="check(${entity.value.shoes.shoesid})" />

					</div>
					<div class="sub_content fl">
						<img src="./image/${entity.value.shoes.shoesimg}" width="100px"
							height="100px">
					</div>
					<div class="sub_content fl ft20">${entity.value.shoes.shoesname}</div>
					<div class="sub_content fl">￥${entity.value.shoes.shoesprice}</div>

					<!-- /商品数量加减按钮 -->
					<div class="sub_content fl" style="width: 70px">
						<input type="button" value="-"
							onclick="changeNum(-1,${vst.index})" /> <input name="num"
							type="text" value="${entity.value.count}" size="1" /> <input
							name="id" type="hidden" value="${entity.value.shoes.shoesid }" />
						<input type="button" value="+" size="1"
							onclick="changeNum(1,${vst.index})" />
					</div>
					<!-- 商品数量加减按钮/ -->


					<div class="sub_content fl">${entity.value.total}</div>

					<!--商品删除处理  -->
					<div class="sub_content fl">
						<a
							href="../shopCar.do?method=delete&shoesid=${entity.value.shoes.shoesid}">×</a>
					</div>
					<div class="clear"></div>
				</div>
			</c:forEach>
		</div>
		<div class="jiesuandan mt20 center">
			<div class="tishi fl ml20">
				<ul>
					<li><a href="../index.do">继续购物</a></li>
					<li>|</li>
					<li>共<span>${car.totalAmount}</span>件商品，已选择<span>${car.totalAmount}</span>件
					</li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="jiesuan fr">
				<div class="jiesuanjiage fl">
					合计（不含运费）：<span>${car.totalPrice}元</span>
				</div>

				<div class="jsanniu fr">

					<!-- 进入下订单页面 -->
					<a href="../order.do?method=goorder"> <input class="jsan"
						type="submit" name="jiesuan" value="去结算" />
					</a>
				</div>

				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>

	</div>




	<!-- footer -->
	<footer class="center">

		<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select
			Region</div>
		<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号
			京网文[2014]0059-0009号</div>
		<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
	</footer>

</body>
</html>
