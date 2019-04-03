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
		url:"${pageContext.request.contextPath }/CateListController",
		data:param,
		success:function(data){
			var arr = eval("("+data+")");
			var str = "<select id="+selId+" name="+selId+">";
			for(i=0;i<arr.length;i++){
				var x = '';
				if((selId=='cate1' && ${m.cate1}==arr[i].num)
						||(selId=='cate2' && ${m.cate2}==arr[i].num)
						||(selId=='cate3' && ${m.cate3}==arr[i].num)){
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
		param = "parent=${m.cate1}&table=cate2";
	}else{
		param = "parent="+op1+"&table=cate2";
	}
	$.getSelectList(param, "#sel2", "cate2");
}
$.c=function(){
	var param = "";
	if(flag){
		param = "parent=${m.cate2}&table=cate3";
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
<h3>��ȭ ������</h3>
<form action="${pageContext.request.contextPath }/MovieEditController" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>title</th><td><input type="text" name="title" value="${m.title }"></td></tr>
<tr><th>��ũ����1</th>
<td>
<c:if test="${m.path1!=null && m.path1!='' }">
<img src="/img2/movie2/${m.path1 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path1"></td></tr>
<tr><th>��ũ����2</th>
<td><c:if test="${m.path2!=null && m.path2!='' }">
<img src="/img2/movie2/${m.path2 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path2"></td></tr>
<tr><th>��ũ����3</th>
<td><c:if test="${m.path3!=null && m.path3!='' }">
<img src="/img2/movie2/${m.path3 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path3"></td></tr>
<tr><th>��ũ����4</th>
<td><c:if test="${m.path4!=null && m.path4!='' }">
<img src="/img2/movie2/${m.path4 }" style="width:100px;height:100px">
<br/>
</c:if>
<input type="file" name="path4"></td></tr>
<tr><th>ī�װ�(��з�)</th><td id="sel1"></td></tr>
<tr><th>ī�װ�(�ߺз�)</th><td id="sel2"></td></tr>
<tr><th>ī�װ�(�Һз�)</th><td id="sel3"></td></tr>
<tr><th>�󿵽ð�(��)</th><td><input type="text" name="runtime" value="${m.runtime}"></td></tr>
<tr><th>��ȭ ���� ����</th><td><input type="text" name="director" value="${m.director}"></td></tr>
<tr><th>�⿬��</th><td><input type="text" name="mcast" value="${m.mcast}"></td></tr>
<tr><th>�帣</th><td><input type="text" name="genre" value="${m.genre}"></td></tr>
<tr><th>�Ǹ���</th><td><input type="text" name="seller" 
value="${sessionScope.id }" readonly></td></tr>
<tr><td colspan="2"><input type="submit" value="����">
<input type="button" id="del" value="����"></td></tr>
</table>
<input type="hidden" name="num" value="${m.num }">
</form>
</body>
</html>