<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String path = request.getContextPath(); String
backPath = path+"/back"; %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>
  <body>
    <nav class="navbar p-0 fixed-top d-flex flex-row">
      <div
        class="navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center"
      >
        <a class="navbar-brand brand-logo-mini" href="<%=backPath%>/index.jsp"
          ><img src="<%=backPath%>/static/picture/logo-mini.svg" alt="logo"
        /></a>
      </div>
      <div class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
        <button
          class="navbar-toggler navbar-toggler align-self-center"
          type="button"
          data-toggle="minimize"
        >
          <span class="mdi mdi-menu"></span>
        </button>
        <ul class="navbar-nav w-100">
          <li class="nav-item w-100">
            <form class="nav-link mt-2 mt-md-0 d-none d-lg-flex search">
              <input
                type="text"
                class="form-control"
                placeholder="Search products"
              />
            </form>
          </li>
        </ul>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown d-none d-lg-block">
            <a
              class="nav-link btn btn-success create-new-button"
              id="createbuttonDropdown"
              data-toggle="dropdown"
              aria-expanded="false"
              href="#"
              >+ 添加新项目</a
            >
            <div
              class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
              aria-labelledby="createbuttonDropdown"
            >
              <h6 class="p-3 mb-0">新增</h6>
              <div class="dropdown-divider"></div>
              <a
                class="dropdown-item preview-item"
                href="<%=path%>/goods?type=goodsAddPage"
              >
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-dark rounded-circle">
                    <i class="mdi mdi-file-outline text-primary"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject ellipsis mb-1">菜品信息</p>
                </div>
              </a>
              <div class="dropdown-divider"></div>
              <a
                class="dropdown-item preview-item"
                href="<%=backPath%>/catalog/cataAdd.jsp"
              >
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-dark rounded-circle">
                    <i class="mdi mdi-web text-info"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject ellipsis mb-1">菜品种类</p>
                </div>
              </a>
              <div class="dropdown-divider"></div>
              <a
                class="dropdown-item preview-item"
                href="<%=backPath%>/staff/staffAdd.jsp"
              >
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-dark rounded-circle">
                    <i class="mdi mdi-layers text-danger"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject ellipsis mb-1">新员工</p>
                </div>
              </a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link"
              id="profileDropdown"
              href="#"
              data-toggle="dropdown"
            >
              <div class="navbar-profile">
                <p class="mb-0 d-none d-sm-block navbar-profile-name">
                  ${staff.getUserName()}&nbsp;&nbsp;${staff.getLevel()}
                </p>
                <i class="mdi mdi-menu-down d-none d-sm-block"></i>
              </div>
            </a>
            <div
              class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
              aria-labelledby="profileDropdown"
            >
              <h6 class="p-3 mb-0">个人</h6>
              <div class="dropdown-divider"></div>
              <a
                class="dropdown-item preview-item"
                href="<%=path%>/staff?type=staffEditPwdPage"
              >
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-dark rounded-circle">
                    <i class="mdi mdi-onepassword text-info"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject mb-1">修改密码</p>
                </div>
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item preview-item" href="<%=path %>/staff?type=staffLogout">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-dark rounded-circle">
                    <i class="mdi mdi-logout text-danger"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject mb-1">登出</p>
                </div>
              </a>
            </div>
          </li>
        </ul>
        <button
          class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
          type="button"
          data-toggle="offcanvas"
        >
          <span class="mdi mdi-format-line-spacing"></span>
        </button>
      </div>
    </nav>
  </body>
</html>
