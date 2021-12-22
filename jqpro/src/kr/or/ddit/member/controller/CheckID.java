package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberService;

/**
 * Servlet implementation class CheckID
 */
@WebServlet("/CheckID.do")
public class CheckID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckID() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 클라이언트 전송시 값을 받는다
		String inputId = request.getParameter("id");
		
		//1. service객체 얻어온다
		IMemberService service = MemberService.getservice();
		
		//2. service메서드 호출 - 결과값 받는다
		String chkId = service.searchId(inputId);
		
		//3. 결과값을 request객체에 저장한다
		request.setAttribute("chk", chkId);
		
		//4. jsp로 포워드해서 응답데이터생성한다.
		RequestDispatcher disp = request.getRequestDispatcher("0805/checkId.jsp");
		disp.forward(request, response);
		
		
	}

}
