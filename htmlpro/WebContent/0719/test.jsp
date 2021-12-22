<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
span{
  font-size : 2.0em;
}
#sp1{
  color : blue;
}
#sp2{
  color : red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("name");
%>

<span id="sp1"> <%= username %>님</span>
<span id="sp2">환영합니다</span>
</body>
</html>