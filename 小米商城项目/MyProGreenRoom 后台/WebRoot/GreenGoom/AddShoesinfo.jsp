<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<%@include file="../include/top.jsp"%>
<meta charset="utf-8">
<title>添加商品信息</title>
</head>
<body>
	<div
		style="width: 100%;height:800px;position: absolute;top: 20px;left: 420px">
		<form action="shoes.do?method=AddShoes" method="post" enctype="multipart/form-data">
		<table style="width: 400px;text-align: center">
		
		    <tr>
				<td>商品图片:</td>
				<td><input type="file" name="shoesimg" value="" /></td>
			</tr>
			
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="shoesname" value="" /></td>
			</tr>

			<tr>
				<td>商品价格:</td>
				<td><input type="text" name="shoesprice" value="" /></td>
			</tr>

            <tr>
				<td>商品介绍:</td>
				<td><input type="text" name="introduce" value="" /></td>
			</tr>
			
			<tr>
				<td>商品描述:</td>
				<td><input type="text" name="shoesintr" value="" /></td>
			</tr>
			
			<tr>
				<td>商品库存:</td>
				<td><input type="text" name="shoescount" value="" /></td>
			</tr>


			<tr>
				<td>商品版本:</td>
				<td><input type="text" name="release" value="" /></td>
			</tr>


			<tr>
				<td>颜色:</td>
				<td><input type="text" name="color" value="" /></td>
			</tr>

             <tr>
				<td>分类关键字:</td>
				<td><input type="text" name="keyword" value="" /></td>
			</tr>    
            
                <tr>
				<td>类型:</td>
				<td><select name="shoesType">
						<option value="小米手机">小米手机</option>
						<option value="红米手机">红米手机</option>
						<option value="平板笔记本">平板笔记本</option>
						<option value="电视">电视</option>
						<option value="盒子·影音">盒子·影音</option>
						<option value="路由器">路由器</option>
				     </select>
				</td>
			</tr>
			
			<tr>
				<td>商品状态:</td>
				<td><select name="shoesstate">
						<option value="上架">上架</option>
						<option value="下架">下架</option>
				</select></td>
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

