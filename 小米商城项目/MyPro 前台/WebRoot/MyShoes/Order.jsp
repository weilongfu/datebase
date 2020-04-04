<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR	/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="author" content="order by dede58.com" />
<title>订单</title>
<link rel="stylesheet" type="text/css" href="../css/ShoppingCart.css">
<link rel="stylesheet" type="text/css" href="../css/style2.css">
<link rel="stylesheet" type="text/css" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var region = $("#region");
		var address = $("#address");
		var number_this = $("#number_this");
		var name = $("#name_");
		var phone = $("#phone");
		$("#sub_setID").click(function() {
			var input_out = $(".input_style");
			for (var i = 0; i <= input_out.length; i++) {
				if ($(input_out[i]).val() == "") {
					$(input_out[i]).css("border", "1px solid red");

					return false;
				} else {
					$(input_out[i]).css("border", "1px solid #cccccc");
				}
			}
		});
		var span_momey = $(".span_momey");
		var b = 0;
		for (var i = 0; i < span_momey.length; i++) {
			b += parseFloat($(span_momey[i]).html());
		}
		var out_momey = $(".out_momey");
		out_momey.html(b);
		$(".shade_content").hide();
		$(".shade").hide();
		$('.nav_mini ul li').hover(function() {
			$(this).find('.two_nav').show(100);
		}, function() {
			$(this).find('.two_nav').hide(100);
		})
		$('.left_nav').hover(function() {
			$(this).find('.nav_mini').show(100);
		}, function() {
			$(this).find('.nav_mini').hide(100);
		})
		$('#jia').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) + 1);
		})
		$('#jian').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) - 1);
		})
		$('.Caddress .add_mi').click(
				function() {
					$(this).css('background',
							'url("images/mail_1.jpg") no-repeat').siblings(
							'.add_mi').css('background',
							'url("images/mail.jpg") no-repeat')
				})
	})
	var x = Array();

	function func(a, b) {
		x[b] = a.html();
		alert(x)
		a.css('border', '2px solid #f00').siblings('.min_mx').css('border',
				'2px solid #ccc');
	}

	function onclick_close() {
		var shade_content = $(".shade_content");
		var shade = $(".shade");
		if (confirm("确认关闭么！此操作不可恢复")) {
			shade_content.hide();
			shade.hide();
		}
	}

	function onclick_open() {
		$(".shade_content").show();
		$(".shade").show();
		var input_out = $(".input_style");
		for (var i = 0; i <= input_out.length; i++) {
			if ($(input_out[i]).val() != "") {
				$(input_out[i]).val("");
			}
		}
	}

	function onclick_remove(r) {
		if (confirm("确认删除么！此操作不可恢复")) {
			var out_momey = $(".out_momey");
			var input_val = $(r).parent().prev().children().eq(1).val();
			var span_html = $(r).parent().prev().prev().children().html();
			var out_add = parseFloat(input_val).toFixed(2)
					* parseFloat(span_html).toFixed(2);
			var reduce = parseFloat(out_momey.html()).toFixed(2)
					- parseFloat(out_add).toFixed(2);
			console.log(parseFloat(reduce).toFixed(2));
			out_momey.text(parseFloat(reduce).toFixed(2))
			$(r).parent().parent().remove();
		}
	}

	function onclick_btnAdd(a) {
		var out_momey = $(".out_momey");
		var input_ = $(a).prev();
		var input_val = $(a).prev().val();
		var input_add = parseInt(input_val) + 1;
		input_.val(input_add);
		var btn_momey = parseFloat($(a).parent().prev().children().html());
		var out_momey_float = parseFloat(out_momey.html()) + btn_momey;
		out_momey.text(out_momey_float.toFixed(2));
	}

	function onclick_reduce(b) {
		var out_momey = $(".out_momey");
		var input_ = $(b).next();
		var input_val = $(b).next().val();
		if (input_val <= 1) {
			alert("商品个数不能小于1！")
		} else {
			var input_add = parseInt(input_val) - 1;
			input_.val(input_add);
			var btn_momey = parseFloat($(b).parent().prev().children().html());
			var out_momey_float = parseFloat(out_momey.html()) - btn_momey;
			out_momey.text(out_momey_float.toFixed(2));
		}
	}
	
	function selectAdd(myAdd){
		//将当前选中的发货地址编号，赋值给隐藏域
		document.getElementById("selectedAddress").value = myAdd.id;
		document.getElementById("addMessage").style.display = "none";
	}
	
	//提交订单
	function submitOrder(){
		var id =document.getElementById("selectedAddress").value;
		if(id==""){
			document.getElementById("addMessage").style.display = "block";
		}else{
			document.getElementById("addMessage").style.display = "none";
			location.href = "../order.do?method=addorder&addressId="+id;
		}
	}
