<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$.a=function(row){
	switch(row){
	case "a":
		return 0;
		break;
	case "b":
		return 1;
		break;
	case "c":
		return 2;
		break;
	case "d":
		return 3;
		break;
	case "e":
		return 4;
		break;
	case "f":
		return 5;
		break;
	case "g":
		return 6;
		break;
	case "h":
		return 7;
		break;
	case "i":
		return 8;
		break;
	case "j":
		return 9;
		break;
	case "k":
		return 10;
		break;
	case "l":
		return 11;
		break;
	case "m":
		return 12;
		break;
	case "n":
		return 13;
		break;
	case "o":
		return 14;
		break;
	case "p":
		return 15;
		break;
	case "q":
		return 16;
		break;
	case "r":
		return 17;
		break;
	case "s":
		return 18;
		break;
	case "t":
		return 19;
		break;
	case "u":
		return 20;
		break;
	case "v":
		return 21;
		break;
	case "w":
		return 22;
		break;
	case "x":
		return 23;
		break;
	case "y":
		return 24;
		break;
	case "z":
		return 25;
		break;
	}
}
$.b=function(rowline){
	switch(rowline){
	case 0:
		return "a";
		break;
	case 1:
		return "b";
		break;
	case 2:
		return "c";
		break;
	case 3:
		return "d";
		break;
	case 4:
		return "e";
		break;
	case 5:
		return "f";
		break;
	case 6:
		return "g";
		break;
	case 7:
		return "h";
		break;
	case 8:
		return "i";
		break;
	case 9:
		return "j";
		break;
	case 10:
		return "k";
		break;
	case 11:
		return "l";
		break;
	case 12:
		return "m";
		break;
	case 13:
		return "n";
		break;
	case 14:
		return "o";
		break;
	case 15:
		return "p";
		break;
	case 16:
		return "q";
		break;
	case 17:
		return "r";
		break;
	case 18:
		return "s";
		break;
	case 19:
		return "t";
		break;
	case 20:
		return "u";
		break;
	case 21:
		return "v";
		break;
	case 22:
		return "w";
		break;
	case 23:
		return "x";
		break;
	case 24:
		return "y";
		break;
	case 25:
		return "z";
		break;
	}
}
$(document).ready(function(){
	$(".button1").click(function(){
		var param="area=";
		var value=$(this).val();
		param+=value;
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/areaListController",
			data:param,
			success:function(data){
				var arr=eval("("+data+")");
				var str="";
				for(i=0; i<arr.length; i++){
					if(i==0 || i%2==0){
						str+="<tr>";
					}
					str+="<td><input type=button class=button2 value="+arr[i].name+" style=background-color:#3CFBFF;width:100px;height:50px;font-size:17px></td>"
					if(i%2==1){
						str+="</tr>";
					}
				}
				$("#div2").html(str);
				$("#th1").html("영화관");
		
		
				$(".button2").on("click",function(){
					$("#div4").html("");
					var html="";
					var clickName=$(this).val();
					$("#div3").attr("style","position:relative;top:-150px;left:350px;width:450px;height:450px;background-image:url(/areaPicture/"+value+".png);background-repeat:no-repeat;background-size:contain");
					var param1="name=";
					param1+=clickName;
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/getXYController",
						data:param1,
						success:function(data){
							var result=eval("("+data+")");
							var html1="";
							html1+="<input type=image src=${pageContext.request.contextPath}/img/2.png class=imgButton style=position:relative;width:30px;height:30px;left:"+result.x+"px;top:"+result.y+"px>";
							$("#div3").html(html1);
							
							$(".imgButton").on("click",function(){
								var param2="parent="+clickName;
								$.ajax({ 
									type:"post",
									url:"${pageContext.request.contextPath}/screenListController",
									data:param2,
									success:function(data){
										var arr=eval("("+data+")");
										var str="<table><tr><td>영화관 좌석 정보</td></tr><tr><td>"
										for(i=0;i<arr.length;i++){
										str+="<input type=button value="+arr[i].num+"관 id="+arr[i].num+" row="+arr[i].rowline+" column="+arr[i].columnline+" class=screenButton style=width:40px;height:30px>&nbsp";
										}
										str+="</td></tr><tr><td><div id=div5 style=width:200px;height:200px></div></td></tr></table>"	
										$("#div4").attr("style","position:relative;top:-250px;left:300px;width:450px;height:450px");
										$("#div4").html(str);
										
										$(".screenButton").on("click",function(){
											var row=$(this).attr("row");
											var rowline=$.a(row);
											var column=$(this).attr("column");
											var rowname="";
											var str="<table border=1><tr><td colspan="+column+">screen</td></tr>";
											for(i=0;i<=rowline;i++){
												str+="<tr>";
												rowname=$.b(i);
												for(j=0;j<column;j++){
													str+="<td><input type=text value="+rowname+j+" readonly style=width:35px;height:35px;text-align:center></td>";
												}
												str+="</tr>";
											}
											str+="</table>";
											$("#div5").html(str);
										});
									}
								});
							});
						}
					});
				});
			}
		});
	});
	$("#insert").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/area/addForm.jsp";
	});
	$("#edit").click(function(){
		location.href="${pageContext.request.contextPath }/locationListController?type=2";
	});
	$("#insertScreen").click(function(){
		location.href="${pageContext.request.contextPath }/areaGetController?type=1";
	});
	$("#editScreen").click(function(){
		location.href="${pageContext.request.contextPath }/areaGetController?type=2";
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h1>영화관</h1>
<span>
<table id="div1"><tr>
<c:if test="${sessionScope.type==3}">
<td><input type="button" id="insert" value="지역 영화관추가" style="background-color:#1E96FF; width:150px;height:50px"></td>
<td><input type="button" id="edit" value="지역 영화관수정" style="background-color:#1E96FF; width:150px;height:50px"></td>
</c:if>
</tr>
<c:if test="${sessionScope.type==2}">

<td><input type="button" id="insertScreen" value="${sessionScope.area}지점 상영관추가" style="background-color:#1E96FF; width:200px;height:50px"></td>
<td><input type="button" id="editScreen" value="${sessionScope.area}지점 상영관수정" style="background-color:#1E96FF; width:200px;height:50px"></td>
</c:if>
</table>

<table>
<tr><th>지역</th><th id="th1"></th></tr>
<tr>
<td><table border="1">
<c:forEach var="a" items="${list }">
<tr><td><input type="button" id="b1" value="${a.area}" class="button1" style="width:100px;height:50px;font-size:17px"></td></tr>
</c:forEach>
</table></td>
<td><table id="div2">
</table></td>
<td></td>
</tr>
</table>
</span>
<span><div id="div3" style=""></div></span>
<span><div id="div4" style=""></div></span>
</body>
</html>