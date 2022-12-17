<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
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

    <script type="text/javascript"></script>
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
              <h2 class="title"><a href="#">菜品信息</a></h2>
              <div class="entry">
                <!-- 设置菜品图片样式 -->
                <table class="main" border="0" cellSpacing="2" cellPadding="2">
                  <tr>
                    <c:forEach
                      items="${res.getObj()}"
                      var="goods"
                      varStatus="sta"
                    >
                    
                      <c:if test="${sta.index%4==0}">
                        <!-- 每行放4张图片 -->
                        </tr>
                      	<tr>
                      </c:if>
                      <td>
                        <table
                          onmouseover="this.style.backgroundColor='#FF6600'"
                          onmouseout="this.style.backgroundColor=''"
                          border="0"
                          cellSpacing="1"
                          cellPadding="2"
                          width="98"
                          bgColor="#e1e1e1"
                          align="center"
                          height="100"
                        >
                          <tr>
                            <td bgColor="#ffffff" align="left">
                              <p align="center">
                                <a
                                  href="<%=path %>/goods?type=goodsDetailFrontEnd&id=${goods.getId()}"
                                  ><img
                                    border="0"
                                    align="absMiddle"
                                    src="<%=path %>/${goods.getImg()}"
                                    width="150"
                                    height="140"
                                /></a>

                                <center>
                                  <a
                                    href="<%=path %>/goods?type=goodsDetailFrontEnd&id=${goods.getId()}"
                                    ><font color="#ff0000"></font
                                    >${goods.getName()}</a
                                  >
                                </center>
                              </p>
                            </td>
                          </tr>
                        </table>
                      </<td>
                    </c:forEach>
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

      <jsp:include flush="true" page="/site/inc/footer.jsp"></jsp:include>
    </div>
  </body>
</html>
