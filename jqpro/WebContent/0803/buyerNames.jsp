<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
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
	List<BuyerVO> list = client.queryForList("buyer.buyerNames");    
%>


[
	<%
		for(int i=0; i<list.size(); i++){
			BuyerVO vo = list.get(i);
			
			if(i > 0) out.print(","); //배열에 하나만 있는게 아니잖아. 콤마찍어줘야 돼서 만든거야
	%>
			{
				"id" 		: "<%= vo.getBuyer_id() %>",
				"name"  	: "<%= vo.getBuyer_name() %>",
				"lgu"   	: "<%= vo.getBuyer_lgu() %>",
				"bank"  	: "<%= vo.getBuyer_bank() %>",
				"bankno"	: "<%= vo.getBuyer_bankno() %>",
				"bankname"  : "<%= vo.getBuyer_bankname() %>",
				"zip"	    : "<%= vo.getBuyer_zip() %>",
				"add1" 		: "<%= vo.getBuyer_add1() %>",
				"add2" 		: "<%= vo.getBuyer_add2() %>",
				"comtel"    : "<%= vo.getBuyer_comtel() %>",
				"mail" 		: "<%= vo.getBuyer_mail() %>"
			}
	<%
		}
	%>
]
