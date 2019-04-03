<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="list" items="${list}" varStatus="status">
<c:if test="${!status.first}">,</c:if>
{"name":"${list.name }","area":"${list.area }","x":${list.x },"y":${list.y }}
</c:forEach>
]
