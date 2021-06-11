  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
* {
	margin: 4px 0;
}
.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
}
#wriTitle {
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	padding-top: 10px;
	padding-bottom: 10px;
	color: white;
}
table {
	width: 840px;
	margin: 25px 0;
	padding: 20px;
	border-collapse: collapse;
}
#category {
	width: 100px;
	height: 30px;
}
#title {
	width: 693px;
}
textarea {
	width: 800px;
	height: 400px;
}
.button {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: rgb(150, 60, 60);
	color: white;
}
button {
	padding: 5px 12px;
	background-color: white;
	border-color: rgb(180, 180, 180);
	border-width: 1px;
}
textarea {
	resize: none;
}
</style>
</head>
<%@ include file="../include/header.jspf"%>
<body>

	<div class="controller">
		<div id="wriTitle">
			<b>게시글 작성</b>
		</div>
		<form action="write.do" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boardTitle" required id="title" />
					</td>
				</tr>
				<tr>
					<td style="padding-top:20px;" colspan="2"><textarea rows="12" cols="50"
							name="boardContents"></textarea></td>
				</tr>
				<tr>
					<td align="left"><input type="submit" value="작성"
						class="button"></td>
					<td style="padding-right:40px;" align="right"><input type="reset" value="내용 초기화"
						class="button"></td>
				</tr>
			</table>
		</form>
		<div>
			<a href="board.do">
				<button>게시판</button>
			</a>
		</div>
		<div>
			<a href="home.do">
				<button>홈으로</button>
			</a>
		</div>
	</div>
</body>
<%@ include file="../include/footer.jspf"%>
</html>