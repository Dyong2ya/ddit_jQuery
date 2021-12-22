<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//클라이언트 전송 시 데이터를 받는다.
	String valueid = request.getParameter("id");

	//db처리
	//1. SqlMapClient객체 얻어오기
	SqlMapClient client = SqlMapClientFactory.getInstance();
	
	//2. mapper수행 (namespace이름.id이름)
	BuyerVO vo = (BuyerVO)client.queryForObject("buyer.buyerDetail", valueid);
	
	//3. 응답데이터 생성 - json
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

%>