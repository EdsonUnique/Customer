<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.Edson.com" prefix="e" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有用户</title>
  </head>
  
  <body style="text-align: center;">
    <c:choose>
    	<c:when test="${!empty(page.list) }">
    		<table width="100%" frame="border" border="1">
    			<tr>
    				<td>编号</td>
    				<td>用户名</td>
    				<td>性别</td>
    				<td>生日</td>
    				<td>手机号码</td>
    				<td>邮箱</td>
    				<td>爱好</td>
    				<td>客户类型</td>
    				<td>描述</td>
    				<td>密码</td>
    				<td>用户操作</td>
    			</tr>
    			
    			<c:forEach items="${page.list }" var="entry">
    			
    				<tr>
	    				<td>${entry.id }</td>
	    				<td>${entry.name}</td>
	    				<td>${entry.gender}</td>
	    				<td>${entry.birthday }</td>
	    				<td>${entry.cellphone}</td>
	    				<td>${entry.email }</td>
	    				<td>${e:substringFn(entry.preferences,10) }</td>
	    				<td>${entry.types }</td>
	    				<td>${e:substringFn(entry.description,10) }</td>
	    				<td>${entry.password }</td>
	    				<td>
	    					<a href="${pageContext.request.contextPath }/servlet/UpdateUIServlet?id=${entry.id }">修改</a>
	    					<a href="${pageContext.request.contextPath }/servlet/ControllerDelete?id=${entry.id }">删除</a>
	    				</td>
    				</tr>
    			</c:forEach>
    		
    		
    		
    		</table>
    		<br/><br/>
			<%@include file="/public_jsp/Frameset.jsp" %>
    	</c:when>
    	<c:otherwise>
    		对不起，暂未录入任何用户信息！！
    	</c:otherwise>
    
    
    
    
    
    
    
    
    
    
    
    
    </c:choose>
  </body>
</html>
