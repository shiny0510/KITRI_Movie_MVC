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
	
	$("#sel1").on("change",function(){
		var area=$("#sel1").val();
		var param="area="+area;
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/areaListController",
			data:param,
			success:function(data){
				var arr=eval("("+data+")");
				var str="<select name=name id=sel2 style=width:80%;height:40px;font-size:20px>";
				str+="<option value=0>����</option>";
				for(i=0;i<arr.length;i++){
					str+="<option value="+arr[i].name+">"+arr[i].name+"</option>";
				}
				str+="</select>";
				$("#td1").html(str);
			}
		});
	});
	
	$("#edit").click(function(){
		var check=$("#editName").val();
		if(check==null||check==""||check=="undefined"){
			$("#editName").attr("name","");
		}
		var bool=confirm("������ �����Ͻðڽ��ϱ�?");
		if(bool){
		$("#f").attr("action","${pageContext.request.contextPath }/areaEditController");
		$("#f").submit();
		}
	});
	
	$("#del").click(function(){
		var bool=confirm("������ ����ðڽ��ϱ�?");
		if(bool){
			$("#f").attr("action","${pageContext.request.contextPath }/areaDelController");
			$("#f").submit();
		}
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>��ȭ�� ����</h3>
<form id="f" name="f" action="" method="post">
<table border="1" style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr><th style="width:40%">����</th><td>
<c:if test="${not empty list}">
<select id="sel1" name="area" style="width:80%;height:40px;font-size:20px">
<option value="0">����</option>
<c:forEach var="list" items="${list}">
<option value="${list.area }" >${list.area }</option>
</c:forEach>
</select>
</c:if>
</td></tr>
<tr style="height:50px"><th style="width:40%">����</th><td id="td1"></td></tr>
<tr style="height:50px"><th style="width:40%">�ٲ� ������:</th><td><input type="text" border="0" id="editName" name="editName" placeholder="�ٲ� �����̸�" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">x��ǥ</th><td><input type="text" border="0" name="x" placeholder="x��ǥ" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">y��ǥ</th><td><input type="text" border="0" name="y" placeholder="y��ǥ" style="width:99%;height:50px"></td></tr>
<tr>
<td colspan="3">
<input type="button" id="edit" value="��ȭ�� ����" style="background-color:#1E96FF;width:157px;height:50px">
<input type="button" id="del" value="��ȭ�� ����" style="background-color:#1E96FF;width:157px;height:50px">
<input type="button" id="back" value="���ư���" style="background-color:#1E96FF;width:157px;height:50px"></td>
</tr>
</table>
</form>
</body>
</html>