<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 필요한 클래스 import --%>
<%-- page import="jsp.member.model.MemberBean" --%>
<%-- 필요한 클래스 import2 --%>
<%-- page import="jsp.member.mode.MemberDAO" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리 JSP</title>
</head>
<body>
	<%-- joinForm.jsp에서 입력한 정보를 넘겨 받아 처리한다. --%>
	<%
		request.setCharacterEncoding("utf-8");
	 %>
	 
	<%-- 자바빈 관련 액션태그 사용 --%>
	<jsp:useBean id = "account" class = "Account.Account"/>
	<jsp:setProperty property ="*" name = "userAccount" />
	<%
		MemberDAO dao = MemberDAO.getInstance();
		
	 %>
	
</body>
</html>