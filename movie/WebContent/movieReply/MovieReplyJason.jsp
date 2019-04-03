<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="r" items="${list }" varStatus="status">
	<c:if test="${!status.first }">,</c:if>
	{"num":${r.num }, "writer":"${r.writer }", "parent":${r.parent }, "w_date":"${r.w_date }", "content":"${r.content }" }
</c:forEach>
]