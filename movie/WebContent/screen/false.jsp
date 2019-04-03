<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#back").click(function(){
		location.href="${pageContext.request.contextPath }/locationListController?type=1";
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>오류 페이지</h3>
<table border="1" style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr style="height:200px">
<td style="text-align:center;font-size:20px">상영관 정보가 없습니다. <br/>상영관을 확인해주세요.</td></tr>
<tr>
<td><input type="button" id="back" value="돌아가기" style="width:100%;height:100%;font-size:20px"></td></tr>
</table>
</body>
</html>