<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- jsp는 지정된 name을 가져와서 사용한다 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
img{
  width: 400px;
  height: 400px;
}
</style>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");

  String userId = request.getParameter("id");
  String userName = request.getParameter("pass");
  
  //db처리
%>
  <img src="../images/스티치.png"><br><br>
  <%= userId %>님 환영합니당!-3-
</body>
</html>