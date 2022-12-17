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
      <!--头部 -->
      <div id="header">
        <jsp:include flush="true" page="/site/inc/nav.jsp"></jsp:include>
      </div>
      <!-- 头部 -->

      <div id="page">
        <div id="page-bgtop">
          <!-- 右侧 -->
          <div id="content">
            <div class="post">
              <h2 class="title"><a href="#">菜品详细信息</a></h2>
              <div class="entry">
                <form
                  action="<%=path %>/buy?type=addToCart"
                  method="post"
                >
                  <table
                    width="100%"
                    border="0"
                    cellpadding="9"
                    cellspacing="9"
                  >
                    <tr>
                      <td align="left">
                        <img
                          width="220"
                          height="180"
                          src="<%=path %>/${res.getObj().getImg()}"
                          style="border: 1px solid #ccc; padding: 3px"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td align="left">
                        商品编号：${res.getObj().getId()}
                      </td>
                    </tr>
                    <tr>
                      <td align="left">
                        商品名称：${res.getObj().getName()}
                      </td>
                    </tr>
                    <tr>
                      <td align="left">
                        商品描述：<c:out
                          value="${res.getObj().getIntroduction()}"
                          escapeXml="false"
                        ></c:out>
                      </td>
                    </tr>
                    <tr>
                      <td align="left">
                        价格：${res.getObj().getMarketPrice()}
                      </td>
                    </tr>
                    <tr>
                      <td align="left">
                        数量：<input
                          type="number"
                          name="quantity"
                          value="1"
                          class="number"
                          size="8"
                          onkeyup="this.value=this.value.replace(/\D/g,'')"
                          onafterpaste="this.value=this.value.replace(/\D/g,'')"
                        />
                        <button type="submit" style="width: 80px; height: 30px" >购买</button>
                        <!--插入菜品的数量框，onpropertychange当输入框属性变化时，触发onchange1属性，修改数据库菜品价格 下一句为按键之后触发将输入值为非数字的字符替换为空，粘贴之后触发将输入值为非数字的字符替换为空-->
                        <input
                          type="hidden"
                          name="goods_id"
                          value="${res.getObj().getId()}"
                        />           
                        
                      </td>
                    </tr>
                  </table>
                </form>
                
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
     
  </body>
</html>
