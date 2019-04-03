<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty id}">
{"id":"${id }"}
</c:if>
<c:if test="${empty id}">
{}
</c:if>
