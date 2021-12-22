<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <% /*자바에서 가져오는 거라 여기 안에 넣어주는 거고 타입도 써줘야돼*/
    String vprice = request.getParameter("price");
    String vsu =request.getParameter("su");
    
    int result = Integer.parseInt(vprice) * Integer.parseInt(vsu);
    
    /*아웃점프린트해줘도 되고 밑에 내려가서<% % 해도돼*/
  %>
  
  가격 : <%= vprice%> <br>
  수량 : <%= vsu %><br>
  
  <br>
  결과 : <%= result %>
</body>
</html>