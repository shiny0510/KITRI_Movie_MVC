<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>나의 1:1 문의</title>
<style>
.btn {
background-color: #87CEEB;
padding: 15px 30px;
margin: 2px;
border: none;
color: black;
text-align: center;
text-decoration: none;
font-size: 16px;
display: inline-block;
cursor: pointer;
-webkit-transition-duration: 0.4s;
transition-duration: 0.4s;
}
.btnn {
background-color: #87CEEB;
padding: 8px 12px;
margin: 2px;
border: none;
color: black;
text-align: center;
text-decoration: none;
font-size: 16px;
display: inline-block;
cursor: pointer;
-webkit-transition-duration: 0.4s;
transition-duration: 0.4s;
}
.btn1:hover, .btn1:hover {
background-color: #4169E1;
color: white;
}
</style>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#write").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/movieBoard/MovieBoardWrite.jsp";
	});
});
	
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<div id="top1" align="center">
<h1 >${sessionScope.id }님의 1:1 문의 내역</h1></div>
<div id="top2" align="right">
<c:if test="${not empty sessionScope.id }">
<input class="btn btn1" type="button" value="문의하기" id="write"></c:if></div>
<br/>

<form action="${pageContext.request.contextPath }/MovieBoardListController" method="post" >
<table style="width:100%">
<tr style="background-color:lightgrey">
<th>글번호</th><th>제목</th><th>작성자</th><th>등록일</th>
</tr>

<c:forEach items="${list }" var="list">
<tr>
<td>${list.num }</td>
<td><a href=${pageContext.request.contextPath }/MovieBoardViewController?num=${list.num } id="num">${list.title }</a></td>
<td id="writer">${list.writer}</td><td id="w_date">${list.w_date }</td></tr>

<c:forEach items="${list1 }" var="list1">
<c:if test="${list.num == list1.rep_num   }">
<tr><td>${list1.num}</td><td><a href=${pageContext.request.contextPath }/MovieBoardViewController?num=${list1.num } id="num1">ㄴRE : ${list.title }</a></td><td>${list1.writer}</td><td>${list1.w_date}</td></tr>
</c:if>
</c:forEach>
</c:forEach>
</table>
</form>
</body>
</html>

