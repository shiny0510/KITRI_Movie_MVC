<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	var numCheck="123";
	var num="";
	$("#backLogin").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=loginForm.jsp";
	});
	
	$("#numButton").click(function(){
		$("#num").attr("style","");
		do{
			num=(Math.floor(Math.random() * 1000000) + 1);
		}while(num<100001);
		num+="";
		numCheck=num;
		alert(numCheck);//�޴��������� �ӽ÷� alert
	});
	
	$("#idButton").click(function(){
		var num1=$("#idNum").val();
		if(num1==numCheck){
			var name=$("#name").val();
			var tel=$("#tel").val();
			var param="name="+name+"&tel="+tel;
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath }/getIdSearchMemberController",
				data:param,
				success:function(data){
					var result=eval("("+data+")");
					alert("������ id��:  "+result.id+" �Դϴ�");
					location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=loginForm.jsp";
				}
			});
		}else{
			alert("������ȣ�ٸ�");
		}
	});
	
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h1>���̵�ã��</h1>
<form name="f" action="" method="post">

<table  style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr><td>
<table border="1" style="margin:auto">
<tr style="height:50px">
<td><input type="text" border="0" id="name" placeholder="�̸�" style="width:99%;height:50px"></td>
<td rowspan="4"><input type="button" id="idButton" value="���̵�ã��" style="background-color:#1E96FF;height:200px">
</tr>
<tr style="height:50px">
<td><input type="text" border="0" id="tel" placeholder="�޴�����ȣ" style="width:99%;height:50px"></td>
</tr>
<tr id="num" style="display:none">
<td><input type="text" border="0" id="idNum" placeholder="������ȣ" style="width:99%;height:50px"></td>
</tr>
<tr>
<td colsapn="2"><input type="button" id="numButton" value="������ȣ����" style="background-color:#1E96FF;width:120px">
<input type="button" id="backLogin" value="���ư���" style="background-color:#1E96FF;width:120px"></td>
</tr>
</table>

</form>
</body>
</html>