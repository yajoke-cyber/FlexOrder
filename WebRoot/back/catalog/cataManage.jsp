<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%  String path = request.getContextPath(); 
	String backPath = path+"/back"; 
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>种类管理</title>
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
                    <h4 class="card-title">菜品种类管理</h4>
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th>序号</th>
                            <th>类别名</th>
                            <th>描述</th>
                            <th>操作</th>
                          </tr>
                        </thead>
                        <tbody>
                          
                        <c:forEach items="${res.getObj()}" var="item">
                   			<tr>
                            <td>${item.getId()}</td>
                            <td>${item.getName()}</td>
                             <td>${item.getDetail()}</td>
                            <td>
                            <div class="row" >
                            <!--  <a href="<%=backPath%>/catalog/cataEdit.jsp">
                            	<button class="btn btn-primary btn-md">修改</button>
                            </a>
                            -->
                            &nbsp; &nbsp;
                           	<div class="dropdown">
                        		<button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 删除 </button>
                        		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
                          <a class="dropdown-item" href="<%=path%>/catalog?type=catalogDel&id=${item.getId()}">确认删除？</a>
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
