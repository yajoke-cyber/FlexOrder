<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath(); 
	String backPath = path+"/back"; 
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>留言信息管理</title>
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
                    <div class="d-flex flex-row justify-content-between">
                      <h4 class="card-title">留言信息管理</h4>
                    </div>
                    <div class="preview-list">
                       <c:forEach items="${res.getObj()}" var="item">
							<div class="preview-item border-bottom">
                        <div class="preview-thumbnail">
                          
                        </div>
                        <div class="preview-item-content d-flex flex-grow">
                          <div class="flex-grow">
                            <div
                              class="d-flex d-md-block d-xl-flex justify-content-between"
                            >
                              <h6 class="preview-subject">${item.getUser().getName()}</h6>
                              <p class="text-muted text-small">${item.getLeaveMsgTime() }</p>
                            </div>
                            <p class="text-muted">
                              ${item.getContent() }
                            </p>
                          </div>
                        </div>
                       
                      </div>
						</c:forEach>
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
