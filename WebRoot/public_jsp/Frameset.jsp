<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
当前页码：[${page.pagenum }]&nbsp;&nbsp;
    		<c:if test="${page.pagenum >1}">
    			<a href="${page.url}?pagenum=${page.pagenum-1}">上一页</a>
    		</c:if>
    		<c:forEach  var="pagenum" begin="${page.startPage }" end="${page.endPage }" >
    				[<a href="${page.url}?pagenum=${pagenum}">${pagenum}</a>]	
    		</c:forEach>
    		<c:if test="${page.pagenum <page.totalpage}">
	    		&nbsp;&nbsp;
	    	    <a href="${page.url}?pagenum=${page.pagenum+1}">下一页</a>	
    		</c:if>
    		&nbsp;&nbsp;
    		共[${page.pagerecord }]条记录  &nbsp;&nbsp;共[${page.totalpage }]页
    		跳转到<input type="text" id="choosePage" style="width:30px;"/>页 <input type="button" value="GO"  onclick="goPage()">
    		<script type="text/javascript">
    			
   				function goPage(){

					var page=document.getElementById("choosePage").value;
					if(page!=null &&(page>0 && page<=${page.totalpage})){
						window.location.href="${page.url}?pagenum="+page;
					}else{
						alert("请输入正确页码");
						document.getElementById("choosePage").value=null;
					}
				
    			
    			}
    		
    		
    		</script>