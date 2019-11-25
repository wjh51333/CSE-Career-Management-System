<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컴퓨터학부 학생경력관리 시스템</title>
<style>
body {margin : auto 0;}
#home { float : left; background-color : #072367; width : 12%; height : 110px;}
#info {width : 88%; height : 45px; float : left; background-color : #1D397A; margin-top : 0px; margin-left : 0px;}
#text { background-color : #1D397A; color : white; font : bold; font-size: 8pt; display : inline-block; padding-left : 500px; padding-top : 1%; }
#menu {float : left; width : 88%; height : 65px; background-color : #9BA4BD; color : #121C4C; font : bold; font-size : 11pt; }
#button { color : white; border : none; height : 20px; font : bold; font-size : 8pt; border-radius: 0.3em;}
#select { font-size : 8pt; }
a, a:link, a:hover, a:visited { color : #121C4C; text-decoration : none; font-style : bold; font-size : 13px; }
</style>
</head>
<body>
	<div id = "home">
		<img src = "컴퓨터학부.png" width = "130" height = "50" style = "padding-top: 30px; padding-left : 13px;">
	</div>
	<div id = "info">
		<span id = "text">
			이름 (아이디 / 학번) &nbsp;&nbsp;&nbsp;&nbsp; 
			<button id = "button" style = "background-color : #E39801; width : 60px;">로그아웃</button> &nbsp;
			<button id = "button" style = "background-color : #5F4918; width : 100px;">비밀번호 변경</button> &nbsp;&nbsp;
			Language : 
			<select name = "lang" id = "select">
				<option value = "한국어">Korean</option>
				<option value = "영어">English</option>
			</select>
		</span>
	</div>
	<div id = "menu">
		<span style = "display : inline-block; padding-left : 2%; padding-top : 2%;">
			<a href = "courseGrade.jsp" target = "result" >이수성적</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
			<a href = "creditStatus" target = "result">충족현황</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
			<a href = "requirements.jsp" target = "result">졸업요건</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
			<a href = "qna.jsp" target = "result">Q&A</a>
		</span>
	</div>

	<iframe src = "courseGrade.jsp" name = "result" width = "90%" height = "350" border-color = "#359099"></iframe>

</body>
</html>