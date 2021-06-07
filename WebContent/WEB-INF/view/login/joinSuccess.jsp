<%@ page contentType = "text/html; charset=utf-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<script>
	alert("성공적으로 회원가입 되었습니다.");
	location.href="${pageContext.request.contextPath }/main/index.do"; 
</script>
