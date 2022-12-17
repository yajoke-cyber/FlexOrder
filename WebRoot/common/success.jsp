<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getAttribute("path").toString();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<html>
<script language="javascript"> 

    <c:if test="${res.getMsg() != null}">
		alert("${res.getMsg()}"); //如果 message不为空，弹出message信息
	</c:if>
	<c:if test="${path != null}">
		window.location.href = "<%=path%>"; //如果路径不为空，跳转到取得的path路径
	</c:if>
	<c:if test="${path == null}">
		window.history.back(); //否则返回历史记录中上一界面
	</c:if>
</script>
<body> 
</body> 
</html>
