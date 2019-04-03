<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<f:view>
<h1 style="text-align:center; color:#d32c2f">주문하신 티켓이 결제가 완료되었습니다.</h1>
<br/>
<h2 align=center>주문정보</h2>
<form action="${pageContext.request.contextPath }/addTicketController?num=${m.num}&ptype=${sessionScope.type}" 
method="post" enctype="multipart/form-data">
<table border="1" align="center" style="width:100%">
<tr style="text-align:center; background:gray; width:100%" >
<td><h3>아이디</h3></td>
<td><h3>영화제목</h3></td>
<td><h3>영화관</h3></td>
<td><h3>상영관</h3></td>
<td><h3>상영날짜</h3></td>
<td><h3>상영시간</h3></td>
<td><h3>좌석</h3></td>
<td><h3>가격</h3></td>
</tr>
<tr style="text-align:center; width:100%">
<td><input style="height:100%" type="text" name="id1" value="${sessionScope.id}" readonly></td>
<td><input style="height:100%" type="text" name="title" value="${param.value3}" readonly></td>
<td><input style="height:100%" type="text" name="theater" value="${param.value2}" readonly></td>
<td><input style="height:100%" type="text" name="screen" value="${param.value4}" readonly></td>
<td><input style="height:100%" type="text" name="mdate" value="${param.value5}" readonly></td>
<td><input style="height:100%" type="text" name="mtime" value="${param.value6}" readonly></td>
<td><input style="height:100%" type="text" name="seat" value="${param.value9}" readonly></td>
<td><input style="height:100%" type="text" name="point" value="${param.value8}" readonly></td>
</tr>
</table>
<br/>
<table border="1" align="center">

<tr style="text-align:center">
<td colspan = "2"><input type="submit" value="메인으로 이동" style="height:50px; width:100%" ></td>
</tr>

</table>
</form>
</f:view>
</body>
</html>