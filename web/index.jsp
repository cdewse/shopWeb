<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cdewse
  Date: 17-5-7
  Time: 下午5:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body class="container box-zero">
    <div class="container">
      <div class="navigate">
        <div class="row d">
          <div class="col-3"></div>
          <div class="col-3"></div>
          <div class="col-3">
            <a id="login" href="<s:url action="location">
                                   <s:param name="location">login</s:param>
                                 </s:url>">登录</a>
            <a href="<s:url action="location">
                       <s:param name="location">register</s:param>
                     </s:url>">注册</a>
            ${username}
          </div>
          <div class="col-3"></div>
        </div>
      </div>
    </div>
  </body>
</html>
