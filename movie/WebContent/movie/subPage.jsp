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
	$("#close").click(function(){
		close();
	});
	
	var param="id="+$("#td1").attr("name");
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/getMemberController",
		data:param,
		success:function(data){
			var list=eval("("+data+")");
			var str="";
				if(list.id==1){
					str+="<tr><td>소중한 고객님</td>";
				}else{
					str+="<tr><td>직원님</td>";	
				}
				str+="<td>point:"+list.point+"</td></tr>";
				str+="<tr><td><input type=button id=myInfo value=내정보보기></td>";
				str+="<td><input type=button id=myOrder value=구매내역></td></tr>";
				$("#info").html(str);
				
				$("#myInfo").click(function(){
					opener.location.href="${pageContext.request.contextPath }/getMemberController1";
			 		close();
				});
				
				$("#myOrder").click(function(){
					opener.location.href="${pageContext.request.contextPath }/TicketAllListController";
			 		close();
				});
			}
	});
	
	
});
</script>
</head>
<body style="background-color:yellow">
<form name="f" id="f">
<table>
<tr>
<td style="font-size:30px;" id="td1" name="${sessionScope.id}">${sessionScope.id}님의 정보 보기</td>
<td><img id="close" src="${pageContext.request.contextPath}/img/x.png" style="width:50px;height:40px">
</td>
</tr>
</table>
<table id="info">
</table>
</form>
</body>
</html>