<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<div id="top1" align="center">
<h1 >임시</h1></div>

<div id="top2" align="right">
<br/>
<!-- ------------------------------------------------------------------------------------ -->
<form action="${pageContext.request.contextPath }/MovieReplyListController" method="post" >
<table style="width:100%">
<tr style="background-color:lightgrey">
<th>글번호</th><th>제목</th><th>작성자</th><th>등록일</th>
</tr>
<c:forEach items="${list }" var="list">
<tr>
<td>${list.num }</td>
<td><a href=${pageContext.request.contextPath }/MovieReplyViewController?num=${list.num } id="num">${list.title }</a></td>
<td id="writer">${list.writer}</td><td id="w_date">${list.w_date }</td>></tr>
</c:forEach>
</table>
</form>
</body>
</html>