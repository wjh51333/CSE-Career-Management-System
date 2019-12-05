<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>컴퓨터학부 학생경력관리 시스템</title>
<style>
body { font-family : "DINRegular", "윤고딕540";}
#title { font-size : 13pt; font : bold; text-align : center;}
#info { width : 150px; height : 20px; border : 1px bold gray; }
#login { width: 70px; height : 60px; background : #042D96; font-size : 10pt; color : #ffffff;  border : none; border-radius : 0.1em;}
#box { width : 400px; height : 150px; border : 0.1em inset #616161; background : white;  margin : auto; border-radius : 0.5em;}
a, a:link, a:hover, a:visited { color : #000000; text-decoration : none; font-style : bold; font-size : 7pt; }
input:focus { outline : none;}
</style>

<script>
    function checkValue(){
        inputForm = eval("document.loginInfo");

        if (!inputForm.id.value) {
            alert("아이디를 입력하세요.");
            inputForm.id.focus();
            return false;
        }

        if (!inputForm.pw.value) {
            alert("비밀번호를 입력하세요.");
            inputForm.pw.focus();
            return false;
        }
    }
</script>
</head>

<body>
<div>
    <br><br>
    <table align = "center" hegiht = "90">
        <tr>
            <td align = "center"><img src = "../img/CSE.png" width = "160" height = "160">
                <p id = "title">컴퓨터학부 학생경력관리 시스템<br>CSE Career Management System</p></td>
        </tr>
    </table>
    <div id = "box">
    <form method = "post" action = "../pro/loginPro.jsp" name = "loginInfo" onsubmit="return checkValue()">
    	<table align = "center" height = "40" width = "300" style = "padding-top : 7%;">
       	<tr>
       		<td rowspan = "2"> 
                <span style = "font-size : 8pt;">아이디</span> <input type="text" name="id" id="info" style = "margin-left : 11%;">
        	    <br> <span style = "font-size : 8pt;">비밀번호</span> <input type = "password" name = "pw" id = "info" style = "margin-top : 3%; margin-left : 6%;"> </td>
        	<td rowspan = "2"><input type="submit" name="login" value="로그인" id="login"></td>
       	</tr>
    	</table>
    </form>
    <table align = "center" height = "50" style = "margin-top : 1%; font-size : 8pt;">
        <tr>
            <td><a href = "">아이디 찾기 &nbsp;| &nbsp;</td>
            <td><a href = "">비밀번호 찾기 &nbsp;| &nbsp;</td>
            <td><a href = "./joinForm.jsp">회원가입</td>
        </tr>
    </table>
    </div>
    
    <%
    	String msg = request.getParameter("msg");
    
    	if (msg != null && msg.equals("-1")) {
    		out.println("<script>alert('아이디와 비밀번호를 확인해주세요.');</script>");
    	}
    %>
</div>
</body>
</html>