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
	f.num.value = opener.document.f.num.value;
	f.writer.value = opener.document.f.writer.value;
	f.title.value = opener.document.f.title.value;
	f.content.value = opener.document.f.content.value;
	f.w_date.value = opener.document.f.w_date.value;
	document.xx.src = "/img/"+opener.document.f.path.value;
	$('#b1').click(function(){
		opener.document.f.num.value = f.num.value;
		opener.document.f.title.value = f.title.value;  
		opener.document.f.content.value = f.content.value;
		close();
	});
});
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ImgBoardEditController" 
name="f" method="post">
<table border="1">
<tr><th>num</th>
<td><input type="text" name="num" readonly></td></tr>
<tr><th>writer</th>
<td><input type="text" name="writer" readonly></td></tr>
<tr><th>w_date</th>
<td><input type="text" name="w_date" readonly></td></tr>
<tr><th>title</th>
<td><input type="text" name="title"></td></tr>
<tr><th>img</th>
<td><img src="" style="width:300px;height:200px" name="xx"></td></tr>
<tr><th>content</th>
<td><input type="text" name="content"></td></tr>
<tr><td colspan="2"><input id="b1" type="button" value="수정완료"></td></tr>
</table>

</form>
</body>
</html>