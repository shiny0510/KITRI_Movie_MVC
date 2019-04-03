<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList, cate.Cate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="c" items="${list }" varStatus="status">
<c:if test="${!status.first }">,</c:if>
{"num":${c.num }, "name":"${c.name }", "parent":${c.parent }}
</c:forEach>
]