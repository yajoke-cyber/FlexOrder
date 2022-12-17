<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%> <%@ page isELIgnored="false" %> <%
String path = request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />
  </head>

  <body>
    <div id="menu">
      <ul>
        <li><a href="<%=path %>/goods?type=goodsNew">菜品信息</a></li>
        <li><a href="<%=path %>/goods?type=goodsSearchPage">菜品查询</a></li>
        <li><a href="#" onclick="mycart()">我的购物车</a></li>
        <li><a href="#" onclick="myorder()">我的订单</a></li>
        <li><a href="<%=path %>/leaveMsg?type=leaveMsgAll">系统留言板</a></li>
      </ul>
    </div>
    <div id="search">
      <form method="post" action="" style="color: white; font-family: 微软雅黑">
        <c:if test="${user != null }">
          欢迎您：${user.getName() }&nbsp;&nbsp;
          <!--取得用户名-->
          <a
            href="<%=path %>/user?type=userLogout"
            style="color: white; font-family: 微软雅黑"
            >安全退出</a
          >
          &nbsp;&nbsp;
        </c:if>
        <c:if test="${user == null }">
          <a
            href="<%=path %>/site/logReg/user.jsp"
            style="color: white; font-family: 微软雅黑"
            >会员登陆</a
          >
        </c:if>
      </form>
    </div>
    <script type="text/javascript">
      function mycart() //我的购物车
      {
           <c:if test="${empty user }">  //判断是否登录了
                 alert("请先登录");
           </c:if>

           <c:if test="${!empty user }">
               var url="<%=path %>/buy?type=myCartPage";
               window.open(url,"_self");
           </c:if>
      }

      function myorder()
      {
           <c:if test="${user == null}">  //判断是否登录了
                 alert("请先登录");
           </c:if>

           <c:if test="${user != null}">
               var url="<%=path %>/buy?type=myorder";
               window.open(url,"_self");
           </c:if>
      }
    </script>
  </body>
</html>
