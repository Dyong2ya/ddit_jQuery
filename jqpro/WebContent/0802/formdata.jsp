<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //클라이언트 요청시(전송) 전송되는 데이터를 받아와야 한다
  String inId = request.getParameter("id");
  String inName = request.getParameter("name");
  String inAddr = request.getParameter("addr");
  String inTel = request.getParameter("tel");
  String inEmail = request.getParameter("email");
  
  //DB에 저장하기
  //저장 후 결과값을 리턴받는다
  //응답데이터를 생성 - json, xml, text
%>

<%--<%= %>지금 이 모양은 "자바" 변수 "출력"한다는거야 --%>
{
  "name" : "<%= inName %>", "id" : "<%= inId %>", "tel" : "<%= inTel %>"
  
}