<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>JSP : Java Server Page</h1>
  
  <%
    String aa[] = request.getParameterValues("food"); //select지 option이 아니야. 그래서 for문 다시 돌아
    
    String str="";
    for(int i=0; i<aa.length; i++){
    	str += aa[i] + " ";  /*str말고 aa하면 그냥 주소만 나와*/
    }
    //out.print(aa);/*스타일주고 싶으면 밑에다 태그 붙여서 <%% 이거 또 하는거야 . 아니면 ↓*/
   // out.print("<p>" + aa + "</p>");
  %>
  <p><%= str %></p>
</body>
</html>