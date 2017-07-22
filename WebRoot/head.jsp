<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>head</title>

  </head>
  
  <body style="text-align: center;">
  	<h1>客户管理网站</h1>
    <a href="${pageContext.request.contextPath }/servlet/CustomerRegisterServlet" target="body">注册用户</a>
    <a href="${pageContext.request.contextPath }/servlet/ViewCustomerServlet" target="body">查看用户</a>
  </body>
</html>
