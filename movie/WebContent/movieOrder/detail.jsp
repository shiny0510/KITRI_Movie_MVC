<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.sm').mouseover(function(){
		var i = $(this).attr('src');
		$('#bm1').attr('src', i);
	});
	$('#cnt').change(function(){
		var price = parseInt($('#price').html());
		var q = parseInt($(this).val());
		var t = price*q;
		$('#totalPrice').html(t);
	});
});
</script>
</head>
<body>
<h1>${m.title }</h1>
<table>
<tr>
<td>
<table border="1">
<tr><td colspan="4"><img id="bm" src="/img2/movie2/${m.path1 }" 
style="width:200px;height:200px"></td></tr>
</table>
</td>
<td><table>
<tr><th>��ȭ����</th><td id="price">${m.title }</td></tr>
<tr><th>����</th><td id="score">${r.score }</td></tr>
<tr><th>�帣</th><td>${m.genre}</td></tr>
<tr><th>����</th><td id="director">${m.director}</td></tr>
<tr><th>�⿬��</th><td>${m.mcast }</td></tr>
<tr><th>�󿵽ð�</th><td>${m.runtime}��</td></tr>
<tr><th>�����ݾ�</th><td id="totalPrice"></td></tr>
<tr><td colspan="2"><input type="button" value="�����ϱ�">
<input type="button" value="��ٱ���"></td></tr>
</table></td>
</tr>
<tr><td colspan="2"><h1>��ȭ �� ����</h1>
�ٰŸ�:${m.director}<br/>
<br/>
</td></tr>
</table>
<h1>��ƿ��</h1>
<table border="1" style="width:100%">
<tr>
<td style="width:25%"><img class="sm" src="/img2/movie2/${m.path1 }" 
style="width:100%;height:250px"></td>
<td style="width:25%"><c:if test="${m.path2!=null && m.path2!='' }">
<img class="sm" src="/img2/movie2/${m.path2 }" 
style="width:100%;height:250px"></c:if></td>
<td style="width:25%"><c:if test="${m.path3!=null && m.path3!='' }">
<img class="sm" src="/img2/movie2/${m.path3 }" 
style="width:100%;height:250px"></c:if></td>
<td style="width:25%"><c:if test="${m.path4!=null && m.path4!='' }">
<img class="sm" src="/img2/movie2/${m.path4 }" 
style="width:100%;height:250px"></c:if></td>
</tr>
<table border="1" style="width:75%; height:500px; background-color:black" align="center" >
<tr align="center"><td colspan="4"><img id="bm1" src="/img2/movie2/${m.path1 }" 
style="width:70%; height:100%"  ></td></tr>
</table>
</table>
<h2>��ȭ ���� �߰�</h2>
<form action="${pageContext.request.contextPath }/ReviewAddController?num=${m.num}&ptype=${sessionScope.type}" 
method="post" enctype="multipart/form-data">
<table border="1" align="center" style="height:50px">
<tr><th>��ȭ��ȣ</th><td><input style="height:100%" type="text" name="num" value="${m.num}" readonly></td>
<th>���� ���̵�</th><td><input style="height:100%" type="text" name="id" value="${sessionScope.id }"readonly></td>
<th>���� ����</th><td><input style="height:100%" type="text" name="content"></td>
<th>���� ����</th><td><input style="height:100%" type="text" name="score"></td>
<th>���� ��� ��ȣ</th><td><input  style="height:100%" type="text" name="pwd"></td>
<td colspan="2"><input style="height:100%" type="submit" value="���� ���"></td></tr>
</table>
</form>
<h2>��ȭ ����</h2>
<c:if test="${not empty list}">
<table id="listTable" align="center" style="width:100%" >
<c:forEach var="a" items="${list }" varStatus="status">
<c:if test="${status.index%3 == 0}">
<tr>
</c:if>
<td>
<table border="1" style="width:100%; text-align:center">
<tr><td>��ȭ��ȣ</td><td>���̵�</td><td>����</td><td>����</td><td>��¥</td><td>����</td></tr>
<tr><td>${a.num }</td><td>${a.id }</td><td>${a.content }</td><td>${a.score }</td><td>${a.rdate}</td> <c:if test="${sessionScope.id==a.id}"> <form action="${pageContext.request.contextPath }/ReviewDeleteController?num=${m.num}&rno=${a.rno}&ptype=${sessionScope.type}" 
method="post" enctype="multipart/form-data"><td><input style="height:100%" type="submit" value="����"></td></c:if></tr>
</table>
</td>
</tr>
</c:forEach>
</table>
</c:if>
</form>
</body>
</html>