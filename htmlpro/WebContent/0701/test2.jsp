<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

   h1 { color : orange; }
   
   table { border : 3px solid black; 
         border-collapse: collapse;  }
   
   .first { text-align : center; 
          font-weight : bold;
          width : 100px; }
   
   td { width : 280px; 
        padding : 5px; } 
   
   


</style>

</head>
<body>

   <h1> JSP : Java Sever Page </h1>
   
   <%
   
      request.setCharacterEncoding("UTF-8");
   
      String uname = request.getParameter("name");
      String uid = request.getParameter("id");
      String upass = request.getParameter("pass");
      String ugend = request.getParameter("gender");
      String usec = request.getParameter("sec");
      String ufile = request.getParameter("file");
      
      String foods[] = request.getParameterValues("food"); /*여러개 받을 수 있는 checkbox라서 getParameterValues */
      
      

   %>
   
   <table border = "1">
   
      <tr>
         <td class="first"> 이름 </td>
         <td> <%= uname %> </td>
      </tr>
      
      <tr>
         <td class="first"> 아이디 </td>
         <td> <%= uid %> </td>
      </tr>
      
      <tr>
         <td class="first"> 비밀번호 </td>
         <td> <%= upass %> </td>
      </tr>
      
      <tr>
         <td class="first"> 성별 </td>
         <td> <%= ugend %> </td>
      </tr>
      
      <tr>
         <td class="first"> 히든 </td>
         <td> <%= usec %> </td>
      </tr>
            
     <br>
      <tr>
         <td class="first"> 첨부파일 </td>
         <td> <%= ufile %> </td>
      </tr>
      
      <tr>
         <td class="first"> 좋아하는 음식 </td>
         <td id = "food"> <% for(String food : foods) {
                           out.print(food + ", "); }%> </td>
                              
      </tr>
   
   
   
   </table>
   
</body>
</html>