<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/mystyle.css">
</head>
<body>
<pre>
  
  문자변경하기
  replaceAll('old문자','new문자')
  
  클라이언트에서 받은 area소개글의 엔터기호(\r\n) 문자를 &lt;br>태그문자로 변경한다.
</pre>

  <%
    request.setCharacterEncoding("UTF-8");
  
    String userName = request.getParameter("name");
    String area = request.getParameter("area");
    
    area = area.replaceAll("\r", "").replaceAll("\n", "<br>");
  %>
  
  이름 <%= userName %> <!--출력--><br><br>
  
  소개<br>
  <%= area %>
</body>
</html>












