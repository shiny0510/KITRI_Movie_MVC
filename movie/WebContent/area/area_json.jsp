<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty a}">
{"x":${a.x},"y":${a.y},"name":"${a.name}","area":"${a.area}"}
</c:if>

