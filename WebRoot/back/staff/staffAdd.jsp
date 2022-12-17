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
                    <h4 class="card-title">员工信息添加</h4>
                    <form class="form" action="<%=path %>/staff?type=addStaff" method="post" id="addForm">
                      <div class="form-group">
                        <label for="exampleInputName1">用户名</label>
                        <input
                          type="text"
                          class="form-control"
                          id="name"
                          placeholder="名字"
                          name="user_name"
                        />
                      </div>
                      <div class="form-group">
                        <label for="exampleSelectGender">职位</label>
                        <select class="form-control" id="exampleSelectGender" name="level">
                          <option value="店员" >店员</option>
                          <option value="骑手" >骑手</option>
                          <option value="管理员" >管理员</option>
                        </select>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" class="form-control" id="pwd1" placeholder="密码" name="user_pwd">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputConfirmPassword1">确认密码</label>
                        <input type="password" class="form-control" id="pwd2" placeholder="确认密码">
                      </div>
                      <button type="submit" class="btn btn-primary mr-2 formBtn" onclick="submitForm()">
                        提交
                      </button>
                      <a href=""><button class="btn btn-dark" onclick="clearForm()">清空</button></a>
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
  <script type="text/javascript">
  	function clearForm(){
  		windows.location.href ='';
  	}
  	function submitForm(){
  		if($('.pwd1').val() =="" || $('.pwd2').val() ==="" || $('#name').val() === ""){
  			alert("请检查输入");
  			return;
  		}
  		if($('.pwd1').val() !== $('.pwd2').val()){
  			alert("两次输入密码不一致");
  			return;
  		}
  		$('#addForm').submit();
  	}
  </script>
  </body>
</html>
