<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<br/>


<!-- ----------------------------------- -->
<body>
<img src="${pageContext.request.contextPath }/img/1.png" style="width:100%;height:300px">
<h3>나의 문의 내역</h3>
<div style="position:absolute;top:10px;left:500px">
${sessionScope.id }님의 문의 내역
<a href="${pageContext.request.contextPath }/MemEditFormController">마이페이지</a>
<a href="${pageContext.request.contextPath }/MemLogoutController">로그아웃</a>
</div>
<a href="<%=request.getContextPath() %>/movieBoard/MovieBoardWrite.jsp">문의하기</a><br/><br/>
<table style="width:100%">
<tr style="background-color:grey">
<tr><th>글번호</th><th>제목</th><th>답변상태</th><th>등록일</th></tr>
<c:if test="${not empty list }">
<c:forEach var="i" items="${list }">
<tr><td id="n_${b.num }">${b.num }</td><td id="t_${b.title }">${b.title }</td><td id="r_${b.reply }">${b.reply }</td><td id="d_${b.date }">${b.date }</td></tr>
<%-- <td id="d_${b.date }">${b.w_date }</td></tr> --%>
<%-- <tr><td id="tr_${b.num }"></td><td>${b.num }<td id="t_${b.title }">${b.title }</td></tr> --%>
<%-- <td id="d_${b.date }">${b.w_date }</td></tr> --%>
<c:if test="${sessionScope.id==b.writer }">
<%-- <input type="button" num="${r.num }" class="b1" value="수정1"> --%>
<%-- <input type="button" num="${r.num }" class="b2" value="수정2"> --%>
<%-- <input type="button" num="${r.num }" class="b3" value="삭제"> --%>
<!-- </c:if> -->


<!-- <tr><th>img</th> -->
<%-- <td><img src="/img/${r.path }" style="width:300px;height:200px"></td></tr> --%>
<%-- <tr><th>content</th><td id="c_${r.num }">${r.content }</td></tr> --%>
<%-- <tr><th>댓글</th><td><input type="text" id="rep_${r.num }"> --%>
<%-- <input type="button" value="작성" class="r" num="${r.num }"> --%>
<%-- <div id="replist_${r.num }"></div> --%>
<script type="text/javascript">
$.makeList(${b.num });
<!-- </script> -->
<!-- </td></tr> -->
</table>
</td></tr>
</c:forEach>
</table>
</c:if>
<form name="f">
<input type="hidden" name="num">
<input type="hidden" name="title">
<input type="hidden" name="content">
<input type="hidden" name="w_date">
<input type="hidden" name="path">
<input type="hidden" name="writer">
</form>
</body>
</html>



