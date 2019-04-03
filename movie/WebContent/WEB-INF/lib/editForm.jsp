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
var flag = true;
$.getSelectList=function(param, spanId, selId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath }/MovieCateListController",
		data:param,
		success:function(data){
			var arr = eval("("+data+")");
			var str = "<select id="+selId+" name="+selId+">";
			for(i=0;i<arr.length;i++){
				var x = '';
				if((selId=='cate1' && ${p.cate1}==arr[i].num)
						||(selId=='cate2' && ${p.cate2}==arr[i].num)
						||(selId=='cate3' && ${p.cate3}==arr[i].num)){
					x='selected';
				}
				str += "<option value="+arr[i].num+" "+x+">"
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
	var param = "";
	if(flag){
		param = "parent=${p.cate1}&table=cate2";
	}else{
		param = "parent="+op1+"&table=cate2";
	}
	$.getSelectList(param, "#sel2", "cate2");
}
$.c=function(){
	var param = "";
	if(flag){
		param = "parent=${p.cate2}&table=cate3";
	}else{
		param = "parent="+op2+"&table=cate3";
	}
	$.getSelectList(param, "#sel3", "cate3");
}

$(document).ready(function(){
	$.a();
	$.b();
	$.c();
	flag = false;
	$('#del').click(function(){
		var num = $('input[type=hidden]').val();
		location.href="${pageContext.request.contextPath }/MovieDelController?num="+num;
	});
});
</script>
</head>
<body>
<h3>영화 수정</h3>
<form action="${pageContext.request.contextPath }/MovieEditController" 
method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>title</th><td><input type="text" name="title" value="${p.title }"></td></tr>
<tr><th>price</th><td><input type="text" name="price" value="${p.price }"></td></tr>
<tr><th>info</th><td><input type="text" name="info" value="${p.info }"></td></tr>
<tr><th>quantity</th><td><input type="text" name="quantity" value="${p.quantity }"></td></tr>
<tr><th>제품분류(대분류)</th><td id="sel1"></td></tr>
<tr><th>제품분류(중분류)</th><td id="sel2"></td></tr>
<tr><th>제품분류(소분류)</th><td id="sel3"></td></tr>
<tr><th>img1</th>
<td>
<c:if test="${p.path1!=null && p.path1!='' }">
<img src="/img/movie/${p.path1 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path1"></td></tr>
<tr><th>img2</th>
<td><c:if test="${p.path2!=null && p.path2!='' }">
<img src="/img/movie/${p.path2 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path2"></td></tr>
<tr><th>img3</th>
<td><c:if test="${p.path3!=null && p.path3!='' }">
<img src="/img/movie/${p.path3 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path3"></td></tr>
<tr><th>img4</th>
<td><c:if test="${p.path4!=null && p.path4!='' }">
<img src="/img/movie/${p.path4 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path4"></td></tr>
<tr><th>판매자</th><td><input type="text" name="seller" 
value="${sessionScope.id }" readonly></td></tr>
<tr><td colspan="2"><input type="submit" value="수정">
<input type="button" id="del" value="삭제"></td></tr>
</table>
<input type="hidden" name="num" value="${p.num }">
</form>
</body>
</html>