<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트전송시 데이터 받는다
	
	//db를 이용해서 데이터 가져오기
	//1. SqlMapClient객체 얻어오기
	SqlMapClient client = SqlMapClientFactory.getInstance();
	
	//2. mapper수행 (namespace이름.id이름)
	List<MemberVO> list = client.queryForList("member.selectAllMember");
%>

[
	<%
		for(int i=0; i<list.size(); i++){
			MemberVO vo = list.get(i);
			
			String email = vo.getMem_email(); //* 이메일은 공백이 들어갈 수 있으니ㄲㅏ 이거 써주는거야
			if(email == null) email = ""; //*
			
			if(i > 0) out.print(","); //배열에 하나만 있는게 아니잖아. 콤마찍어줘야 돼서 만든거야
	%>
			{
				"id" : "<%= vo.getMem_id() %>",
				"name" : "<%= vo.getMem_name() %>",
				"addr" : "<%= vo.getMem_addr() %>",
				"tel" : "<%= vo.getMem_tel() %>",
				"email" : "<%= email %>"
			}
	<%
		}
	%>
]
