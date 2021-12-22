<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//서블릿에서 수행결과 가져오기
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
%>

[
<%
	for(int i = 0; i < list.size(); i++){
		BoardVO vo = list.get(i);
		if(i > 0)out.print(",");
%>
	{
		"seq" : "<%= vo.getSeq() %>",
		"title" : "<%= vo.getSubject() %>",
		"name" : "<%= vo.getWriter() %>",
		"cont" : "<%= vo.getContent() %>",
		"hit" : "<%= vo.getHit() %>",
		"mail" : "<%= vo.getMail() %>",
		"date" : "<%= vo.getWdate() %>"
	}	
<%		
	}
%>
]
    
<%
    
%>