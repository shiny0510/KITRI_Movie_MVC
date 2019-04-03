<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var op1 ="", op2="", op3="";
$.getSelectList=function(param, spanId, selId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath }/CateListController",
		data:param,
		success:function(data){
			var arr = eval("("+data+")");
			var str = "<select id="+selId+" name="+selId+">";
			for(i=0;i<arr.length;i++){
				str += "<option value="+arr[i].num+">"
				+arr[i].name+"</option>";
			}
			str += "</select>";
			$(spanId).html(str);
			$('#'+selId).on("change", function(){				
				var op = $(this).val();
				if(selId=="cate1"){
					op1 = op;
					op2="";
					op3="";
					$('#sel3').html('');
					$.b();
				}else if(selId=="cate2"){
					op2=op;
					op3="";
					$.c();
				}else if(selId=="cate3"){
					op3=op;
					alert(op1+"/"+op2+"/"+op3);
				}
			});
		}
	});
}
$.a=function(){
	var param = "parent=0&table=cate1";
	$.getSelectList(param, "#sel1", "cate1");
}
$.b=function(){
	var param = "parent="+op1+"&table=cate2";
	$.getSelectList(param, "#sel2", "cate2");
}
$.c=function(){
	var param = "parent="+op2+"&table=cate3";
	$.getSelectList(param, "#sel3", "cate3");
}

$(document).ready(function(){
	$.a();
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h1>영화 목록 등록</h1>
<form action="${pageContext.request.contextPath }/MovieAddController1" 
method="post" enctype="multipart/form-data">
<table border="1" align="center">
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>스크린샷1</th><td><input type="file" name="path1"></td></tr>
<tr><th>스크린샷2</th><td><input type="file" name="path2"></td></tr>
<tr><th>스크린샷3</th><td><input type="file" name="path3"></td></tr>
<tr><th>스크린샷4</th><td><input type="file" name="path4"></td></tr>
<tr><th>장르(대분류)</th><td id="sel1"></td></tr>
<tr><th>장르(중분류)</th><td id="sel2"></td></tr>
<tr><th>장르(소분류)</th><td id="sel3"></td></tr>
<tr><th>상영시간(분)</th><td><input type="text" name="runtime"></td></tr>
<tr><th>영화 제작 감독</th><td><input type="text" name="director"></td></tr>
<tr><th>출연진</th><td><input type="text" name="mcast"></td></tr>
<tr><th>장르</th><td><input type="text" name="genre"></td></tr>
<tr><th>영화 등록자</th><td><input type="text" name="seller" 
value="${sessionScope.id }" readonly></td></tr>
<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
</table>
</form>
</body>
</html>