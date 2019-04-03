<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	$("#list").click(function(){
		location.href="${pageContext.request.contextPath }/MovieBoardListController";
	});
	$("#main").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp";
	});
});
</script>
</head>

<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<div id="top1" align="center">
<h1>1:1 문의가 등록되었습니다.</h1>
</div>
<div align="center">    
<td colspan="10" width="399">
<input class="btn btn1" type=button value="목록으로" id="list">
<input class="btn btn2" type=button value="메인으로" id="main">
</td>
</div>
</body>
</html>