<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath(); String
	backPath = path+"/back"; 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>订餐后台管理系统</title>
    <link rel="stylesheet" href="<%=backPath%>/static/css/materialdesignicons.min.css" />
    <link rel="stylesheet" href="<%=backPath%>/static/css/vendor.bundle.base.css" />
    <link rel="stylesheet" href="<%=backPath%>/static/css/style.css" />
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div
            class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg"
          >
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                <h3 class="card-title text-left mb-3">订餐后台管理系统登录</h3>
                <form action="<%=path%>/staff?type=stafflogin" method="post">
                  <div class="form-group">
                    <label>用户名</label>
                    <input type="text" class="form-control p_input" name="userName"/>
                  </div>
                  <div class="form-group">
                    <label>密码</label>
                    <input type="text" class="form-control p_input" name="userPwd"/>
                  </div>
                  <div
                    class="form-group d-flex align-items-center justify-content-between"
                  >
                    <div class="form-check">
                      <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" />
                        记住我
                      </label>
                    </div>
                  </div>
                  <div class="text-center">
                    <button
                      type="submit"
                      class="btn btn-primary btn-block enter-btn formBtn"
                    >
                      登录
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="<%=backPath %>/static/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="<%=backPath %>/static/js/off-canvas.js"></script>
    <script src="<%=backPath %>/static/js/misc.js"></script>
    <script src="<%=backPath %>/static/js/settings.js"></script>
    <!-- endinject -->
  </body>
</html>
