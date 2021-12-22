package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0 클라이언트 전송시 값 - renum(ajax에서 올 때 키콤마밸류에서 키를 맡고 있징!)
		int rnum = Integer.parseInt(request.getParameter("renum"));
		
		//1 service 객체 얻어오기
		IBoardService service = BoardService.getService();
		
		//2 service 메서드 호출 - 결과값 받기
		int cnt = service.replyDelete(rnum);
		
		//3 결과값을 request에 저장
		request.setAttribute("cnt", cnt);
		
		//4 응답데이터 생성 -> delete.jsp만들어 줘야 돼
		request.getRequestDispatcher("views/delete.jsp").forward(request, response);
	
	}

}
