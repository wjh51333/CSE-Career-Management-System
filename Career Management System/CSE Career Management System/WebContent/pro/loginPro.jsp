<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "account.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리 JSP</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 아이디, 비밀번호 확인
	Account acnt = new Account();
	int check = acnt.logIn(id, pw);
	
	String msg = "";
	
	if (check == 0) { // 학생 로그인
		session.setAttribute("sessionID", id);
		// 학생인지 관리자인지 판단 후 페이지 띄워주기
		msg = "../view/studentMain.jsp";
	}
	else if (check == 1) { // 관리자 로그인
		session.setAttribute("sessionID", id);
		msg = "../view/adminMain.jsp";
	}
	else { // 로그인 실패
		msg = "../view/loginForm.jsp?msg=-1";
	}
	
	response.sendRedirect(msg);
 %>
</body>
</html>