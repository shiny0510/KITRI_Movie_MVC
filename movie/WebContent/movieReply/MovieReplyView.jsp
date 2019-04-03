<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title> 1:1 문의 답변보기</title>
<style>
.btn {
background-color: #87CEEB;
padding: 10px 20px;
margin: 2px;
border: none;
color: black;
text-align: center;
text-decoration: none;
font-size: 16px;
display: inline-block;
cursor: pointer;
-webkit-transition-duration: 0.4s;
transition-duration: 0.4s;
}
.btn1:hover{
background-color: #4169E1;
color: white;
}
</style>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#list").click(function(){
		location.href="${pageContext.request.contextPath }/MovieBoardListController";
	});
});

</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<c:if test="${sessionScope.id }"></c:if>
<form action="${pageContext.request.contextPath }/MovieReplyListController" method="post" >
<table style="width:100%">
<c:forEach items="${list }" var="list">
<c:if test="${not empty r}">
<tr>
<td width="10">글번호</td><td width="20" id="td1" parent="${list.parent }">${list.num }</td>  
<td align="center" width="500">&nbsp;</td>
<td width="70">작성일</td><td width="100">${list.w_date }</td>
</tr>
<tr height="1" bgcolor="#dddddd"><td colspan="10" width="100%"></td></tr>
<tr><td align="center" width="70">제목</td><td width="500">${list.title }</td></tr>
<tr height="1" bgcolor="#dddddd"><td colspan="10" width="100%"></td></tr>
<tr>
<td width="70">내용</td><td width="100" height="500">${list.content }</td>
</tr>

<tr align="center">
<td colspan="10" width="399">
<input class="btn btn1" type=button value="목록으로" id="list">
</tr>
</c:if>
</td>
</tr>
</table>
</c:forEach>
</form>
</body>
</html>