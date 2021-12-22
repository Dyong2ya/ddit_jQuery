<%@page import="kr.or.ddit.member.vo.JoinVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 실행되어 request에 저장된 결과를 가져온다
	List<JoinVO> list = (List<JoinVO>)request.getAttribute("list");
%>									
[
  <%
  	  for(int i= 0; i <list.size(); i++){
  		  JoinVO vo = list.get(i);
  		  if(i > 0) out.print(",");
  %>
  	  {
  	  	"id" : "<%= vo.getId() %>",
  	  	"name" : "<%= vo.getName() %>",
  	  	"email" : "<%= vo.getEmail()%>",
  	  	"hp" : "<%= vo.getHp()%>",
  	  	"bir" : "<%= vo.getBir()%>",
  	  	"addr1" : "<%= vo.getAdd1()%>",
  	  	"addr2" : "<%= vo.getAdd2()%>",
  	  	"zip" : "<%= vo.getZip()%>"
  	  }
  <%
  	  }
  %> 
]