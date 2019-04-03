<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>나의 1:1 문의</title>
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
.btn1:hover, .btn2:hover, .btn3:hover, .btn3:hover {
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
	$("#delete").click(function(){
		location.href="${pageContext.request.contextPath }/MovieBoardDelController";
	});
	$("#reply").click(function(){
// 		location.href="${pageContext.request.contextPath }/MovieReplyWriteController";
		var parent=$("#td1").attr("parent");
		//alert(parent);
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/movieReply/MovieReplyWrite.jsp?parent="+parent;
	});
});

</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<c:if test="${sessionScope.id }"></c:if>
<table style="width:100%">
<tr>
<td>
<table>
<c:if test="${not empty b}">
<tr>
<td width="10">글번호</td><td width="20" id="td1" parent="${b.num }">${b.num }</td>  
<td align="center" width="500">&nbsp;</td>
<td width="70">작성일</td><td width="100">${b.w_date }</td>
</tr>
<tr height="1" bgcolor="#dddddd"><td colspan="10" width="100%"></td></tr>
<tr><td align="center" width="70">제목</td><td width="500">${b.title }</td></tr>
<tr height="1" bgcolor="#dddddd"><td colspan="10" width="100%"></td></tr>
<tr>
<td width="70">내용</td><td width="100" height="500">${b.content }</td>
</tr>
</c:if>
<c:if test="${not empty b}">
<tr align="center">
<td colspan="10" width="399">
<input class="btn btn1" type=button value="목록으로" id="list">
<input class="btn btn2" type=button value="수정" id="edit">
<a href=${pageContext.request.contextPath }/MovieBoardDelController?num=${b.num }><input class="btn btn3" type=button value="삭제" id="delete"></a>
<input class="btn btn4" type=button value="답변하기" id="reply">${param.parent}
</tr>
</c:if>
</table>
</body>
</html>