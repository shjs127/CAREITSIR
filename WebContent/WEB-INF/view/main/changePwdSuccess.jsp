<%@ page contentType = "text/html; charset=utf-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<script>
	alert("성공적으로 저장 되었습니다.");
	 location.href="${pageContext.request.contextPath }/login.do";
		/* response.sendRedirect("/WEB-INF/view/login/login.jsp") */
</script>
