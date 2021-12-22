<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//클라이언트전송시 데이터 받는다
	
	//db를 이용해서 데이터 가져오기
	//1. SqlMapClient객체 얻어오기
	SqlMapClient client = SqlMapClientFactory.getInstance();
	
	//2. mapper수행 (namespace이름.id이름)
	List<LprodVO> list = client.queryForList("lprod.selectLprod");
%>   

 [
	<%
		for(int i=0; i<list.size(); i++){
			LprodVO vo = list.get(i);

			if(i > 0) out.print(","); //배열에 하나만 있는게 아니잖아. 콤마찍어줘야 돼서 만든거야
	%>
			{
				"id" : "<%= vo.getLprod_id() %>",
				"gu" : "<%= vo.getLprod_gu() %>",
				"name" : "<%= vo.getLprod_nm() %>"
			}
	<%
		}
	%>
]
 