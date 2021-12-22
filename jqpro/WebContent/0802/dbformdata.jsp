<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jsp에서 ctrl + space바 눌러서 import 시킬 수 있다. --%>
<%
	//클라이언트 요청시(전송) 전송되는 데이터를 받아와야 한다
	String inId = request.getParameter("id");
	String inName = request.getParameter("name");
	String inAddr = request.getParameter("addr");
	String inTel = request.getParameter("tel");
	String inEmail = request.getParameter("email");
	
	//DB에 저장하기
	//1. SqlMapClient를 가져온다.
	SqlMapClient smc = SqlMapClientFactory.getInstance(); 

	//2. parameter생성 - 전송된 데이터를 VO에 담는다.(setter로 담는다)
	MemberVO vo = new MemberVO();
	vo.setMem_id(inId);
	vo.setMem_name(inName);
	vo.setMem_addr(inAddr);
	vo.setMem_tel(inTel);
	vo.setMem_email(inEmail);
	
	//3. 저장  - mapper를 실행(namespace이름.id이름)
	//저장 후 결과값을 리턴받는다
	String id = (String)smc.insert("member.insertMember", vo);
	if(id != null && id.equals(inId)){
		
		//출력 모양-html과 스타일-css
		//응답데이터를 생성 - json
%>
		{
			"id" : "<%= id %>님 성공하셨습니다"
		}

<%	}else{
		//출력 모양-html과 스타일-css
		//응답데이터를 생성 - json
%>

		{
			"id" : "<%= inId %>님 실패하셨습니다"
		}
<%
	}

%>