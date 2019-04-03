<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
});
$.a=function(){
	location.href="${pageContext.request.contextPath}/movie/Main.jsp?sub=/screen/false.jsp";
}
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>상영관 정보</h3>
<c:if test="${not empty list}">
<c:forEach var="list" items="${list}" varStatus="status>">
</c:forEach>
</c:if>

<c:if test="${empty list}">
<script>
$.a();
</script>
</table>
</c:if>
</body>
</html>