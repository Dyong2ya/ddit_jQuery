<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=""stylesheet" href="../css/myStyle.css">

<style>
  p{
    font-size : 1.5em;
  }
</style>
</head>
<body>
<pre>
클라이언트 전송 데이터는 
String em1 = request.getParameter("email1")

결과를 출력 시 
  &lt;%= &gt;
</pre>
<%

request.setCharacterEncoding("utf-8");
String em1 = request.getParameter("email1");
String em2 = request.getParameter("email2");

String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
%>

<p> 이메일 : <%= em1 %> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<%= em2 %> </p>
<p> 전화번호 : <%= tel1 %> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<%= tel2 %></p>
</body>

</html>