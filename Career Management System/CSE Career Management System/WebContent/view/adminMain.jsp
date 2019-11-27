<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 컴퓨터학부 학생경력관리 시스템</title>
<style>
body {margin : auto 0;}
#home { float : left; background-color : #072367; width : 12%; height : 110px;}
#info {width : 88%; height : 45px; float : left; background-color : #1D397A; margin-top : 0px; margin-left : 0px;}
#text { background-color : #1D397A; color : white; font : bold; font-size: 8pt; display : inline-block; padding-left : 500px; padding-top : 1%; }
#menu {float : left; width : 88%; height : 65px; background-color : #9BA4BD; color : #121C4C; font : bold; font-size : 11pt; }
#btn { color : white; border : none; height : 20px; font : bold; font-size : 8pt; border-radius: 0.3em;}
#select { font-size : 8pt; }
a, a:link, a:hover, a:visited { color : #121C4C; text-decoration : none; font-style : bold; font-size : 13px; }
input:focus { outline : none; }
</style>
</head>
<body>
	<% 
		if (session.getAttribute("sessionID") == null) { // 로그인이 안되었을 경우
			response.sendRedirect("./loginForm.jsp");
		}
		else {
	%>
	<div id = "home">
		<a href = "./adminMain.jsp"><img src = "../img/컴퓨터학부.png" width = "130" height = "50" style = "padding-top: 30px; padding-left : 13px;"></a>
	</div>
	<div id = "info">
		<span id = "text">
			<font color = "white"><%=session.getAttribute("sessionID") %></font> &nbsp;&nbsp;&nbsp;&nbsp; 
			<input type ="button" id = "btn" value = "로그아웃" onClick = "logoutPro()" style = "background : #E39801; width : 60px;">
			<input type ="button" id = "btn" value = "비밀번호 변경" style = "background : #5F4918; width : 100px;"> &nbsp;&nbsp;
			Language : 
			<select name = "lang" id = "select">
				<option value = "ko">Korean</option>
				<option value = "en">English</option>
			</select>
		</span>
	</div>
	<div id = "menu">
		<span style = "display : inline-block; padding-left : 2%; padding-top : 2%;">
			<a href = "../navigation/manageReq.jsp" target = "list" >졸업요건 관리</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
			<a href = "../navigation/manageQna.jsp" target = "list">Q&A</a>
		</span>
	</div>

	<iframe src = "../navigation/courseGrade.jsp" name = "list" width = "12.5%" height = "300vh" style = "border : none; float : left;"></iframe>

	<iframe src = "./home.html" name = "result" width = "71%" height = "700px" style = "border : none;" scrolling = "no"></iframe>
	<%} %>
</body>
</html>