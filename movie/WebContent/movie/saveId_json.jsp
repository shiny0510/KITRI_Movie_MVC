<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty save}">
{"save":"${save }"}
</c:if>
<c:if test="${empty save}">
{}
</c:if>
