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
var op1 ="", op2="", op3="";
$.getSelectList=function(param, spanId, selId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath }/CateListController",
		data:param,
		success:function(data){
			var arr = eval("("+data+")");
			var str = "<select id="+selId+">";
			for(i=0;i<arr.length;i++){
				str += "<option value="+arr[i].num+">"
				+arr[i].name+"</option>";
			}
			str += "</select>";
			$(spanId).html(str);
			$('#'+selId).on("change", function(){				
				var op = $(this).val();
				if(selId=="s1"){
					op1 = op;
					op2="";
					op3="";
					$.b();
				}else if(selId=="s2"){
					op2=op;
					op3="";
					$.c();
				}else if(selId=="s3"){
					op3=op;
					alert(op1+"/"+op2+"/"+op3);
				}
			});
		}
	});
}
$.a=function(){
	var param = "parent=0&table=cate1";
	$.getSelectList(param, "#sel1", "s1");
	$("#sel2").html('');
	$("#sel3").html('');
}
$.b=function(){
	var param = "parent="+op1+"&table=cate2";
	$.getSelectList(param, "#sel2", "s2");
}
$.c=function(){
	var param = "parent="+op2+"&table=cate3";
	$.getSelectList(param, "#sel3", "s3");
}
$.d=function(param, myUrl){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath }/"+myUrl,
		data:param,
		success:function(data){
			var str = "";
			var arr = eval("("+data+")");
			for(i=0;i<arr.length;i++){
				if(i%3==0){
					str += "<tr>";
				}
				str += "<td>";
				str += "<table border=1>";
				str += "<tr><td><a href=${pageContext.request.contextPath }/GetMovieController?num="
						+arr[i].num+"&ptype=2>";
				str += "<img src=/img2/movie2/"
				+arr[i].path1+" style='width:200px;height:150px'></a></td></tr>";
				str += "<tr><td>상품명:"+arr[i].title+"</td></tr>";
				str += "</table>";
				str += "</td>";
				if(i%3==2){
					str += "</tr>";
				}
			}
			$('#listTable').html(str);
		}
	});
}
$.e=function(){
	var str = document.cookie;
	var html = "<table border=1>";
	if(str!=""){
	var arr = str.split(';');
	for(i=0;i<arr.length;i++){
		var vals = arr[i].split('=');
		var num = vals[0];
		var str2 = vals[1].split(':');
		var path = str2[0]
		var title = str2[1];
		html += "<tr><td><img src=/img2/movie2/"+path+
		" style='width:50px;height:50px'></td></tr>";
		
		html += "<tr><td>열람 영화명:<a href=${pageContext.request.contextPath }/GetMovieController?num="+num+"&ptype=${sessionScope.type}>"+title+"</a></td></tr>";
		html += "<tr><td><input type=button class=bx value=삭제 num="+num+"></td></tr>";
	}
	}
	html+="</table>";
	$('#myClick').html(html);
	$('.bx').on('click', function(){
		var num = $(this).attr('num');
		var param = "num="+num
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath }/MovieDelCookieController",
			data:param,
			success:function(data){
				$.e();
			}
		});
	});
}
$(document).ready(function(){
	$.a();
	$('#cb').click(function(){
		var param = "";
		if(op3!=""){
			param = "cate=3&value="+op3;
		}else if(op2!=""){
			param = "cate=2&value="+op2;
		}else if(op1!=""){
			param = "cate=1&value="+op1;
		}else{
			alert("카테고리를 선택하시오");
			return;
		}
		$.d(param, '/MovieCateListController');
		$.a();
	});
	$('#price1').change(function(){
		var price = $(this).val();
		var param = "price="+price;
		$.d(param, 'MoviePriceListController');
	});
	$.e();
});

</script>
</head>
<body>

<c:if test="${sessionScope.type==2}">
<table>
<tr><td><a href="${pageContext.request.contextPath }//movie/Main.jsp?sub=/movieFix/addForm.jsp">영화등록</a></td></tr>
</table>
</c:if>
<h3>영화 목록</h3>
<div id="myClick" style="position:absolute;top:100px;left:850px"></div>
<span id="sel1"></span>
<span id="sel2"></span>
<span id="sel3"></span>
<input type="button" value="카테고리로 검색" id="cb"><br/>
<c:if test="${not empty list}">
<table id="listTable">

<c:forEach var="a" items="${list }" varStatus="status">

<c:if test="${status.index%3 == 0}">
<tr>
</c:if>
<td>
<table border="1">
<tr><td><a href="${pageContext.request.contextPath }/GetMovieController?num=${a.num}&ptype=2">
<img src="/img2/movie2/${a.path1 }"style="width:200px;height:150px">
</a></td></tr>
<tr><td>영화명:<a href="${pageContext.request.contextPath }/GetMovieController?num=${a.num}&ptype=${sessionScope.type}">${a.title }</a></td></tr>
<tr><td>감독:${a.director }</td></tr>
<tr><td>평점:</td></tr>
</table>
</td>
<c:if test="${status.index%3 == 2}">
</tr>
</c:if>
</c:forEach>
</table>
</c:if>
</body>
</html>