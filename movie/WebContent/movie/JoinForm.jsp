<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
// 	if('${error}'!=null||'${error}'!=""){
// 		alert('${error}');
// 	}
	$("#backLoginForm").click(function() {
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=loginForm.jsp";
	});
	
	$(".radio1").click(function() {
		var checkedValue = $(this).val();
		var str="";
		if(checkedValue==1){
			$("#append").attr("style", "display:none");
		}else if(checkedValue==2){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath }/areaAllListController",
				success:function(data){
					 	var arr=eval("("+data+")");
						var str="<select name=area id=area style=width:80%;height:40px;font-size:20px>";
						str+="<option value=0>선택</option>";
						for(i=0;i<arr.length;i++){
							str+="<option value="+arr[i].name+">"+arr[i].name+"</option>";
						}
						str+="</select>";
						$("#append").attr("style", "");
						$("#append").html(str);
				}
			});
			}
		else{
		}
	});
	
	$("#submit").click(function() {
		var cnt=0;
		var id=$("#id").val();
		var pwd=$("#pwd").val();
		var pwdCheck=$("#pwdCheck").val();
		var name=$("#name").val();
		var age=$("#age").val();
		var tel=$("#tel").val();
		var address=$("#address").val();
		var type=$("input:radio[name=type]:checked").val();
		var area=$("#area").val();
		var accept=$("input:radio[name=accept]:checked").val();
		if(id==null || id=="" ){
			alert("아이디를 입력해주세요");
		}else{
			cnt++;
		}
		
		if(id.length<7 ||id.length>15){
			alert(id+": id는 7자리 이상 15자리 이하");
			--cnt;
		}
		
		if(pwd==null || pwd=="" ){
			alert("비밀번호를 입력해주세요");
			--cnt;
		}else{
			cnt++;
		}
		
		if(pwd.length<7 ||pwd.length>15){
			alert("pwd는 7자리 이상 15자리 이하");
			--cnt;
		}
		
		if(pwdCheck!=pwd){
			alert("비밀번호가 맞지않습니다");
			--cnt;
		}
		
		if(name==null || name=="" ){
			alert("이름을 입력해주세요");
			--cnt;
		}else{
			cnt++;
		}
		
		if(age==null || age=="" ){
			alert("나이를 입력해주세요");
			--cnt;
		}else{
			cnt++;
		}
		
		if(tel==null || tel=="" ){
			alert("전화번호를 입력해주세요");
			--cnt;
		}else{
			cnt++;
		}
		if(address==null || address=="" ){
			alert("주소를 입력해주세요");
			--cnt;
		}else{
			cnt++;
		}
		
		if(type==null || type=="" ){
			alert("타입을 입력해주세요");
			--cnt;
		}else{
			cnt++;
			if(type==1){
				cnt++;
			}else {
				if(area==null || area==""){
					alert("지역을 입력하세요");
					--cnt;
				}else{
					cnt++;
				}
			}
		}
				
		
		if(accept==null ||accept==""){
			alert("가입약관 동의를 해주세요");
			--cnt;
		}else{
			if(accept==3){
				cnt++;	
			}else{
				alert("가입약관 동의를 해주세요");
				--cnt;
			}
		}
		
		
		if(cnt>=9){
			$("#submit").attr("type","submit");
			}else{
				cnt=0;
			}
	});
	
	$("#idDoubleCheck").click(function() {
		var id=$("#id").val();
		var param="id="+id;
		var html="";
		 $.ajax({
			 type:"POST",
			 url:"${pageContext.request.contextPath }/getMemberController",
			 data:param,
			 success:function(data){
				 var m=eval("("+data+")");
				 if(id==m.id){
					 html+="사용불가능";
				 }else{
					 html+="사용가능";
				 }
				 $("#idCheckResult").html(html);
			 }
		 });
	});
 });
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h1>회원가입</h1>
<form name="f" id="f" action="${pageContext.request.contextPath }/addMemberController" method="post">
<table border="1" style="width:600px;;margin:auto;border:2px dashed #1E96FF;font-size:20px">
<tr class="tr3"><td class="td3">아이디</td><td class="td4"><input type="text" id="id" name="id" placeholder="아이디 입력" class="td4" border="0" style="height:50px"></td>
<tr><td class="td3">아이디 중복 체크</td><td><input type="button" id="idDoubleCheck" value="아이디중복체크"><span class="td4" id="idCheckResult"></span></td></tr>
<tr class="tr3"><td class="td3">비밀번호</td><td class="td4"><input type="password" id="pwd" name="pwd" placeholder="비밀번호 입력" class="td4" border="0" style="height:50px"></td></tr>
<tr class="tr3"><td class="td3">비밀번호 재입력</td><td class="td4"><input type="password" id="pwdCheck" name="pwdCheck" placeholder="비밀번호 재입력" class="td4" border="0" style="height:50px"></td></tr>
<tr class="tr3"><td class="td3">이름</td><td class="td4"><input type="text" id="name" name="name" placeholder="이름 입력" class="td4" border="0" style="height:50px"></td></tr>
<tr class="tr3"><td class="td3">나이</td><td class="td4"><input type="text" id="age" name="age" placeholder="나이 입력" class="td4" border="0" style="height:50px"></td></tr>
<tr class="tr3"><td class="td3">전화번호</td><td class="td4"><input type="text" id="tel" name="tel" placeholder="전화번호 입력" class="td4" border="0" style="height:50px"></td></tr>
<tr class="tr3"><td class="td3">주소</td><td class="td4"><input type="text" id="address" name="address" placeholder="주소 입력" class="td4" border="0" style="height:50px"></td></tr>
<tr class="tr3"><td class="td3">가입유형</td>
<td class="td4"><input type="radio" value="1" name="type" class="radio1">고객&nbsp&nbsp&nbsp&nbsp<input type="radio" value="2" name="type" class="radio1">직원</td></tr>
<tr id="append" style="display:none"></tr>
<tr class="tr3"><td class="td3">가입약관</td><td><iframe src="${pageContext.request.contextPath }/movie/joinAccept.jsp" style="width:350px;height:200px"></iframe></td></tr>
<tr class="tr3"><td class="td3">약관 동의</td>
<td class="td4"><input type="radio" value="3" name="accept" class="radio2">동의&nbsp&nbsp&nbsp&nbsp<input type="radio" value="4" name="accept" class="radio2">미동의</td></tr>
<tr>
<td border="0" style="text-align:center" colspan="2"><input type="button" id="submit" value="회원가입" style="background-color:#1E96FF;width:150px;height:100px" ><input type="button" id="backLoginForm" value="돌아가기" style="background-color:#1E96FF;width:150px;height:100px"></td>
</table>
</form>
</body>
</html>