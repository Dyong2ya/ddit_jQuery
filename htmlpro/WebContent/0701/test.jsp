<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 h1{
   color : red;
 }
 strong{
   color : blue;
   font-size : 2.0em;
 }
 em{
   color : green;
   font-size : 1.5em;
 }
 p{
   font-size : 1.3em;
 }

</style>
</head>
<body>
	<h1>JSP : JAVA Server page </h1>
	
	<h2> 서버에서 실행되는 java프로그램</h2>
	<h2>클라이언트에서 입력한 정보를 받아온다</h2>
	<p>request객체를 통해서 입력한 정보를 얻는다</p>
	<p>String userName = request.getParameter("name")</p>
	<p>String userAddr = request.getParameter("addr")</p>
	
	<p>out객체를 통해서 출력한다</p>
	<p>out.print(userName + "님 환영합니다")</p>
	<p>out.print(userAddr + "에 사시는 군요~~~")</p>
	
	jsp는 java언어를 이용하여 비즈니스 로직처리를 할 수 있다.<br>
	java언어를 사용하기 위해서 &lt;%  %&gt; 기호 안에 기술한다.<br>
	
	<%
	
	request.setCharacterEncoding("UTF-8");
	
	String userName = request.getParameter("name");
	String userAddr = request.getParameter("addr");
	
	out.print("<strong>" + userName + "님 환영합니다</strong><br>");
	out.print("<em>" + userAddr + "에 사시는 군요~~~</em>");
	%>
	

</body>
</html>