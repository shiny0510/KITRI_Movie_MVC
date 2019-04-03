<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty m}">
{"id":"${m.id}","pwd":"${m.pwd}","name":"${$m.name}","age":${m.age},"tel":"${m.tel}","address":"${m.address}","type":${m.type},"point":${m.point},"area":"${m.area}"}
</c:if>
<c:if test="${empty m}">
{}
</c:if>
