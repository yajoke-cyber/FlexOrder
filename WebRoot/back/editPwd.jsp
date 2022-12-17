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
      <jsp:include page="partials/sidebar.jsp"></jsp:include>

      <div class="container-fluid page-body-wrapper">
        <jsp:include page="/back/partials/navbar.jsp"></jsp:include>
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
              <div class="col-md-3 grid-margin stretch-card"></div>
              <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">修改密码</h4>
                    <form class="forms-sample">
                      <div class="form-group">
                        <label for="exampleInputUsername1">用户名</label>
                        <input
                          type="text"
                          class="form-control"
                          id="exampleInputUsername1"
                          placeholder="Username"
                        />
                      </div>

                      <div class="form-group">
                        <label for="exampleInputPassword1" >密码</label>
                        <input
                          type="password"
                          class="form-control"
                          id="pwd"
                          placeholder="Password"
                          name="newPwd"
                        />
                      </div>
                      <div class="form-group">
                        <label for="exampleInputConfirmPassword1"
                          >确认密码</label
                        >
                        <input
                          type="password"
                          class="form-control"
                          id="confirmPwd"
                          placeholder="Password"
                        />
                      </div>
                      <button type="submit" class="btn btn-primary mr-2 subBtn" onclick="submit()">
                        提交
                      </button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <jsp:include page="/back/partials/footer.jsp"></jsp:include>
        </div>
      </div>
    </div>
    <jsp:include page="/back/include/footerJs.jsp"></jsp:include>
    <script>
    	function submit(){
    		if($("#confirmPwd").value != $("#pwd").value){
    			alert("两次密码输入不一致，请重新输入");
    			return;
    		}
    		$(".subBtn").submit();
    	}
    </script>
  </body>
</html>
