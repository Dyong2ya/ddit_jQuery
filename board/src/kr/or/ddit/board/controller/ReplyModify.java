package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyModify
 */
@WebServlet("/ReplyModify.do")
public class ReplyModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//0. 클라이언트 전송 값 가져오기 - renum, cont
		int rnum = Integer.parseInt(request.getParameter("renum"));
		String rcont = request.getParameter("cont");
		
		ReplyVO  vo = new ReplyVO();
		vo.setRenum(rnum);
		vo.setCont(rcont);
		
		//1. service객체 얻어오기
		IBoardService service = BoardService.getService();
				
		//2. service메서드 호출 - 결과값
		int cnt = service.replyModify(vo);
				
		//3. 결과값을 request에 저장
		request.setAttribute("cnt", cnt);		
				
		//4. 응답데이터 생성 modify.jsp	
		request.getRequestDispatcher("views/modify.jsp").forward(request, response);		
				
	}

}
