<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String path = request.getContextPath(); String
backPath = path+"/back"; %>
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
          <div class="content-wrapper"></div>
          <jsp:include page="/back/partials/footer.jsp"></jsp:include>
        </div>
      </div>
    </div>
    <jsp:include page="/back/include/footerJs.jsp"></jsp:include>
  </body>
</html>
