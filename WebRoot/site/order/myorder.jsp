<%@ page language="java" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%> <%@ page isELIgnored="false" %> <%
String path = request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />

    <link
      href="<%=path %>/css/qiantai.css"
      rel="stylesheet"
      type="text/css"
      media="screen"
    />

  </head>

  <body>
    <div id="wrapper">
      <div id="logo">
        <h1><a href="#">高校食堂订餐系统 </a></h1>
        <p>
          <em><a href="#">&nbsp;</a></em>
        </p>
      </div>
      <hr />
      <!-- 我的订单页面的头部菜单栏daohang.jsp -->
      <div id="header">
        <jsp:include flush="true" page="/site/inc/nav.jsp"></jsp:include>
      </div>
      <!-- 我的订单页面的头部菜单栏daohang.jsp  -->

      <div id="page">
        <div id="page-bgtop">
          <!-- 右侧 -->
          <div id="content">
            <div class="post">
              <h2 class="title"><a href="#">我的订单</a></h2>
              <div class="entry">
                <c:forEach items="${res.getObj()}" var="order">
                  <fieldset style="width: 95%; margin-left: 5px">
                    <legend class="fieldtitle"></legend>
                    <table
                      class="bill"
                      width="97%"
                      cellpadding="4"
                      cellspacing="4"
                    >
                      <tr>
                        <td>订单编号：${order.getShowId()}</td>
                      </tr>
                      <tr>
                        <td>下单时间：${order.getTime()}</td>
                      </tr>
                      <tr>
                        <td>
                          订单状态：${order.getStatus()}
                        </td>
                      </tr>
                      <tr>
                        <td>排队计时：${order.getReply()}</td>
                      </tr>
                      <tr>
                        <td>送货地址：${order.getDeliveryAddress()}</td>
                      </tr>
                      <tr>
                        <td>付款方式：${order.getPaymentMethod()}</td>
                      </tr>
                    </table>
                  </fieldset>
                  <br />
                </c:forEach>
              </div>
            </div>
          </div>
          <!-- 右侧 -->
          <!-- 左侧菜品类别 -->
          <div id="sidebar">
            <jsp:include flush="true" page="/site/inc/left.jsp"></jsp:include>
          </div>
          <!-- 左侧菜品类别 -->
          <div style="clear: both">&nbsp;</div>
        </div>
      </div>

      <jsp:include flush="true" page="/site/inc/footer.jsp"></jsp:include>
      
    </div>
  </body>
</html>
