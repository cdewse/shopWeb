<%--
Created by IntelliJ IDEA.
User: cdewse
Date: 17-5-16
Time: 下午7:27
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>注册页面</title>
	<meta charset="utf-8">
</head>
<body onload="setSize();loadsession();" onresize="setSize();" class="font">
<form id="regist" class="regist" action="register.action" method="post">
	<fieldset>
	<legend>注册页面</legend>
	<table>
		<tr>
			<td><label>帐号</label>
			<td colspan="4"><input type="text" name="username" id="username"
				required onchange="sessionstore(this)" 
				pattern="^[a-zA-Z][\w*]{5,10}$"  title="帐号长度需为6-10位之间，且首字母必须为英文" 
				placeholder="input your account"></td>
			<td>${requestScope.get("registerError")}</td>
		</tr>
		<tr>
			<td><label>密码</label>
			<td colspan="4"><input type="password" name="password" id="passwd"
				required
				pattern="^(?![^a-zA-Z]+$)(?!\D+$).{6,15}$"  title="密码长度需为6-15位之间，且必须包含英文" 
				placeholder="input your password"></td>
		</tr>
		<tr>
			<td><label>确认密码</label>
			<td colspan="4"><input type="password" name="passwordAck" id="passwdAck"
				required 
				pattern="^(?![^a-zA-Z]+$)(?!\D+$).{6,15}$"  title="密码长度需为6-15位之间，且必须包含英文" 
				placeholder="input your password twice" onchange="passwdMatch();"></td>
		</tr>
		<tr>
			<td><label>性别</label></td>
			<td><input type="radio" name="sex" value="male" required></td><td><label>男</label></td>
			<td style="width: 20px"><input type="radio" name="sex" value="female" required></td><td><label>女</label></td>
		</tr>
		<tr>
			<td><label  for="birthday">生日</label>
			<td colspan="4"><input type="date" name="birthday" id="birthday" value="2000-01-01" required onchange="sessionstore(this)"></td>
		</tr>
		<tr>
			<td><label>邮箱</label>
			<td colspan="4"><input id="email" type="email" name="email"
				required onchange="sessionstore(this)" 
				placeholder="user@example.com"></td>
		</tr>
		<tr>
			<td><input type="submit" name="regist" value="注册" style="width: 70px"></td>
		</tr>
	</table>
	</fieldset>
</form>
<script type="text/javascript" src="js/regist.js"></script>
</body>
</html>