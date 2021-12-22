package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		//1. 서비스 객체
		IBoardService service = BoardService.getService();
		
		//2. 메서드 호출 - 결과값(List로 받기)
		List<ReplyVO> list = service.replyList(bonum);
		
		//3. request에 결과값 저장하기
		request.setAttribute("list", list);
		
		//4. 응답데이터
		request.getRequestDispatcher("views/replyList.jsp").forward(request, response);
	}

}
