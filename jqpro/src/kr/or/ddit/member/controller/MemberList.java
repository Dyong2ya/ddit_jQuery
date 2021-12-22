package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.JoinVO;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/MemberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트 전송 시 데이터 받기
		//selectAll이라 없엉
		
		//1. service객체 얻어오기
		IMemberService service = MemberService.getservice();
		
		//2. service메서드 호출하기 - 결과값받기
		List<JoinVO> list = service.selectAll();
		
		//3. request 객체에 2번의 결과값을 저장
		request.setAttribute("list", list);
		
		//4. 2번의 결과값으로 응답데이터 생성하기 - html.json, xml, text
		//	 view페이지 이동 - 2번의 결과값을 가져간다.
		RequestDispatcher disp = request.getRequestDispatcher("0804/memberList.jsp");
		disp.forward(request, response);
		
	}

}
