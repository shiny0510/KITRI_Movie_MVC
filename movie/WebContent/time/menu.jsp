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
	$("#add").click(function(){
		location.href="${pageContext.request.contextPath }/areaGetController?type=3";
	});
	$("#edit").click(function(){
		location.href="${pageContext.request.contextPath }/areaGetController?type=4";
	});
	$("#back").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=mainDown.jsp";
	});
	$("#order").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/order/menu.jsp";
	});
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/timeListController",
			success:function(data){
				var arr=eval("("+data+")");
				var str="<tr style=height:50px>"
					str+="<td style=width:195px>상영중인 날짜검색:</td><td style=width:200px>"
					str+="<select id=date name=date style=width:100%;height:50px;font-size:20px>";
					str+="<option value=0>선택</option>";
				for(i=0; i<arr.length; i++){
					
					if(i==0){
						str+="<option value="+(arr[i].date).substring(0,10)+">"+(arr[i].date).substring(0,10)+"</option>";
					}else{
						if(arr[i].date==arr[i-1].date){
							
						}else{
							str+="<option value="+(arr[i].date).substring(0,10)+">"+(arr[i].date).substring(0,10)+"</option>";	
						}
					}
				}
				str+="</select>";
				str+="</td></tr>";
				$("#div1").html(str);
				
				$("#date").change(function(){
					if($(this).val()==0){
						$("#div2").html("");
					}else{
					param="date="+$(this).val();
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/timeDateListController?type=2",
						data:param,
						success:function(data){
							var arr=eval("("+data+")");
							var str="<table style=text-align:center><tr><th style=width:200px>지점이름</th><th style=width:100px>영화</th><th style=width:100px>상영관</th><th style=width:200px>상영시간</th><th style=width:200px>영화종류</th></tr>";
							str+="<tr>"
							for(i=0; i<arr.length; i++){
								if(i==0){
									str+= "<td style=width:200px>"+arr[i].area+"</td><td style=width:100px>"+arr[i].movie+"</td><td style=width:100px>"+arr[i].screen+"</td><td style=width:200px>"+(arr[i].time).substring(0,16)+"</td><td style=width:100px>"+arr[i].sort+"</td></tr>";
								}else{
									if(arr[i].area==arr[i-1].area){
										str+= "<td style=width:200px></td><td style=width:100px>"+arr[i].movie+"</td><td style=width:100px>"+arr[i].screen+"</td><td style=width:200px>"+(arr[i].time).substring(0,16)+"</td><td style=width:100px>"+arr[i].sort+"</td></tr>";
									}else{
										str+= "<td style=width:200px>"+arr[i].area+"</td><td style=width:100px>"+arr[i].movie+"</td><td style=width:100px>"+arr[i].screen+"</td><td style=width:200px>"+(arr[i].time).substring(0,16)+"</td><td style=width:100px>"+arr[i].sort+"</td></tr>";
									}
								}
							}
							$("#div2").html("");
							$("#div2").html(str);
						}
					});
					}
				});
		}
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>상영시간표</h3>
<c:if test="${sessionScope.type==2}">
영화지점:${sessionScope.area}
<input type="button" id="add" value="영화 상영 등록" style="width:200px;height:50px;text-align:center;font-size:15px">
<input type="button" id="edit" value="영화 상영 수정" style="width:200px;height:50px;text-align:center;font-size:15px">
</c:if>
<input type="button" id="order" value="티켓 예매" style="width:200px;height:50px;text-align:center;font-size:15px">
<table id="div1" border="1" style="text-align:center">
</table>
<div id="div2"></div>
</body>
</html>