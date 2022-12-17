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
        <h1><a href="#">高校食堂订餐系统</a></h1>
        <p>
          <em><a href="#">&nbsp;</a></em>
        </p>
      </div>
      <hr />
      <!-- 头部 -->
      <div id="header">
        <jsp:include flush="true" page="/site/inc/nav.jsp"></jsp:include>
      </div>
      <!-- 头部 -->

      <div id="page">
        <div id="page-bgtop">
          <!-- 右侧 -->
          <div id="content">
            <div class="post">
              <h2 class="title"><a href="#">我的购物车</a></h2>
              <div class="entry">
                <table
                  width="98%"
                  border="0"
                  cellpadding="2"
                  cellspacing="1"
                  align="center"
                  style="margin-top: 8px"
                >
                  <tr align="center" bgcolor="#FAFAF1" height="22">
                    <td>商品名称</td>
                    <td>购买价格</td>
                    <td>购买数量</td>
                    <td>总金额</td>
                    <td>操作</td>
                  </tr>
                  <c:forEach items="${res.getObj()}" var="item">
                    <tr align="center" bgcolor="#FFFFFF" height="22">
                      <td bgcolor="#FFFFFF" align="center">
                        ${item.getGoods().getName()};
                      </td>
                      <td bgcolor="#FFFFFF" align="center">
                        ￥:${item.getGoods().getMarketPrice()}
                      </td>
                      <td bgcolor="#FFFFFF" align="center">
                        <input
                          type="text"
                          onChange="modiNum(${item.getId()},this.value)"
                          value="${item.getGoods_Amount()}"
                          size="4"
                        />
                      </td>
                      <!-- 改变数量 -->
                      <td bgcolor="#FFFFFF" align="center">
                        ${item.getGoods_Amount()  * item.getGoods_quantity()}
                      </td>
                      <!-- 总金额=特价*数量 -->
                      <td bgcolor="#FFFFFF" align="center">
                        <input
                          type="button"
                          value="删除"
                          style="width: 50px; height: 20px"
                          onclick="delGoodsFromCart(${item.getId()})"
                        />
                      </td>
                    </tr>
                  </c:forEach>
                  <tr>
                    <td colspan="5" class="Order_Total" align="right">
                      <br />
                      总金额：<span id="totalMoney"
                        >${100}</span
                      >
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      <img
                        id="indicator1"
                        src="<%=path %>/images/loading.gif"
                        style="display: none"
                      />
                    </td>
                  </tr>
                </table>
                <table>
                  <tr height="7">
                    <td></td>
                  </tr>
                  <tr>
                    <td width="120"></td>
                    <td>
                       <button
                        style="width: 80px; height: 30px"
                        onclick="clearCart()"
                       
                      >清空</button>
                    </td>
                    <td>
                      <button
                        style="width: 80px; height: 30px"
                        onclick="orderConfirm()"
                       
                      >结账</button>
                    </td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
          <!-- 右侧 -->
          <!-- 左侧 -->
          <div id="sidebar">
            <jsp:include flush="true" page="/site/inc/left.jsp"></jsp:include>
          </div>
          <!-- 左侧 -->
          <div style="clear: both">&nbsp;</div>
        </div>
      </div>
    </div>
    <script>
    	function orderConfirm(){
    		window.location.href="<%=path %>/buy?type=orderConfirm";
    	}
		function clearCart(){
			window.location.href="<%=path %>/buy?type=clearCart";
    	}
    </script>
  </body>
</html>
