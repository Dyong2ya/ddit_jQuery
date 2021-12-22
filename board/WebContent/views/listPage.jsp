<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  //서블릿에서 결과값 가져오기
  		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
		int sp = (Integer)request.getAttribute("startPage");
		int ep = (Integer)request.getAttribute("endPage");
		int tp = (Integer)request.getAttribute("totalPage");
%>
{
  "spage" : "<%= sp %>",
  "epage" : "<%= ep %>",
  "tpage" : "<%= tp %>",
  "datas" : [
  <%
  	  for(int i=0; i<list.size(); i++){
		BoardVO vo = list.get(i);
		if(i>0) out.print(",");
  %>  {
  	    "seq" : "<%= vo.getSeq() %>",
		"title" : "<%= vo.getSubject() %>",
		"name" : "<%= vo.getWriter() %>",
		"cont" : "<%= vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>",
		"hit" : "<%= vo.getHit() %>",
		"mail" : "<%= vo.getMail() %>",
		"date" : "<%= vo.getWdate() %>"
  	  }
  
  <%  } 
  %>	
  ]
}