<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컴퓨터학부 학생경력관리 시스템 - 회원가입</title>
<style>
#title { width : 350px; height : 90px; margin-left : 35%; margin-top : 3%; text-align: center; font-size : 12pt;}
#text { text-align : center; width : 140px; height : 30px; color : white; font-size : 10pt; background : #1D397A;}
#info { width : 250px; height : 30px; background : #9BA4BD; font-size : 10pt; padding-left : 3%; border : none;}
#button { border : none; width : 50px; height : 30px; font : bold; font-size : 8pt; border-radius: 0.3em;}
input:focus { outline : none; }
</style>
<script>
	function checkValue() {
		if (!document.userInfo.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if (!document.userInfo.pw.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if (document.userInfo.pw.value != document.userInfo.pwcheck.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
	}
	
	function goLoginForm() {
		location.href = "./loginForm.jsp";
	}
</script>
</head>
<body>
	<div id = "title">
	<img src = "../img/CSE.png" width = "90" height = "90" align = "left" style = "padding-top : 4px;"><br>
	컴퓨터학부 학생경력관리 시스템 <br>
	CSE Career Management System
	</div>
	<br><br>

	<form method = "post" action = "../pro/joinPro.jsp" name = "userInfo" onsubmit = "return checkValue()">
		<table align = "center">
			<tr>
				<td id = "text">아이디</td>
				<td id = "info"><input type = "text" name = "id" style = "width : 130px"></td>
			</tr>
			<tr>
				<td id = "text">비밀번호</td>
				<td id = "info"><input type = "password" name = "pw" style = "width : 130px"></td>
			</tr>
			<tr>
				<td id = "text">비밀번호 확인</td>
				<td id = "info"><input type = "password" name = "pwcheck" style = "width : 130px"></td>
			</tr>
		</table>
		<br>
		<table align = "center">
			<tr>
				<td id = "text">사용자 구분</td>
				<td id = "info"><input type = "radio" name = "type" value = "학생" >학생
					<input type = "radio" name = "type" value = "관리자">관리자
				</td>
			</tr>
			<tr>
				<td id = "text">이름</td>
				<td id = "info"><input type = "text" name = "name" style = "width : 130px"></td>
			</tr>
			<tr>
				<td id = "text">전공트랙</td>
				<td id = "info"><select name = "track" style = "width : 134px;">
						<opt>심화컴퓨터공학</opt>
						<opt>글로벌SW융합</opt>
						<opt>SW융합/연계</opt>
					</select>
				</td>
			</tr>
			<tr>
				<td id = "text">학번/교직원번호</td>
				<td id = "info"><input type = "text" name = "idNum" style = "width : 130px"></td>
			</tr>
		</table>
		<br><br>
		<div style = "margin-left : 46%;">
			<input type="submit" value="가입" id = "button"/>  
			<input type="button" value="취소" id = "button" onclick="goLoginForm()">	
		</div>
	</form>
</body>
</html>