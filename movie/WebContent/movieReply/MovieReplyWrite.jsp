<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.btn {
background-color: #87CEEB;
padding: 10px 20px;
margin: 6px;
border: none;
color: black;
text-align: center;
text-decoration: none;
font-size: 20px;
display: inline-block;
cursor: pointer;
-webkit-transition-duration: 0.4s;
transition-duration: 0.4s;
}
.btn1:hover {
background-color: #4169E1;
color: white;
}
</style>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$.makeList=function(parent){
	var param = "parent="+parent;
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/MovieReplyWriteController",
		data:param,
		success:function(data){
			var arr = eval("("+data+")");
			var str = "��۸��<br/>";
			for(i=0;i<arr.length;i++){
				str += "�ۼ���:"+arr[r].writer;
				str += "<br/>����:"+arr[r].content;
				str += "<br/>�ۼ���:"+arr[r].w_date;
				str += "<br/><br/>";				
			}
			$('#replist_'+parent).html(str);
		}
	});
}


$(document).ready(function(){
	$("#write").click(function(){
		location.href="${pageContext.request.contextPath }/MovieBoardComplete.jsp";
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%;height:300px">
<div id="top" align="center">
<h1>1:1 ���� �亯�ϱ�</h1>
</div>

<form action="${pageContext.request.contextPath }/MovieReplyWriteController" method="post">
<table style="width:100%" position="">
<tr><input type="hidden" name="parent" value="${param.parent}"></tr>
<%-- <tr><th align="left">${param.parent} </th><td><input type="text" name="aaa" value="������" size="100" readonly></td></tr> --%>
<tr><th align="left"> �ۼ���</th><td><input type="text" name="writer" value="������" size="100" readonly></td></tr>
<tr><th align="left"> ����</th><td><input type="text" value="��RE:�亯�Դϴ�.${b.title }" name="title" size="100" readonly></td></tr>
<tr><th align="left"> ����</th><td ><textarea name="content" rows="30" cols="100"></textarea></td></tr>
<tr height="100"><td colspan="4">
<input class="btn btn1" type="submit" value="���" id="write">
<%-- <div id="replist_${param.parent}"></div> --%>
</td>
</tr>
</table>
</form>
</body>
</html>