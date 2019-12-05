<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컴퓨터학부 학생경력관리 시스템 - 회원가입</title>
<style>
#title { width : 350px; height : 90px; margin : auto; margin-top : 3%; text-align: center; font-size : 12pt;}
#text { text-align : center; width : 140px; height : 30px; color : white; font-size : 10pt; background : #1D397A;}
#info { width : 300px; height : 30px; background : #9BA4BD; font-size : 10pt; padding-left : 3%; border : none;}
#button { border : none; width : 50px; height : 30px; font : bold; font-size : 8pt; border-radius: 0.3em;}
input:focus { outline : none; }
</style>
<script>
	var f_selbox = new Array('심화컴퓨터공학', '글로벌SW융합', 'SW융햡/연계');

	var s_selbox = new Array();
	s_selbox[0] = new Array('없음');
	s_selbox[1] = new Array('다중전공', '해외복수학위', '학석사연계');
	s_selbox[2] = new Array('연계전공', '융합전공', '복수전공', '부전공');

	// 이거 고치기

	function newSelbox(e) {
		var target = document.getElementsByName("track")[0];

		if (e.value == "심화컴퓨터공학") {
			target.disabled = true;
		}
		else {
			if (e.value == "글로벌SW융합")
				var d = s_selbox[1];
			else if (e.value == "SW융합/연계")
				var d = s_selbox[2];

			for (x in d) {
				var opt = document.createElement("option");
				opt.value = d[x];
				opt.innerHTML = d[x];
				target.appendChild(opt);
			}
		}
	}

	var currentValue = 0;
	function checkType(myRadio) {
		currentValue = myRadio.value;

		var mjr = document.getElementsByName("major")[0];
		var tck = document.getElementsByName("track")[0];

		if (currentValue == "admin") {
			//mjr.setAttribute("disabled");
			//tck.setAttribute("disabled");
			mjr.value = tck.value = "none";
			mjr.disabled = true;
			tck.disabled = true;
		} else {
			mjr.value = tck.value = "none";
			mjr.disabled = false;
			tck.disabled = false;
		}
	}
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
		
		if (currentValue == "관리자") {
			var mjr = document.getElementsByName("major")[0];
			var tck = document.getElementsByName("track")[0];
			
			//mjr.value = "none";
			//tck.value = "none";
			mjr.removeAttribute("disabled");
			tck.removeAttribute("disabled");
			mjr.value = tck.value = "none";
		} else {
			if (!document.userInfo.major.value) {
				alert("전공을 선택해주세요.");
				return false;
			} else if (!document.userInfo.track.value) {
				alert("트랙을 선택해주세요.");
				return false;
			} else if (document.userInfo.major.value == "심화컴퓨터공학") {
				var tck = document.getElementsByName("track")[0];
				tck.removeAttribute("disabled");
				tck.value = "none";
			}
		}
		
		/*alert(document.getElementsByName("id")[0].value);
		alert(document.getElementsByName("pw")[0].value);
		alert(document.getElementsByName("pwcheck")[0].value);
		alert(document.getElementsByName("type")[0].value);
		alert(document.getElementsByName("name")[0].value);
		alert(document.getElementsByName("major")[0].value);
		alert(document.getElementsByName("track")[0].value);
		alert(document.getElementsByName("idNum")[0].value);*/
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
				<td id = "info"><input type = "radio" name = "type" value = "student" onclick = "checkType(this);">학생
					<input type = "radio" name = "type" value = "admin" onclick = "checkType(this);">관리자
				</td>
			</tr>
			<tr>
				<td id = "text">이름</td>
				<td id = "info"><input type = "text" name = "name" style = "width : 130px"></td>
			</tr>
			<tr>
				<td id = "text">전공트랙</td>
				<td id = "info"><select name = "major" onchange = "newSelbox(this)" style = "width : 134px;">
						<option value = "none">--전공선택--</option>
						<option value = "심화컴퓨터공학">심화컴퓨터공학</option>
						<option value = "글로벌SW융합">글로벌SW융합</option>
						<option value = "SW융합/연계">SW융합/연계</option>
					</select>
					<select name = "track" style = "width : 134px;">
						<option value = "none">--트랙선택--</option>
					</select>
				</td>
			</tr>
			<tr>
				<td id = "text">학번/교직원번호</td>
				<td id = "info"><input type = "text" name = "idNum" style = "width : 130px"></td>
			</tr>
		</table>
		<br><br>
		<table align = "center">
			<tr>
				<td><input type="submit" value="가입" id = "button"/></td>
				<td><input type="button" value="취소" id = "button" onclick="goLoginForm()"></td>
			</tr>	
		</table>
	</form>
</body>
</html>