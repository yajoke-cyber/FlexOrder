<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String path = request.getContextPath(); String
backPath = path+"/back"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script src="<%=backPath%>/static/js/vendor.bundle.base.js"></script>
    <script src="<%=backPath%>/static/js/Chart.min.js"></script>
    <script src="<%=backPath%>/static/js/progressbar.min.js"></script>
    <script src="<%=backPath%>/static/js/jquery-jvectormap.min.js"></script>
    <script src="<%=backPath%>/static/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="<%=backPath%>/static/js/owl.carousel.min.js"></script>
    <script src="<%=backPath%>/static/js/off-canvas.js"></script>
    <script src="<%=backPath%>/static/js/hoverable-collapse.js"></script>
    <script src="<%=backPath%>/static/js/misc.js"></script>
    <script src="<%=backPath%>/static/js/settings.js"></script>
    <script src="<%=backPath%>/static/js/todolist.js"></script>
    <script src="<%=backPath%>/static/js/dashboard.js"></script>
    <script>
    <c:if test="${staff == null}">
		alert("请登录"); //如果 message不为空，弹出message信息
		document.location.href = "<%=path%>/back/login/login.jsp";
	</c:if>
    </script>
</body>
</html>