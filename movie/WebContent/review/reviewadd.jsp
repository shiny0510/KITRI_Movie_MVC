<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>��ȭ ���� �߰�</h1>
<form action="${pageContext.request.contextPath }/ReviewAddController" 
method="post" enctype="multipart/form-data">
<table border="1" align="center">

<tr><th>�����ȣ</th><td><input type="text" name="num" value="${p.num}" readonly></td></tr>
<tr><th>���� ���̵�</th><td><input type="text" name="id"></td></tr>
<tr><th>���� ����</th><td><input type="text" name="content"></td></tr>
<tr><th>���� ����</th><td><input type="text" name="score"></td></tr>
<tr><th>���� ��� ��ȣ</th><td><input type="text" name="pwd"></td></tr>

<tr><td colspan="2"><input type="submit" value="���� ���"></td></tr>
</table>
</form>
</body>
</html>