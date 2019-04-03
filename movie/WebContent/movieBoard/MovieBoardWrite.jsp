<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css">
<title>Insert title here</title>
<style>
.btn {
background-color: #87CEEB;
padding: 10px 20px;
margin: 6px;
border: none;
color: black;
text-align: center;
text-decoration: none;
font-size: 20px;
display: inline-block;
cursor: pointer;
-webkit-transition-duration: 0.4s;
transition-duration: 0.4s;
}
.btn1:hover, .btn2:hover {
background-color: #4169E1;
color: white;
}
</style>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#add").click(function(){
		location.href="${pageContext.request.contextPath }/MovieBoardComplete.jsp";
	});
	$("#list").click(function(){
		location.href="${pageContext.request.contextPath }/MovieBoardListController";
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<div id="top">
<h1 align="center">1:1 문의</h1></div>
<div align="right"><input class="btn btn2" type="submit" value="내 문의 목록" id="list">
</div>
<form action="${pageContext.request.contextPath }/MovieBoardWriteController" method="post" enctype="multipart/form-data">
<table style="width:100%" position="">
<tr><th align="left"> 작성자</th><td><input type="text" name="writer" value="${sessionScope.id }" size="100" readonly></td></tr>
<%-- <tr><th>휴대전화</th><td><input type="text" name="tel" value="${sessionScope.tel }" size= readonly></td> --%>
<!-- <tr><td><input type="button" value="수정" size="60" ></td></tr> -->
<tr><th align="left"> 문의유형</th><td><input type="radio" name="type" value="일반문의" checked>일반문의
	<input type="radio" name="type" value="칭찬">칭찬
	<input type="radio" name="type" value="불만">불만
	<input type="radio" name="type" value="제안">제안</td></tr>	
<!-- <tr><th>지점선택<th><td><select name="area"><option value="seoul" selected>서울 -->
<!-- 			<option value="busan">부산 -->
<!-- 			</option></select></td></tr> -->
<tr><th align="left"> 제목</th><td><input type="text" name="title" size="100"></td></tr>
<tr><th align="left"> 내용</th><td><textarea name="content" rows="30" cols="100"></textarea></td></tr>
<tr><th align="left"> 파일첨부</th><td><input type="file" name="file" size="100"></td></tr>
<tr height="100"><td colspan="4">
<input class="btn btn1" type="submit" value="등록" id="add">
</td></tr>
</table>
</form>
</body>
</html>