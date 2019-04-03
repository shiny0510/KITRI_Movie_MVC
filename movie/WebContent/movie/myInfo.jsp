<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="member.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#backLoginForm").click(function() {
		location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=mainDown.jsp";
	});
	$("#del").click(function() {
		var result=confirm("탈퇴하시겠습니까?");
		if(result){
			$("#f").attr("action","${pageContext.request.contextPath }/delMemberController");
			$("#f").submit();
		}
		else{
			location.href="${pageContext.request.contextPath }/movie/Main.jsp?sub=myInfo.jsp";
		}
	});
	
	$("#edit").click(function() {
		var pwd=$("#pwd").val();
		var pwd1=pwd+"1";
		var pwdCheck=$("#pwdCheck").val();
		
			if(pwd1=="1"){
				$("#f").attr("action","${pageContext.request.contextPath }/editMemberController");
				$("#f").submit();
			}else{
				if(pwd.length<7||pwd.length>15){
					alert("pwd는 7자리 이상 15자리 이하");	
				}else{
					if(pwd==pwdCheck ){
						$("#f").attr("action","${pageContext.request.contextPath }/editMemberController");
						$("#f").submit();
					}else{
						alert("비밀번호가 다릅니다.");
					}
				}
			}
	});
});
</script>
</head>
<body>
<img src="${pageContext.request.contextPath }/img/cinema.png" style="width:100%">
<h1>${sessionScope.id }님 정보보기</h1>
<form name="f" id="f" action="" method="post">
<table border="1" style="width:600px;;margin:auto;border:2px dashed #1E96FF;font-size:20px">
<tr class="tr3"><td class="td3">아이디</td><td class="td4"><input type="text" id="id" name="id" value="${sessionScope.id }" class="td4" border="0" style="height:50px" readonly></td>
<tr class="tr3"><td class="td3">비밀번호 수정</td><td class="td4"><input type="password" id="pwd" name="pwd" class="td4" border="0" style="height:50px" value=""></td></tr>
<tr class="tr3"><td class="td3">비밀번호 재입력</td><td class="td4"><input type="password" id="pwdCheck" name="pwdCheck" class="td4" border="0" style="height:50px" value=""></td></tr>
<tr class="tr3"><td class="td3">전화번호</td><td class="td4"><input type="text" id="tel" name="tel" placeholder="전화번호 입력" class="td4" border="0" style="height:50px" value="${m.getTel()}"></td></tr>
<tr class="tr3"><td class="td3">주소</td><td class="td4"><input type="text" id="address" name="address" placeholder="주소 입력" class="td4" border="0" style="height:50px" value="${m.getAddress()}"></td></tr>
<tr class="tr3" style="display:none"><td class="td3">포인트</td><td class="td4"><input type="text" name="point" value="0" readonly class="td4" border="0" style="height:50px"></td></tr>
<td border="0" style="text-align:center" colspan="2">
<input type="button" id="edit" value="수정하기" style="background-color:#1E96FF;width:150px;height:100px" >
<input type="button" id="del" value="탈퇴하기" style="background-color:#1E96FF;width:150px;height:100px" >
<input type="button" id="backLoginForm" value="돌아가기" style="background-color:#1E96FF;width:150px;height:100px"></td>
</table>
</form>
</body>
</html>