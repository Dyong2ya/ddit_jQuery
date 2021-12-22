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

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //doPost에서는 인코딩 필요
		
		//0. 클라이언트 전송시 데이터 가져오기
		BoardVO  vo = new BoardVO();
		try {
			BeanUtils.populate(vo, request.getParameterMap()); //한 번에 가져올 수 있는 이유는 vo랑 form만들 때 사용한 name하고 같아서 사용가능
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		vo.setWip(request.getRemoteAddr()); //클라이언트의 아이피를 얻어오는 거야
		
		//1. 서비스 객체 얻어오기
		IBoardService service = BoardService.getService();
		
		//2. 서비스 메서드 호출 - 결과값 받기
		int seq = service.insertBoard(vo);
		
		//3. 결과값을 request에 저장하기
		request.setAttribute("sea", seq); //seq는 실패해도 그냥 숫자가 올라가
		
		//4. 응답데이터 생성하기 - jsp에 위임 - forward
		request.getRequestDispatcher("views/result.jsp").forward(request, response);
		
		
	}

}
