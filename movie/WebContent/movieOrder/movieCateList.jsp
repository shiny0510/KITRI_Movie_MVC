<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="a" items="${list }" varStatus="status">
<c:if test="${!status.first }">,</c:if>
{"num":${a.num }, "path1":"${a.path1 }","title":"${a.title }","director":"${a.director } }
</c:forEach>
]