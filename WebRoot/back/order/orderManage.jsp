<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath(); 
	String	backPath = path+"/back"; 
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>订单信息管理</title>
    <jsp:include page="/back/include/headerCss.jsp"></jsp:include>
  </head>
  <body>
    <div class="container-scroller">
      <jsp:include page="/back/partials/sidebar.jsp"></jsp:include>


      <div class="container-fluid page-body-wrapper">
        <jsp:include page="/back/partials/navbar.jsp"></jsp:include>
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
              <div class="col-12 grid-margin">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">订单信息管理</h4>
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th>订单号</th>
                            <th>用户ID</th>
                            <th>金额</th>
                           
                            <th>付款方式</th>
                            <th>创建时间</th>
                            <th>收款地址</th>
                            <th>订单状态</th>
                            <th>操作</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${res.getObj()}" var="item">
                           	<tr>
                            <td>${item.getShowId()}</td>
                            <td>${item.getUser_id()}</td>
                            <td>${item.getAmount()}</td>
                            <td>${item.getPaymentMethod()}</td>
                            <td>${item.getDeliveryAddress()}</td>
                            <td>${item.getTime()}</td>
                            <td>
                              
                             <c:if test="${item.getStatus() eq '已支付'}">
                            	<div class="badge badge-outline-warning">
                                	已支付
                              </div>
                            </c:if>
                            <c:if test="${item.getStatus() eq '已出餐'}">
                            	<div class="badge badge-outline-info">
                                	已出餐
                              </div>
                            </c:if>
                            <c:if test="${item.getStatus() eq '已送达'}">
                            	 <div class="badge badge-outline-success">
                                	已送达
                              	</div>
                            </c:if>
                              
                            </td>
                            <td>
                            <c:if test="${item.getStatus() eq '已支付'}">
                            	
                            	<a href="<%=path%>/order?type=orderAccept&id=${item.getId()}">
                            	<button class="btn btn-primary btn-md">
                            		出餐
                            		</button>
                            	</a>
                            	
                            </c:if>
                            <c:if test="${item.getStatus() eq '已出餐'}">
                            	
                            	<a href="<%=path%>/staff?type=AcceptOrder&orderId=${item.getId()}">
                            	<button class="btn btn-primary btn-md">
                            	送达
                            	</button>
                            	</a>
                            	
                            </c:if>   
                            </td>
                          </tr>
                           </c:forEach>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <jsp:include page="/back/partials/footer.jsp"></jsp:include>
        </div>
      </div>%
    </div>
    <jsp:include page="/back/include/footerJs.jsp"></jsp:include>
  </body>
</html>
