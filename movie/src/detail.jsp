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
$(document).ready(function(){
	$('.sm').mouseover(function(){
		var i = $(this).attr('src');
		$('#bm').attr('src', i);
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
<h3>${m.title }</h3>
<table>
<tr>
<td>
<table border="1">
<tr><td colspan="4"><img id="bm" src="/img2/movie2/${m.path1 }" 
style="width:200px;height:200px"></td></tr>
<tr>
<td style="width:50px"><img class="sm" src="/img2/movie2/${m.path1 }" 
style="width:50px;height:50px"></td>
<td style="width:50px"><c:if test="${m.path2!=null && m.path2!='' }">
<img class="sm" src="/img2/movie2/${m.path2 }" 
style="width:50px;height:50px"></c:if></td>
<td style="width:50px"><c:if test="${m.path3!=null && m.path3!='' }">
<img class="sm" src="/img2/movie2/${m.path3 }" 
style="width:50px;height:50px"></c:if></td>
<td style="width:50px"><c:if test="${m.path4!=null && m.path4!='' }">
<img class="sm" src="/img2/movie2/${m.path4 }" 
style="width:50px;height:50px"></c:if></td>
</tr>
</table>
</td>
<td><table border="1">
<tr><th>가격</th><td id="price">${p.price }</td></tr>
<tr><th>재고량</th><td>${p.quantity }</td></tr>
<tr><th>주문수량</th>
<td><select name="cnt" id="cnt">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select></td></tr>
<tr><th>결제금액</th><td id="totalPrice"></td></tr>
<tr><td colspan="2"><input type="button" value="즉시결제">
<input type="button" value="장바구니"></td></tr>
</table></td>
</tr>
<tr><td colspan="2"><h4>제품 상세 설명</h4>
판매자:${p.seller }<br>
info:${p.info }
</td></tr>
</table>
</body>
</html>