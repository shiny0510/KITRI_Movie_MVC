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
<h3>��ũ�� �߰�</h3>
<form id="f" name="f" action="${pageContext.request.contextPath}/screenAddController" method="post">
<table border="1" style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr style="height:50px"><th style="width:40%">����</th><td>${a.area}</td></tr>
<tr style="height:50px"><th style="width:40%">����</th><td><input type="text" border="0" name="parent" value="${a.name}" style="width:99%;height:50px;text-align:center" readonly></td></tr>
<tr style="height:50px"><th style="width:40%">�󿵰� ��ȣ</th><td><input type="text" border="0" name="num" placeholder="�󿵰���ȣ �Է�" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">�󿵰� ����</th><td><input type="text" border="0" name="price" placeholder="�󿵰� ����" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">�󿵰� row</th><td><input type="text" border="0" name="rowLine" placeholder="x��" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">�󿵰� column</th><td><input type="text" border="0" name="columnLine" placeholder="y��" style="width:99%;height:50px"></td></tr>
<tr>
<td colspan="2">
<input type="submit" value="�󿵰� �߰�" style="background-color:#1E96FF;width:157px;height:50px">
<input type="button" id="back" value="���ư���" style="background-color:#1E96FF;width:157px;height:50px"></td>
</tr>
</table>
</form>
</body>
</html>