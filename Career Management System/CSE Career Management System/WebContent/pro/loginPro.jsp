<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	//MemberDAO dao = MemberDAO.getInstance();
	//int check = dao.loginCheck(id, pw);
	int check = 1;
	
	String msg = "";
	
	if (check == 1) {
		session.setAttribute("sessionID", id);
		
		// 학생인지 관리자인지 판단 후 페이지 띄워주기
		msg = "../view/studentMain.jsp";
		msg = "../view/adminMain.jsp";
	}
	else if (check == 0) { // 비밀번호가 틀릴 경우
		msg = "../view/loginForm.jsp?msg=0";
	}
	else { // 아이디가 틀릴 경우
		msg = "../view/loginForm.jsp?msg=-1";
	}
	
	response.sendRedirect(msg);
 %>
</body>
</html>