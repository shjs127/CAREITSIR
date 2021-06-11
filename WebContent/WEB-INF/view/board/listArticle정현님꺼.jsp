<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jspf"%>




<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			회원제 게시판 <small>it all starts here</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Examples</a></li>
			<li class="active">Blank page</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">목록</h3>

				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse" data-toggle="tooltip" title="Collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button type="button" class="btn btn-box-tool" data-widget="remove"
						data-toggle="tooltip" title="Remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<div class="box-body">




				<table border="1">
					<tr>
						<td colspan="4"><a href="write.do">[게시글쓰기]</a></td>
					</tr>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>조회수</td>
					</tr>
					<c:if test="${articlePage.hasNoArticles()}">
						<tr>
							<td colspan="4">게시글이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="article" items="${articlePage.list}">
						<tr>
							<td>${article.boardNo}</td>
							<td><a
								href="read.do?no=${article.boardNo}&pageNo=${articlePage.currentPage}">
									<c:out value="${article.boardTitle}" />
							</a></td>
						<%--	<td>${article.writer.name}</td> --%><td>작성자이름</td>
						-	<td>${article.viewCount}</td> 
						</tr>
					</c:forEach>
					<c:if test="${article.hasArticles()}">
						<tr>
							<td colspan="4"><c:if test="${articlePage.startPage > 5}">
									<a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
								</c:if> <c:forEach var="pNo" begin="${articlePage.startPage}"
									end="${articlePage.endPage}">
									<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
								</c:forEach> <c:if test="${articlePage.endPage < articlePage.totalPages}">
									<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
								</c:if></td>
						</tr>
					</c:if>
				</table>

			</div>
			<!-- /.box-body -->
			<!-- /.box-footer-->
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->



<%@ include file="../include/footer.jspf"%>