<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="b" items="${list }" varStatus="status">
	<c:if test="${!status.first }">,</c:if>
	{"num":${b.num }, "writer":"${b.writer }", "type":${b.type }", "title":"${b.title}", "content":"${b.content }""path":"${b.path}","w_date":"${b.w_date}", }
</c:forEach>
]