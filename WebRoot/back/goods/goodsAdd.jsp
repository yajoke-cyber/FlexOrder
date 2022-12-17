<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath(); 
	String	backPath = path+"/back"; 
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <form  method="post" id="addForm" action="<%=path %>/goods?type=goodsAdd">
                      <div class="form-group">
                        <label >菜品名</label>
                        <input
                        name="name"
                          type="text"
                          class="form-control"
                          id="exampleInputName1"
                          placeholder="名字"
                        />
                      </div>
                      <div class="form-group">
                        <label for="exampleSelectGender">菜品种类</label>
                        <select class="form-control"  id="select" name="catalog_id">
                        <c:forEach items="${res.getObj()}" var="item">
                   			<option value="${item.getId()}">${item.getName()}</option>
						</c:forEach>
                        </select>
                      </div>
                      <div class="form-group">
                       <label for="exampleSelectGender">菜品Id</label>
                      	<input type="number"  class="form-control"  name="showId"> 
                    </div>
                      <div class="form-group">
                       <label for="exampleSelectGender">菜品价格</label>
                      <div class="input-group">
                        <div class="input-group-prepend">
                          <span class="input-group-text bg-primary text-white">￥</span>
                        </div>
                        <input type="number" id="price" class="form-control" aria-label="Amount (to the nearest dollar)" name="marketPrice">
                        <div class="input-group-append">
                          <span class="input-group-text">.00</span>
                        </div>
                      </div>
                    </div>
                     <div class="form-group">
                        <label for="exampleTextarea1">菜品描述</label>
                        <textarea
                          class="form-control"
                          id="exampleTextarea1"
                          rows="4"
                          name="introduction"
                        ></textarea>
                      </div>
                      <div class="form-group">
                        <label>图片上传</label>
                        <input
                          type="file"
                          name="img[]"
                          type="submit"
                          class="file-upload-default"
                        />
                        <div class="input-group col-xs-12">
                          <input
                            type="text"
                            class="form-control file-upload-info"
                            disabled=""
                            placeholder="请上传PNG或者JPG类图片"
                          />
                          <span class="input-group-append">
                            <button
                              class="file-upload-browse btn btn-primary"
                              type="button"
                            >
                              上传
                            </button>
                          </span>
                        </div>
                      </div>
                      <button id='submit' type="submit" class="btn btn-primary mr-2">
                        提交菜品
                      </button>
                     <a href=''><button class="btn btn-dark" >清空表格</button></a>
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
  <script>
  	$('#submit').bind('click',()=>{
  		
  		$("#addForm").submit();
  	})
  </script>
  </body>
</html>
