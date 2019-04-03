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
				str+="<option value=0>선택</option>";
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
		var bool=confirm("지점을 수정하시겠습니까?");
		if(bool){
		$("#f").attr("action","${pageContext.request.contextPath }/areaEditController");
		$("#f").submit();
		}
	});
	
	$("#del").click(function(){
		var bool=confirm("지점을 지우시겠습니까?");
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
<h3>영화관 수정</h3>
<form id="f" name="f" action="" method="post">
<table border="1" style="width:500px;height:300px;margin:auto;border:2px dashed #1E96FF">
<tr><th style="width:40%">지역</th><td>
<c:if test="${not empty list}">
<select id="sel1" name="area" style="width:80%;height:40px;font-size:20px">
<option value="0">선택</option>
<c:forEach var="list" items="${list}">
<option value="${list.area }" >${list.area }</option>
</c:forEach>
</select>
</c:if>
</td></tr>
<tr style="height:50px"><th style="width:40%">지점</th><td id="td1"></td></tr>
<tr style="height:50px"><th style="width:40%">바꿀 지점명:</th><td><input type="text" border="0" id="editName" name="editName" placeholder="바꿀 지점이름" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">x좌표</th><td><input type="text" border="0" name="x" placeholder="x좌표" style="width:99%;height:50px"></td></tr>
<tr style="height:50px"><th style="width:40%">y좌표</th><td><input type="text" border="0" name="y" placeholder="y좌표" style="width:99%;height:50px"></td></tr>
<tr>
<td colspan="3">
<input type="button" id="edit" value="영화관 수정" style="background-color:#1E96FF;width:157px;height:50px">
<input type="button" id="del" value="영화관 삭제" style="background-color:#1E96FF;width:157px;height:50px">
<input type="button" id="back" value="돌아가기" style="background-color:#1E96FF;width:157px;height:50px"></td>
</tr>
</table>
</form>
</body>
</html>