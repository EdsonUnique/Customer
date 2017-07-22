<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改页面</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/date.js"></script>
  </head>
  
  <body onload="date()"  style="text-align: center;">
     <form  action="${pageContext.request.contextPath}/servlet/ControllerUpdate?id=${customer.id}" method="post" id="form" onsubmit="getDataString()">
		   	 <table width="50%" border="1">
		   
		   	 	<tr>
					<td>用户名</td>
					<td>
						<input type="text" name="name" value="${customer.name }">
					</td>   	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>密码</td>
					<td>
						<input type="password" name="password">
					</td>     	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>性别</td>
					<td>
						<input type="radio" name="gender" value="男" ${customer.gender=="男"?"checked":'' }>男
						<input type="radio" name="gender" value="女" ${customer.gender=="女"?"checked":'' }>女
					</td>    	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>生日</td>
					<td>
						<select id="year">
							<option value="${fn:split(customer.birthday,'-')[0]}">${fn:split(customer.birthday,'-')[0]}</option>
						</select>年
						
						<select id="month">
							<option value="${fn:split(customer.birthday,'-')[1]}" >${fn:split(customer.birthday,'-')[1]}</option>
						</select>月
						
						<select id="day">
							<option value="${fn:split(customer.birthday,'-')[2]}" >${fn:split(customer.birthday,'-')[2]}</option>
						</select>日
						
					</td>   	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>手机号码</td>
					<td>
						<input type="text" name="cellphone" value="${customer.cellphone }"/>
					</td>   	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>邮箱</td>
					<td>
						<input type="text" name="email" value="${customer.email}"/>
					</td>     	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>爱好</td>
					<td>
						<c:forEach var="prefer" items="${preferences }">
							<input type="checkbox" name="pre" value="${prefer }" ${fn:contains(customer.preferences,prefer)?"checked":'' }>${prefer }
						</c:forEach>
					</td>   	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>客户类型</td>
					<td>
						<c:forEach var="type" items="${types }">
							<input type="radio" name="types" value="${type }" ${fn:contains(customer.types,type)?"checked":'' }>${type }
						</c:forEach>
					</td>   	 	
		   	 	</tr>
		   	 	
		   	 	<tr>
					<td>描述</td>
					<td>
						<textarea rows="4" cols="50" name="description">${customer.description }</textarea>
					</td>   	 	
		   	 	</tr>
		    	
		    	<tr>
					<td align="center" colspan="2">
						<input type="reset" >
						<input type="submit" value="提交">
					</td>   	 	
		   	 	</tr>
		    	
		    
		    
		    
		    
		   	 </table>
		    
		   
   
  		 </form>  	
  	
  </body>
</html>
