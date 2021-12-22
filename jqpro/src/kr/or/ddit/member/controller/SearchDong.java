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
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchDong
 */
@WebServlet("/SearchDong.do")
public class SearchDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 전송시 값을 받는다
		String sdong = request.getParameter("dong");
		
		//1. service객체 얻어온다
		IMemberService service = MemberService.getservice();
		
		//2. service메서드 호출 - 결과값 받는다
		List<ZipVO> list = service.selectByDong(sdong);
		
		//3. 결과값을 request객체에 저장한다
		request.setAttribute("zipzip", list);
		
		//4. jsp로 포워드해서 응답데이터생성한다.
		RequestDispatcher disp = request.getRequestDispatcher("0805/zipzip.jsp");
		disp.forward(request, response);
	}

}
