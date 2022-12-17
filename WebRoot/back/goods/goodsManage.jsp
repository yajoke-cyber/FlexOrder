<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String path = request.getContextPath(); String
backPath = path+"/back"; %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>标准页面</title>
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
              <div class="col-md-12 col-xl-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">菜品信息管理</h4>
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th>菜名</th>
                            <th>种类</th>
                            <th>价格</th>
                            <th>操作</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach items="${res.getObj()}" var="item">
                           	<tr>
                            <td>${item.getName()}</td>
                            <td>${item.getCatalog_id()}</td>
                            <td>${item.getMarketPrice()}</td>
                            <td>
                            <div class="row" >
                            <a href="<%=path%>/goods?type=goodsDetailBackend&id=${item.getId()}">
                            	<button class="btn btn-success btn-md" >详情</button>
                            </a>
                            &nbsp; &nbsp;
                            <a href="<%=path%>/goods?type=goodsEdit&id=${item.getId()}">
                            	<button class="btn btn-primary btn-md">修改</button>
                            </a>
                            &nbsp; &nbsp;
                           	<div class="dropdown">
                        		<button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 删除 </button>
                        		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
                          <a class="dropdown-item" href="<%=path%>/goods?type=goodsDel&id=${item.getId()}">确认删除？</a>
                            </div>
                            
                        </div>
                      </div>
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
      </div>
      %
    </div>
     <jsp:include page="/back/include/footerJs.jsp"></jsp:include>
  </body>
</html>
