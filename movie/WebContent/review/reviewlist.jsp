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
<h3>��ȭ ���</h3>

<c:if test="${not empty list}">
<table id="listTable">
<c:forEach var="a" items="${list }" varStatus="status">
<c:if test="${status.index%3 == 0}">
<tr>
</c:if>
<td>
<table border="1">
<tr><td>��ȣ</td><td>���̵�</td><td>����</td><td>����</td><td>��¥</td><td>���̵� �н�����</td></tr>
<tr><td>${a.num }</td><td>${a.id }</td><td>${a.content }</td><td>${a.score }</td><td>${a.rdate}</td><td></td></tr>
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