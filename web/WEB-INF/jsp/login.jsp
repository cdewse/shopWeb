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
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1 class="center"><strong>XX网站登录界面</strong></h1>
<form action="login.action" class="login" method="post">
    <fieldset>
        <legend><strong>请登录</strong></legend>
        <ol>
            <li>${requestScope.get("error")}</li>
            <li>
                <label for="username">帐号</label>
                <input cid="username" type="text" name="username"
                       required
                       placeholder="Input your accont">
            </li>
            <li>
                <label for="passwd">密码</label>
                <input cid="passwd" type="password" name="password"
                       required
                       placeholder="Input your password">
            </li>
            <li>
                <input cid="submit" type="submit" name="submit" value="登录">
                <input cid="regist" type="button" value="注册" onclick="location.href='location.action?location=register'"></button>
                <a href="regist.jsp">忘记密码?</a>
            </li>
        </ol>
    </fieldset>
</form>
</body>
</html>