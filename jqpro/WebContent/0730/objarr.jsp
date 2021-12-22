<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//이건 json파일이라서 html문법이 오면 안돼
	//DB를 이용한 crud처리
	//처리 결과를 가지고 응답데이터를 생성
	//json object배열을 생성
%>

[
	{
		 "name" : "홍길동", 
		 "addr" : "대전", 
		 "tel" : "010-1234-5678"
	},
	
	{
		 "name" : "뚕", 
		 "addr" : "서울", 
		 "tel" : "010-2323-4545"
	},
	
	{
		 "name" : "토마토", 
		 "addr" : "토마토왕국", 
		 "tel" : "010-5656-6767"
	},
	
	{
		 "name" : "체리", 
		 "addr" : "블랙", 
		 "tel" : "010-7878-8989"
	},
	
	{
		 "name" : "어피치", 
		 "addr" : "카카오왕국", 
		 "tel" : "010-0000-5678"
	}
]
