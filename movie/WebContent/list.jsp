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
<h3>���� ����� ��ȭ��</h3>
<c:if test="${not empty list}">
<table border="1">
<tr><th>�̹���</th><th>��ȭ��</th><th>Ƽ�ϰ���</th></tr>
<c:forEach var="a" items="${list }">
<tr>
<td><img src="/img/movie/${a.path1 }" style="width:100px;height:100px"></td>
<td><a href="${pageContext.request.contextPath }/
GetMovieController?num=${a.num}&ptype=1">${a.title }</a></td>
<td>${a.director }</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>