</script>
</head>

<body>
	<div id="top">
		<div id="top_main">
			<ul class="topu">
				<li>
					<div class="xing"></div> <a href="#">收藏商城</a>
				</li>
			</ul>
			
			<!-- 判断用户是否为空 -->
			<div id="hello">
				<span>
				<c:choose>
				<c:when test="${empty user }"> <a href="MyShoes/login.jsp">[登录]</a></c:when>
				<c:otherwise><span style="color: red">${user.uname},欢迎您&nbsp;&nbsp;</span><a href="../login.do?method=logout" target="_blank">注销</a>
				  </c:otherwise>
                </c:choose>
				<a href="reg.jsp">&nbsp;&nbsp;[免费注册]</a>
				</span>
			</div>
			
			
			<div class="topright">
				<ul>
					<li>
						<div class="cun">
							<a href="../queryOrders.do?method=queryOrder">我的订单</a>
						</div>
					</li>
					<li class="kefu">
						<div class="cun">
							<div class="a1">
								<div class="kefuhide">
									<span>客户服务</span>
									<div class="downjian1"></div>
									<ul>
										<li><a href="#">帮助中心</a></li>
										<li><a href="#">售后服务</a></li>
										<li><a href="#">在线客服</a></li>
										<li><a href="#">投诉中心</a></li>
										<li><a href="#">客服邮箱</a></li>
									</ul>
								</div>
							</div>
						</div>
					</li>
					<li class="wangzhan">
						<div class="cun">
							<span>网站导航</span>
							<div class="downjian1"></div>
						</div>
						<div class="wangzhanhide">
							<div class="tese">
								<span>特色栏目</span>
							</div>
							<div class="tesemain">
								<a href="#">商城通信</a> <a href="#">校园之星</a> <a href="#">视频购物</a> <a
									href="#">商城社区</a> <a href="#">在线读书</a> <a href="#">装机大师</a> <a
									href="#">商城E卡 </a> <a href="#">家装城</a> <a href="#">搭配购 </a> <a
									href="#">我喜欢 </a> <a href="#">游戏社区</a>
							</div>
							<div class="tese">
								<span>企业服务</span>
							</div>
							<div class="tesemain1">
								<a href="#">企业采购</a> <a href="#">办公直通车</a>
							</div>
							<div class="tese">
								<span>旗下网站</span>
							</div>
							<div class="tesemain2">
								<a href="#">English Site</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="Caddress">
		<div class="open_new">
			<button class="open_btn" onclick="javascript:onclick_open();">使用新地址</button>
		</div>
		<div id="addMessage" style="color:red;display:none;">请选择一个收货地址！</div>
		<c:forEach var="myAdd" items="${userAddresses}">
			<div class="add_mi" id="${myAdd.id}"  onclick="selectAdd(this)">
				<p style="border-bottom:1px dashed #ccc;line-height:28px;">
				<input type="radio" name="name"/>
				${myAdd.area}(${myAdd.name}收)</p>
				<p>${myAdd.address} ${myAdd.tel}</p>
			</div>
		</c:forEach>
		<input type="hidden" id="selectedAddress" name="selectedAddress"/>
	</div>

	<div class="shopping_content">
		<div class="shopping_table">
			<table border="1" bordercolor="#cccccc" cellspacing="0"
				cellpadding="0" style="width: 100%; text-align: center;">
				<tr>
					<th>商品图片</th>
					<th>商品名称</th>
					<th>版本</th>
					<th>商品价格</th>
					<th>商品数量</th>
				</tr>
				
				<!-- 循环遍历购物车选中项的商品-->
				<c:forEach var="item" items="${car.items}">
					<tr>
						<td><a><img class="goodImg" src="image/${item.value.shoes.shoesimg}" /></a></td>
						<td><span>${item.value.shoes.shoesname}</span></td>
						<td>
							<div class="">
								<span id="">${item.value.shoes.release}</span>
							</div>
						</td>
						<td><span class="span_momey">${item.value.shoes.shoesprice}</span></td>
						<td><span class="span_money">${item.value.count}</span></td>
					</tr>
				</c:forEach>

			</table>
			<div class=""
				style="width: 100%; text-align: right; margin-top: 10px;">
				<div class="div_outMumey" style="float: left;">
					总价：${car.totalPrice}
				</div>
				<button class="btn_closing" onclick="submitOrder()">提交订单</button>
			</div>
		</div>
	</div>

	<div class="shade"></div>

	<div class="shade_content">
		<div class="col-xs-12 shade_colse">
			<button onclick="javascript:onclick_close();">x</button>
		</div>
		<div class="nav shade_content_div">
			<div class="col-xs-12 shade_title">新增收货地址</div>
			<div class="col-xs-12 shade_from">
			
			<!-- 添加收货地址信息 -->
				<form action="../order.do?method=addOrderAddress" method="post">
					<div class="col-xs-12">
						<span class="span_style" id="">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</span>
						<input class="input_style" type="" name="txtArea" id="region" value=""
							placeholder="&nbsp;&nbsp;请输入您的所在地区" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">详细地址</span> <input
							class="input_style" type="" name="txtAddress" id="address" value=""
							placeholder="&nbsp;&nbsp;请输入您的详细地址" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">邮政编号</span> <input
							class="input_style" type="" name="txtZipcode" id="number_this" value=""
							placeholder="&nbsp;&nbsp;请输入您的邮政编号" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" class="span_sty" id="">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
						<input class="input_style" type="" name="txtName" id="name_" value=""
							placeholder="&nbsp;&nbsp;请输入您的姓名" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">手机号码</span> <input
							class="input_style" type="" name="txtTel" id="phone" value=""
							placeholder="&nbsp;&nbsp;请输入您的手机号码" />
					</div>
					<div class="col-xs-12">
						<input class="btn_remove" type="button" id=""
							onclick="javascript:onclick_close();" value="取消" /> 
							<input type="submit" class="sub_set" id="sub_setID" value="提交" />
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 底部开始 -->
	<div id="down">
		<div class="down_top">
			<a href="#">关于我们</a> <a href="#">联系我们</a> <a href="#">商家入驻</a> <a
				href="#">营销中心</a> <a href="#">手机商城</a> <a href="#">友情链接</a> <a
				href="#">销售联盟</a> <a href="#">商城社区</a> <a href="#">商城公益</a> <a
				href="#" style="border-right:none">English Site</a>
		</div>
		<div class="down_center">
			<span>北京市公安局朝阳分局备案编号110105014669 | 京ICP证070359号 | <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>
				| 新出发京零 字第大120007号
			</span> <span><a href="#">音像制品经营许可证苏宿批005号</a> |
				出版物经营许可证编号新出发(苏)批字第N-012号 | 互联网出版许可证编号新出网证(京)字150号</span> <span><a
				href="#">网络文化经营许可证京网文[2011]0168-061号</a> 违法和不良信息举报电话：4006561155
				Copyright © 2004-2014 商城JD.com 版权所有</span> <span>商城旗下网站：<a href="#">360TOP</a><a
				href="#">拍拍网</a><a href="#">网银在线</a></span>
		</div>
		<div class="down_bot">
			<img src="images/bot1.gif" alt="" /> <img src="images/bot2.gif"
				alt="" /> <img src="images/bot3.png" alt="" /> <img
				src="images/bot4.png" alt="" />
		</div>
	</div>
	<!-- 底部结束 -->
</body>

</html>