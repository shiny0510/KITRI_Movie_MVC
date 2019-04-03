<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#back").click(function(){
		location.href="${pageContext.request.contextPath }/locationListController?type=1";
	});
	$("#add").click(function(){
		var cnt=3;
		if($("#area").val()==null||$("#area").val()==""){
			alert("지역을 입력하세요");
			--cnt;
		}
		if($("#x").val()==null||$("#x").val()==""){
			alert("x좌표를 입력하세요");
			--cnt;
		}
		if($("#y").val()==null||$("#y").val()==""){
			alert("y좌표를 입력하세요");
			--cnt;
		}
		if(cnt==3){
			f.submit();
		}
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>영화관 추가</h3>
<form id="f" name="f" action="${pageContext.request.contextPath }/areaAddController" method="post" enctype="multipart/form-data">
<table border="1" style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr><th style="width:40%">지역</th><td><input type="text" border="0" id="area" name="area" placeholder="지역이름" style="width:99%;height:50px" ></td><tr>
<tr style="height:50px"><th style="width:40%">지역파일</th><td><input type="File" border="0" id="file" name="File" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">지점</th><td><input type="text" border="0" id="name" name="name" placeholder="지점이름" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">x좌표</th><td><input type="text" border="0" id="x" name="x" placeholder="x좌표" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">y좌표</th><td><input type="text" border="0" id="y" name="y" placeholder="y좌표" style="width:99%;height:50px"></td></tr>
<tr>
<td><input type="button" id="add" value="영화관 추가" style="background-color:#1E96FF;width:245px;height:50px"></td>
<td><input type="button" id="back" value="돌아가기" style="background-color:#1E96FF;width:245px;height:50px"></td>
</tr>
</table>
</body>
</html>