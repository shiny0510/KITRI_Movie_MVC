<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.sm').mouseover(function(){
		var i = $(this).attr('src');
		$('#bm1').attr('src', i);
	});
	$('#cnt').change(function(){
		var price = parseInt($('#price').html());
		var q = parseInt($(this).val());
		var t = price*q;
		$('#totalPrice').html(t);
	});
});
</script>
</head>
<body>
<h2>티켓 구매 내역</h2>
<c:if test="${not empty list}">
<table id="listTable" align="center" style="width:100%" >
<c:forEach var="a" items="${list }" varStatus="status">
<c:if test="${status.index%3 == 0}">
<tr>
</c:if>
<td>
<table border="1" style="width:100%; text-align:center">
<tr><td>영화제목</td><td>영화관</td><td>상영관</td><td>상영날짜</td><td>상영시간</td><td>좌석</td></tr>
<tr><td>${a.title }</td><td>${a.theater }</td><td>${a.screen }</td><td>${a.mdate }</td><td>${a.mtime}</td><td>${a.seat}</td></tr>
</table>
</td>
</c:forEach>
</table>
</c:if>
</body>
</html>