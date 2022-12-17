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
                    <h4 class="card-title">菜品种类添加</h4>
                    <form class="forms-sample">
                      <div class="form-group">
                        <label for="exampleInputName1">菜品种类名</label>
                        <input
                          type="text"
                          class="form-control"
                          id="exampleInputName1"
                          placeholder="名字"
                        />
                      </div>
                     <div class="form-group">
                        <label for="exampleTextarea1">种类描述</label>
                        <textarea
                          class="form-control"
                          id="exampleTextarea1"
                          rows="4"
                        ></textarea>
                      </div>
                      <button type="submit" class="btn btn-primary mr-2">
                        提交
                      </button>
                      <button class="btn btn-dark">清空</button>
                    </form>
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
