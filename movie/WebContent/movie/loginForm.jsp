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
var cnt=1;
$(document).ready(function(){
	$("#check").click(function() {	
			if(cnt%2==1){
		  	$( "#check" ).prop( "checked", true );
		  	var save=$("#id").val();
		  	var param="save="+save;
			$.ajax({
				type:"Post",
				url:"${pageContext.request.contextPath}/idSaveController",
				data:param,
				success:function(data){
				}
			});
		  	
			}else{
			$( "#check" ).prop( "checked", false );
			var save="";
		  	var param="save=1";
			$.ajax({
				type:"Post",
				url:"${pageContext.request.contextPath}/idSaveController",
				data:param,
				success:function(data){
				}
			});
		  	
			}cnt=cnt+1;
			
	});
	$("#join").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=JoinForm.jsp";
	});
	$("#backHome").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=mainDown.jsp";
	});
	$("#searchId").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=searchId.jsp";
	});
	$("#searchPwd").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=searchPwd.jsp";
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h1>로그인</h1>
<form name="f" action="${pageContext.request.contextPath }/loginMemberController" method="post">

<table  style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr><td>
<table border="1" style="margin:auto">
<tr style="height:50px">
<c:if test="${not empty sessionScope.save }">
<td><input type="text" id="id" name="id" placeholder="아이디" style="height:50px" value="${sessionScope.save}"></td>
</c:if>
<c:if test="${empty sessionScope.save }">
<td><input type="text" id="id" name="id" placeholder="아이디" style="height:50px"></td>
</c:if>
<td rowspan="3"><input type="submit" value="로그인" style="background-color:#1E96FF;height:150px">
</tr>
<tr style="height:50px">
<td><input type="password" name="pwd" placeholder="비밀번호" style="height:50px"></td>
</tr>
<tr>
<td><input type="radio" id="check" value="1" style="text-aling:left">id저장</td>
</tr>
</table>
</td></tr>

<tr><td>
<table style="margin:auto">
<tr>
<td><input type="button" id="join" value="회원가입" style="background-color:#1E96FF;width:120px"></td>
<td><input type="button" id="backHome" value="돌아가기" style="background-color:#1E96FF;width:120px"></td>
</tr>
<tr>
<td><input type="button" id="searchId" value="id찾기" style="background-color:#1E96FF;width:120px"></td>
<td><input type="button" id="searchPwd" value="pwd찾기" style="background-color:#1E96FF;width:120px"></td>
</tr>
</table>

</td></tr>
</table>

</form>
</body>
</html>