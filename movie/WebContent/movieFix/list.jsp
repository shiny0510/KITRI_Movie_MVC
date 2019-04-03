<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>영화 관리</h1>
<c:if test="${not empty list}">
<table id="listTable">
<c:forEach var="a" items="${list }" varStatus="status">
<c:if test="${status.index%3 == 0}">
<tr>
</c:if>
<td>
<table border="1">
<tr><td><a href="${pageContext.request.contextPath }/
GetMovieController?num=${a.num}&ptype=${sessionScope.type}">
<img src="/img2/movie2/${a.path1 }"style="width:100%;height:60%">
</a></td></tr>
<tr><td>영화명:<a href="${pageContext.request.contextPath }/GetMovieController?num=${a.num}&ptype=${sessionScope.type}">${a.title }</a></td></tr>
<tr><td>감독:${a.director }</td></tr>
</table>
</td>
<c:if test="${status.index%3 == 2}">
</tr>
</c:if>
</c:forEach>
</table>
</c:if>
</body>
</html>