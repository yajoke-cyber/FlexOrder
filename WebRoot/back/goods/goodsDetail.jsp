<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath(); 
	String	backPath = path+"/back"; 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>种类添加</title>
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
              <div class="col-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">菜品信息添加</h4>
                    
                      <div class="form-group">
                        <label for="exampleInputName1">菜品名</label>
                        <div class="text-primary">${res.getObj().getName()}</div>
                      </div>
                      <div class="form-group">
                        <label for="exampleSelectGender">菜品种类</label>
                        <div class="text-primary">${res.getObj().getCatalog_id()}</div>
                      </div>
                      <div class="form-group">
                       <label for="exampleSelectGender">菜品价格</label>
                      <div class="text-primary">￥${res.getObj().getMarketPrice()}</div>
                    </div>
                     <div class="form-group">
                        <label for="exampleTextarea1">菜品描述</label>
                        <div class="text-primary">${res.getObj().getIntroduction()}</div>
                      </div>
                      <div class="form-group">
                        <label>图片</label>
                        <div style="width:100px"> <img style="width:100px" src="<%=path %>/${res.getObj().getImg()}"/></div>
                      </div>
                      <a href="<%=path%>/goods?type=goodsMana">
                      	<button  class="btn btn-primary mr-2">
                        返回
                      	</button>
                      </a>
                   
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
