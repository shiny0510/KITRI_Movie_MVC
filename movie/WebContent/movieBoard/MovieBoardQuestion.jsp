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
<h3>���� ���� ����</h3>
<div style="position:absolute;top:10px;left:500px">
${sessionScope.id }���� ���� ����
<a href="${pageContext.request.contextPath }/MemEditFormController">����������</a>
<a href="${pageContext.request.contextPath }/MemLogoutController">�α׾ƿ�</a>
</div>
<a href="<%=request.getContextPath() %>/movieBoard/MovieBoardWrite.jsp">�����ϱ�</a><br/><br/>
<table style="width:100%">
<tr style="background-color:grey">
<tr><th>�۹�ȣ</th><th>����</th><th>�亯����</th><th>�����</th></tr>
<c:if test="${not empty list }">
<c:forEach var="i" items="${list }">
<tr><td id="n_${b.num }">${b.num }</td><td id="t_${b.title }">${b.title }</td><td id="r_${b.reply }">${b.reply }</td><td id="d_${b.date }">${b.date }</td></tr>
<%-- <td id="d_${b.date }">${b.w_date }</td></tr> --%>
<%-- <tr><td id="tr_${b.num }"></td><td>${b.num }<td id="t_${b.title }">${b.title }</td></tr> --%>
<%-- <td id="d_${b.date }">${b.w_date }</td></tr> --%>
<c:if test="${sessionScope.id==b.writer }">
<%-- <input type="button" num="${r.num }" class="b1" value="����1"> --%>
<%-- <input type="button" num="${r.num }" class="b2" value="����2"> --%>
<%-- <input type="button" num="${r.num }" class="b3" value="����"> --%>
<!-- </c:if> -->


<!-- <tr><th>img</th> -->
<%-- <td><img src="/img/${r.path }" style="width:300px;height:200px"></td></tr> --%>
<%-- <tr><th>content</th><td id="c_${r.num }">${r.content }</td></tr> --%>
<%-- <tr><th>���</th><td><input type="text" id="rep_${r.num }"> --%>
<%-- <input type="button" value="�ۼ�" class="r" num="${r.num }"> --%>
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



