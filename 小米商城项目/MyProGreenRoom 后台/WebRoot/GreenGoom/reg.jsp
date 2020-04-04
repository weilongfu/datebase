<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>

<title>后台管理员注册</title>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table width="100%" border="0" cellspacing="5" cellpadding="10" >
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>
				<form action="../login.do?method=reg" method="post">
					<table width="500" border="0" align="center" cellpadding="10"
						cellspacing="5" class="font1 div1" >
						<tr>
							<td colspan="2" align="center"><span
								class="STYLE1">后台管理员注册</span></td>
						</tr>
						<tr>
							<td width="91" align="right">管理员名称：</td>
							<td width="354"><input type="text" name="AdminName" /></td>
						</tr>
						<tr>
							<td align="right">密码：</td>
							<td><input type="text" name="AdminPwd" /></td>
						</tr>
						<tr>
							<td align="right">确认密码：</td>
							<td><input type="password" name="upwd2" /></td>
						</tr>
						<tr>
							<td align="right">性别:</td>
							<td><input type="radio" name="AdminSex" value="男"
								checked="checked" />男 <input type="radio" name="AdminSex" value="女" />女
							</td>
						</tr>
						
						<tr>
							<td align="right">电话号码:</td>
							<td><input type="text" name="AdminPhone" />
							</td>
						</tr>

						<tr>
							<td>&nbsp;</td>
							<td><input type="reset" value="重置" /> <input type="submit"
								name="Submit2" value="提交" /> <input type="button"
								onclick="javascript:window.location='Login.jsp'" value="登录" />
							</td>
						</tr>

					</table>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>
