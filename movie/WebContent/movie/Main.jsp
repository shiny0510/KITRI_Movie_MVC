<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".td2").mouseover(function(){
		$(this).attr("style","background-color:yellow");
	});
	$(".td2").mouseout(function(){
		$(this).attr("style","background-color:white");
	});
	$(".td2").click(function(){
		var value=$(this).attr("value");
		var html="";
		switch(value){
				case "1":
					location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/order/menu.jsp";
					break;
				case "2":
					location.href="${pageContext.request.contextPath }/MovieAllListController?ptype=${sessionScope.type}";
					break;
				case "3":
					location.href="${pageContext.request.contextPath }/locationListController?type=1";
					break;
				case "4":
					location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/time/menu.jsp";
					break;
				case "5":
					location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/movieBoard/MovieBoardWrite.jsp";
					break;
				case "6":
					location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=loginForm.jsp";
					break;
		}
	});
	$("#logout").click(function(){
		location.href="${pageContext.request.contextPath }/logoutMemberController";
	});
	
	$("#imgButton").click(function(){
		win=window.open("${pageContext.request.contextPath }/movie/subPage.jsp","details","width=450,height=120, top=200, left=200");
	});
});
</script>
</head>
<body>
<table class=table1><tr>
<td class="td1" border="0" style="text-align:left"><img src="${pageContext.request.contextPath }/img/cinema.png" class=img "></td>
<td class=td2 style="" value="1">예매하기</td>
<td class=td2 style="" value="2">영화</td>
<td class=td2 style="" value="3">영화관</td>
<td class=td2 style="" value="4">상영시간표</td>
<td class=td2 style="" value="5">게시판</td>
<c:if test="${empty sessionScope.id}">
<td class=td2 style="" value="6">로그인</td>
</c:if>
<c:if test="${not empty sessionScope.id}">
<td style="width:100px">
<table>
<tr><td colspan="2" >${sessionScope.id }님 환영합니다.</td>
<c:if test="${sessionScope.type==2}">
<tr><td colspan="2">${sessionScope.area}지점</td><tr>
</c:if>
<tr>
<tr>
<td><input type="image" id="imgButton" style="position:relative;top:2px;width:70px;height:25px;" src="${pageContext.request.contextPath }/img/1.png"></td>
<td><input type="button" id="logout" value="logout" style="width:70px;height:30px"></td>
</tr>
</table>
</td>
</c:if>
</tr></table>
<table class=table1><tr><td>
<c:set var="sub" value="${param.sub }"/>
<c:if test="${sub==null }">
<jsp:include page="mainDown.jsp" ></jsp:include>
</c:if>

<c:if test="${sub!=null && sub!='' }">
<jsp:include page="${sub }"></jsp:include>
</c:if>
</td></tr></table>
</body>
</html>