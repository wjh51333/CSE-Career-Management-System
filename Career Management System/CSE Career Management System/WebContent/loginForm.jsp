<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>컴퓨터학부 학생경력관리 시스템</title>
<style>
body { font-family : "DINRegular", "윤고딕540"; }
#title { font-size : 13pt; font : bold; text-align : center;}
#text { font-size : 8pt; } 
#info { width : 150px; height : 15px; padding-left : 1%; padding-top : 4%; }
#login { width: 70px; height : 60px; background : #042D96; font-size : 10pt; color : #ffffff;  border : none; border-radius : 0.1em;}
a, a:link, a:hover, a:visited { color : #000000; text-decoration : none; font-style : bold; font-size : 7pt; }
</style>
</head>

<body>
 <div>
    <br><br>
    <table align = "center" hegiht = "90">
        <tr>
            <td align = "center"><img src = "CSE.png" width = 160 height = 160><p id = "title">컴퓨터학부 학생경력관리 시스템<br>CSE Career Management System</p></td>
        </tr>
    </table>
    <br>
    <form method = "post" action = "./loginPro.jsp">
    	<table align = "center" height = "40" width = "300" id = "ext">
       	<tr>
       		<td rowspan = "2"><img src = "login.png" width = "150" height = "150"></td>
        	<td rowspan = "2" style = "width : 300px;"> 
                <span id = "text">아이디</span>  &nbsp;&nbsp;&nbsp; <input type="text" name="id" placeholder="아이디" id="info">
        	    <br> <span id = "text">비밀번호</span> &nbsp; <input type = "password" name = "pw" id = "info"> </td>
        	<td rowspan = "2"><input type="submit" name="login" value="로그인" id="login"></td>
       	</tr>
    	</table>
    </form>
    <table align = "center" height = "50" style = "margin-top : 1%;">
        <tr>
            <td><a href = "">아이디 찾기 &nbsp;| &nbsp;</td>
            <td><a href = "">비밀번호 찾기 &nbsp;| &nbsp;</td>
            <td><a href = "">회원가입</td>
        </tr>
    </table>
    </div>
</body>
</html>