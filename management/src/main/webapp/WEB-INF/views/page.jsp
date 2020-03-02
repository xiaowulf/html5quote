<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function changeCurrentPage(){
		var current_select_page=$('#select_current_page_id').val();
		var url = "<c:out value="${page.pageAction}"/>currentPage="+current_select_page;
		url = url.replace(new RegExp(/(&amp;)/g),"&");
		window.location=url;
	}
</script>

<font style="font-size:13px">第<c:out value="${page.currentPage}"/>页&nbsp;&nbsp;</font>
<a href="<c:out value="${page.pageAction}"/>currentPage=1&pageMethod=first"><font style="font-size:13px">首页</font></a>
<a href="<c:out value="${page.pageAction}"/>currentPage=<c:out value="${page.currentPage}"/>&pageMethod=previous"><font style="font-size:13px">上一页</font></a>
<a href="<c:out value="${page.pageAction}"/>currentPage=<c:out value="${page.currentPage}"/>&pageMethod=next"><font style="font-size:13px">下一页</font></a>
<a href="<c:out value="${page.pageAction}"/>currentPage=<c:out value="${page.totalPages}"/>&pageMethod=last"><font style="font-size:13px">尾页</font></a>
<font style="font-size:13px">共<c:out value="${page.totalPages}"/>页</font>

<select onchange="changeCurrentPage()" id="select_current_page_id">
<c:forEach var="cpage" begin="1" end="${page.totalPages}">
	<c:if test="${cpage eq page.currentPage}">
	<option value="<c:out value="${cpage}"/>" selected>
		<c:out value="${cpage}"/>
	</option>
	</c:if>
	<c:if test="${cpage ne page.currentPage}">
	<option value="<c:out value="${cpage}"/>">
		<c:out value="${cpage}"/>
	</option>
	</c:if>
</c:forEach>
</select><font style="font-size:13px">页</font>