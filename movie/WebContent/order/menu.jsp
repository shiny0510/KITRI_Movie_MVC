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
var value1="";
var value2="";
var value3="";
var value4="";
var value5="";
var value6="";
var value7="";
var value8="";
var value9="";
var row="";
var column="";
$(document).ready(function(){
	var today=new Date();
	var day=today.getDay();
	var dd=today.getDate();
	var mm=today.getMonth()+1;
	var yyyy=today.getFullYear();
	if(dd<10){
		dd="0"+dd;
	}
	if(mm<10){
		mm="0"+mm;
	}
	var today1=yyyy+""+mm+""+dd;
	$("#op1").attr("value",today1);
	
	$("#back").click(function(){
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=mainDown.jsp";
	});
	
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/locationListController?type=3",
		success:function(data){
			var arr=eval("("+data+")");
			var str="<select class=button1 style=width:300px;height:50px><option value=0>선택</option>";
			for(i=0; i<arr.length; i++){
					str+="<option value="+arr[i].area+">"+arr[i].area+"</option>";
			}
			str+="</option>";
			$("#td2").html(str);
			
			$(".button1").on("change",function(){
				$("#td4").html("");
				$("#td5").html("");
				$("#sel1").html("");
				$("#sel2").html("");
				$("#sel3").html("");
				$("#sel4").html("");
				$("#sel6").html("");
				$("#sel7").html("");
				$("#sel8").html("");
				$("#sel9").html("");
				value1=$(this).val();
				var param="area="+value1
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath}/areaListController",
						data:param,
						success:function(data){
							var arr=eval("("+data+")");
							var str="";
							str+="<select class=button2 style=width:300px;height:50px><option value=0>선택</option>";
							for(i=0; i<arr.length; i++){
								str+="<option value="+arr[i].name+">"+arr[i].name+"</option>";
							}
							$("#td3").html(str);
							$(".button2").on("change",function(){
								value2=$(this).val();
								var param="area="+value2;
								$.ajax({
								type:"POST",
								url:"${pageContext.request.contextPath}/timeAreaListController",
								data:param,		
								success:function(data){
									var arr=eval("("+data+")");
									var str="<select class=button3 style=width:300px;height:50px><option value=0>선택</option>";
									for(i=0; i<arr.length; i++){
											str+="<option value="+arr[i].movie+">"+arr[i].movie+"</option>";
									}
									str+="</option>";
									$("#td4").html(str);
									
									$(".button3").on("change",function(){
										value3=$(this).val();
										if(value5!=null){
										var param="movie="+value3+"&date="+value5;
										$.ajax({
										type:"POST",
										url:"${pageContext.request.contextPath}/timeMovieListController",
										data:param,		
										success:function(data){
											var arr=eval("("+data+")");
											var str="<table><tr><th></th><th>상영관</th><th>상영시간</th><th>영화종류</th></tr>";
											for(i=0; i<arr.length; i++){
													str+="<tr><td><input type=radio class=radio name=radio value="+arr[i].num+"></td><td id="+arr[i].num+"_screen value="+arr[i].screen+" style=width:100px>"+arr[i].screen+"</td><td id="+arr[i].num+"_time value="+arr[i].time.substring(11,16)+" style=width:100px>"+arr[i].time.substring(11,16)+"</td><td id="+arr[i].num+"_sort value="+arr[i].sort+" style=width:100px>"+arr[i].sort+"</td><td id="+arr[i].num+"_price value="+arr[i].price+" sytle=display:hidden></td><td id="+arr[i].num+"_rowline value="+arr[i].rowline+" sytle=display:hidden></td><td id="+arr[i].num+"_columnline value="+arr[i].columnline+" sytle=display:hidden></td></tr>";
											}
											str+="</table>";
											$("#td5").html(str);
											$("#sel1").html(value3);
											$("#sel2").html(value1);
											$("#sel3").html(value2);
											
											$(".radio").click(function(){
												var num=$(this).val();
												value4=$("#"+num+"_screen").attr("value");
												value6=$("#"+num+"_time").attr("value");
												value7=$("#"+num+"_sort").attr("value");
												value8=$("#"+num+"_price").attr("value");
												row=$("#"+num+"_rowline").attr("value");
												column=$("#"+num+"_columnline").attr("value");
												switch(value7){
												case "3d":
													value8=parseInt(value8)*1.1;
													break;
												case "soundMax":
													value8=parseInt(value8)*1.15;
													break;
												case "4d":
													value8=parseInt(value8)*1.2;
													break;
												}
												$("#sel4").html(value4);
												$("#sel6").html(value6);
												$("#sel7").html(value7);
												$("#sel8").html(value8);
											})
										}
									});
										}
									});
									}
								});
							});
						}
				});
			});
		}
		});
	
	$("#select1").on("change",function(){
		value5=$("#select1").val();
		$("#sel5").html(value5);
	});
	
	$("#seat").click(function(){
		$("#table1").html("");
		var rowline=$.a(row);
		var columnline=parseInt(column);
		var rowname="";
		var str="<tr><td colspan="+columnline+">screen</td></tr>";
		for(i=0;i<=rowline;i++){
			str+="<tr>";
			rowname=$.b(i);
			for(j=0;j<column;j++){
				str+="<td><input type=button class=select2 id="+rowname+j+" value="+rowname+j+" readonly style=width:35px;height:35px;text-align:center></td>";
			}
			str+="</tr>";
		}
		str+="<tr><td colspan=3><input type=button id=reservation value=예매하기><input type=button id=backOrder value=돌아가기></td></tr>";
		$("#table1").html(str);
		$(".select2").click(function(){
	 		value9=$(this).attr("value");
	 		$("#sel9").html(value9);
		});
		$("#backOrder").click(function(){
			location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/order/menu.jsp";
		});
		$("#reservation").click(function(){				
			location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=/Ticket/paycom.jsp?value2="+value2+"&value3="+value3+"&value4="+value4+"&value5="+value5+"&value6="+value6+"&value8="+value8+"&value9="+value9;
		});
	});
});
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
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h3>예매하기</h3>
<table id="table1" border="1" style="font-size:15px;text-align" >
<tr style="height:70px"><td style="width:500px">날짜</td><td style="width:500px">시간</td></tr>
<tr style="height:70px">
<td id="td1"><select id="select1" style=width:300px;height:50px><option value="">선택</option><option id="op1" value="">오늘</option><option id="op2" value="">내일</option><option id="op3" value="">모레</option></select></td>
<td id="td5" rowspan="7"></td></tr>
<tr style="height:70px"><td>지역</td></tr>
<tr style="height:70px"><td id="td2" >1</td></tr>
<tr style="height:70px"><td>극장</td></tr>
<tr style="height:70px"><td id="td3" >1</td></tr>
<tr style="height:70px"><td>영화</td></tr>
<tr style="height:70px"><td id="td4" >1</td></tr>
<tr style="height:70px">
<td><input type="button" id="seat" value="좌석선택" style="width:500px;height:70px"></td>
<td><input type="button" id="back" value="메인으로 가기" style="width:500px;height:70px"></td>
</tr> 
</table>
<br/>
<form name="f" id="f" action="${pageContext.request.contextPath} }/addTicketController" method="post">
<table id="table2">
<tr><td>선택영화</td><td>지역</td><td>상영지점</td><td>상영관</td><td>상영날짜</td><td>상영시간</td><td>종류</td><td>가격</td><td>좌석</td></tr>
<tr><td id="sel1"></td><td id="sel2"></td><td id="sel3"></td><td id="sel4"></td><td id="sel5"></td><td id="sel6"></td><td id="sel7"></td><td id="sel8"></td><td id="sel9"></td></tr>
</table>
</form>
</body>
</html>