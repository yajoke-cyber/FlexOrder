<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String path = request.getContextPath(); String
backPath = path+"/back"; %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>
  <body>
    <nav class="sidebar sidebar-offcanvas" id="sidebar">
      <div
        class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top"
      >
        <a class="sidebar-brand brand-logo" href="<%=backPath%>/index.jsp"
          ><img src="<%=backPath%>/static/picture/logo.svg" alt="logo"
        /></a>
        <a class="sidebar-brand brand-logo-mini" href=""
          ><img src="<%=backPath%>/static/picture/logo-mini.svg" alt="logo"
        /></a>
      </div>
      <ul class="nav">
        <li class="nav-item nav-category">
          <span class="nav-link">导航</span>
        </li>
        <li class="nav-item menu-items">
          <a class="nav-link" href="<%=backPath%>/index.jsp">
            <span class="menu-icon">
              <i class="mdi mdi-speedometer"></i>
            </span>
            <span class="menu-title">首页</span>
          </a>
        </li>
        <li class="nav-item menu-items">
          <a
            class="nav-link"
            data-toggle="collapse"
            href="#goodsCata"
            aria-expanded="false"
            aria-controls="goodsCata"
          >
            <span class="menu-icon">
              <i class="mdi mdi-laptop"></i>
            </span>
            <span class="menu-title">菜品种类管理</span>
            <i class="menu-arrow"></i>
          </a>
          <div class="collapse" id="goodsCata">
            <ul class="nav flex-column sub-menu">
              <li class="nav-item">
                <a class="nav-link" href="<%=path%>/catalog?type=catalogMana"
                  >菜品种类管理</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=backPath%>/catalog/cataAdd.jsp"
                  >菜品种类添加</a
                >
              </li>
            </ul>
          </div>
        </li>
        <li class="nav-item menu-items">
          <a
            class="nav-link"
            data-toggle="collapse"
            href="#goodsInfo"
            aria-expanded="false"
            aria-controls="goodsInfo"
          >
            <span class="menu-icon">
              <i class="mdi mdi-laptop"></i>
            </span>
            <span class="menu-title">菜品信息管理</span>
            <i class="menu-arrow"></i>
          </a>
          <div class="collapse" id="goodsInfo">
            <ul class="nav flex-column sub-menu">
              <li class="nav-item">
                <a class="nav-link" href="<%=path%>/goods?type=goodsMana"
                  >菜品信息管理</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=path%>/goods?type=goodsAddPage"
                  >菜品信息添加</a
                >
              </li>
            </ul>
          </div>
        </li>
        <li class="nav-item menu-items">
          <a
            class="nav-link"
            data-toggle="collapse"
            href="#staffInfo"
            aria-expanded="false"
            aria-controls="staffInfo"
          >
            <span class="menu-icon">
              <i class="mdi mdi-laptop"></i>
            </span>
            <span class="menu-title">员工信息管理</span>
            <i class="menu-arrow"></i>
          </a>
          <div class="collapse" id="staffInfo">
            <ul class="nav flex-column sub-menu">
              <li class="nav-item">
                <a class="nav-link" href="<%=path%>/staff?type=staffMana"
                  >员工信息管理</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=backPath%>/staff/staffAdd.jsp"
                  >员工信息添加</a
                >
              </li>
            </ul>
          </div>
        </li>

        <li class="nav-item menu-items">
          <a class="nav-link" href="<%=path%>/order?type=orderMana">
            <span class="menu-icon">
              <i class="mdi mdi-table-large"></i>
            </span>
            <span class="menu-title">订单信息管理</span>
          </a>
        </li>
        <li class="nav-item menu-items">
          <a class="nav-link" href="<%=path%>/leaveMsg?type=leaveMsgBackPage">
            <span class="menu-icon">
              <i class="mdi mdi-file-document-box"></i>
            </span>
            <span class="menu-title">留言信息管理</span>
          </a>
        </li>
      </ul>
    </nav>
  </body>
</html>
