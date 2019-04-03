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
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/time/menu.jsp";
	});
	
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/sortListController",
		success:function(data){
			var arr=eval("("+data+")");
			var str="<select name=sort style=width:80%;height:40px;font-size:20px>";
			str+="<option value=0>선택</option>";
			for(i=0; i<arr.length; i++){
				str+="<option value="+arr[i].sort+">"+arr[i].sort+"</option>";
			}
			str+="</select>";
			$("#sortTd").html(str);
		}
	});
	
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/MovieListController",
		success:function(data){
			var arr=eval("("+data+")");
			var str="<select name=movie style=width:80%;height:40px;font-size:20px>";
			str+="<option value=0>선택</option>";
			for(i=0; i<arr.length; i++){
				str+="<option value="+arr[i].title+">"+arr[i].title+"</option>";
			}
			str+="</select>";
			$("#movieTd").html(str);
		}
	});
	var value=$("#parent").val();
	var param="parent="+value;
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/screenListController",
		data:param,
		success:function(data){
			var arr=eval("("+data+")");
			var str="<select name=screen style=width:80%;height:40px;font-size:20px>";
			str+="<option value=0>선택</option>";
			for(i=0; i<arr.length; i++){
				str+="<option value="+arr[i].num+">"+arr[i].num+"</option>";
			}
			str+="</select>";
			$("#screenTd").html(str);
		}
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>상영시간표 수정</h3>
<form id="f" name="f" action="${pageContext.request.contextPath}/timeAddController" method="post">
<table border="1" style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr style="height:50px"><th style="width:40%">지역</th><td><input type="text" border="0" value='${a.area}' style="width:99%;height:50px;text-align:center" readonly></td></td></tr>
<tr style="height:50px"><th style="width:40%">지점</th><td><input type="text" border="0" id="parent" name="area" value='${a.name}' style="width:99%;height:50px;text-align:center" readonly></td></tr>
<!-- <tr style="height:50px"><th style="width:40%">상영관 번호</th><td id="screenTd"></td></tr> -->
<!-- <tr style="height:50px"><th style="width:40%">영화 제목</th><td id="movieTd"></td></tr> -->
<!-- <tr style="height:50px"><th style="width:40%">영화 종류</th><td id="sortTd"></td></tr> -->
<tr style="height:50px"><th style="width:40%">영화 상영날짜</th><td><input type="text" border="0" name="day" placeholder="날짜를 입력해주세요 ex)20181026" style="width:99%;height:50px;text-align:center"></td></tr>
<tr style="height:50px"><th style="width:40%">영화 상영시간</th><td><input type="text" border="0" name="hour" placeholder="시간을 입력해주세요 ex)20:30" style="width:99%;height:50px;text-align:center"></td></tr>
<tr>
<td colspan="2">
<input type="submit" value="상영 시간 수정" style="background-color:#1E96FF;width:157px;height:50px">
<input type="button" id="back" value="돌아가기" style="background-color:#1E96FF;width:157px;height:50px"></td>
</tr>
</table>
</form>
</body>
</html>