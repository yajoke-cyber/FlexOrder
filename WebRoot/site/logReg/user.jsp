<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>网上订餐系统</title>
	<link rel="stylesheet" href="<%=path %>/site/logReg/index.css">

  </head>
  <body>
    <h1 class="title">网上订餐系统</h1>
    <div class="control">
      <div class="item">
        <div class="active" index="0">登录</div>
        <div index="1">注册</div>
      </div>
      <div class="content">
    <form action="<%=path %>/user?type=userLog" id="logForm" method="post">
        <div class="active login">
          <p>用户名</p>
          <input type="text" placeholder="用户名" name="logUname"/>
          <p>密码</p>
          <input type="password" placeholder="密码" name="logPwd"/>
          <br />
          <input onclick="logSubmit()" class="submit" value="登录"/>
        </div>
    </form>
    <form action="<%=path %>/user?type=userReg" id="regForm" method="post">
        <div class="register">
          <p>用户名</p>
          <input type="text" placeholder="name" name="regUname" />
          <p>密码</p>
          <input type="password" placeholder="密码" name="regPwd" id="regPwd"/>
          <p>确认密码</p>
          <input type="password" placeholder="确认密码" id="regPwdConfirm"/>
          <br />
          <input onclick="regSubmit()" class="submit" value="注册">
        </div>
        <a href="<%=path%>/site/index.jsp" class='href'>稍后登录</a>
      </div>
      </form>
    </div>
    <script src="<%=path %>/site/logReg/index.js"></script>
  </body>
</html>
