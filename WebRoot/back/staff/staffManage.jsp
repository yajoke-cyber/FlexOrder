<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	String path = request.getContextPath(); 
	String	backPath = path+"/back";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>员工信息管理表</title>
    <jsp:include page="/back/include/headerCss.jsp"></jsp:include>
  </head>
  <body>
    <div class="container-scroller">
      <jsp:include page="/back/partials/sidebar.jsp"></jsp:include>


      <div class="container-fluid page-body-wrapper">
        <jsp:include page="/back/partials/navbar.jsp"></jsp:include>
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">员工信息管理</h4>
                  <div class="table-responsive">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th>用户名</th>
                          <th>职位</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${res.getObj()}" var="item">
                   			 <tr>
                          <td>${item.getUserName()}</td>
                          <td>	
                              ${item.getLevel()}
                          </td>
                          <td>
                            <div class="row" >
                           	<div class="dropdown">
                        		<button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 删除 </button>
                        		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
                          <a class="dropdown-item" href="<%=path %>/staff?type=deleteStaff&id=${item.getId()}">确认删除？</a>
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
          <jsp:include page="/back/partials/footer.jsp"></jsp:include>
        </div>
      </div>%
    </div>
    <jsp:include page="/back/include/footerJs.jsp"></jsp:include>
  </body>
</html>
