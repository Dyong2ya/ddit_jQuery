<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%
	//클라이언트 전송 시 데이터를 받는다.
	String valueid = request.getParameter("id");

	//db처리
	//1. SqlMapClient객체 얻어오기
	SqlMapClient client = SqlMapClientFactory.getInstance();
	
	//2. mapper수행 (namespace이름.id이름)
	BuyerVO vo = (BuyerVO)client.queryForObject("buyer.buyerDetail", valueid);
	
	//3. 응답데이터 생성 - html
%>

<table class="table table-bordered">
 <tr>
 	<td>BUYER_ID</td>
 	<td><%= vo.getBuyer_id()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_NAME</td>
 	<td><%= vo.getBuyer_name()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_LGU</td>
 	<td><%= vo.getBuyer_lgu()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_BANK</td>
 	<td><%= vo.getBuyer_bank()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_BANKNO</td>
 	<td><%= vo.getBuyer_bankno()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_BANKNAME</td>
 	<td><%= vo.getBuyer_bankname()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_ZIP</td>
 	<td><%= vo.getBuyer_zip()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_ADDR1</td>
 	<td><%= vo.getBuyer_add1()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_ADDR2</td>
 	<td><%= vo.getBuyer_add2()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_COMTEL</td>
 	<td><%= vo.getBuyer_comtel()%></td>
 </tr>
 
 <tr>
 	<td>BUYER_MAIL</td>
 	<td><%= vo.getBuyer_mail()%></td>
 </tr>

</table>