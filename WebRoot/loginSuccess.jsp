<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
       <script type="text/javascript">   
           setTimeout(()=>{
        	   window.location.href="<%=path %>/admin/index.jsp"; //把url改变为<%=path %>/admin/index.jsp
           },1300)
       </script>
       <center><img src="<%=path %>/images/loading.gif"></center> 
  </body>
</html>
