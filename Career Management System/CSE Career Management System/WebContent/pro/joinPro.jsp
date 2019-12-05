<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "account.Account" %>
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
	<jsp:useBean id = "mBean" class = "account.MemberBean"/>
	<jsp:setProperty property ="*" name = "mBean" />
	
	<% 
		Account acnt = new Account();
		acnt.makeAccount(mBean);
		//acnt.setUserName(mBean.getName());
		//System.out.printf("%s", acnt.getUserName());
		//acnt.makeAccount(mBean);
	%>
	 
	 <%--아이디 <%= memberBean.getId()%><br>
	 비밀번호 <%= memberBean.getPw()%><br>
	 사용자구분 <%= memberBean.getType()%><br>
	 이름 <%= memberBean.getName()%><br>
	 전공 <%= memberBean.getMajor()%><br>
	 트랙 <%= memberBean.getTrack()%><br>
	 학번/교직원번호 <%= memberBean.getIdNum()%><br> --%>
	 
	<jsp:forward page="../view/loginForm.jsp"/>
</body>
</html>