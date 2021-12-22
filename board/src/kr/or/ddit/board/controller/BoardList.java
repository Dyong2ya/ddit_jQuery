package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardList() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// selectAll //파라미터없어서 전송데이터없어!!!!!!!! List 그냥 그 자체를 list에 받아서 뽑으려고
		//0. client전송시 데이터 가져오기
		//1. service객체 얻어오기
		IBoardService service = BoardService.getService();
		
	    //2. service메서드 호출하기 - 결과값 받기
		List<BoardVO> list = service.selectAll();
		
		//3. 결과값을 request에 저장하기
		request.setAttribute("list", list);
		
		//4. 응답데이터 생성하기 - jsp로 위임 - forward
		RequestDispatcher disp = request.getRequestDispatcher("views/listAll.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// selectByPage //여기서는 listAll.jsp에 들어있던 list를 페이징처리해주려고 
		//0. client전송시 데이터 가져오기
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println("page=" + page);
		
		//1. service객체 얻어오기
		IBoardService service = BoardService.getService();
		
		int perList = 5;
		int perPage = 3;
		//페이지에 따라서 달라짐 1 -> 1,3 / 2 -> 4,6 / 3 -> 7,9
		//4 -> 10,12 / 5 -> 13,15 / 6 -> 16,18 / 7 -> 19,20(,21)/
		//start
		//end
		int totalCount = service.getTotalCount();
		int start = (page - 1) * perList + 1;
		int end = start + perList - 1;
		if(end > totalCount) end = totalCount; 
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
	    //2. service메서드 호출하기 - 결과값 받기
		List<BoardVO> list = service.selectByPage(map);
		
		//페이징처리 -----------------------------
		int totalPage = (int)(Math.ceil((double) totalCount / perList)); //7
		int startPage = ((page - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage; //7까지밖에 없어서 8을 7로 맞춰주는 거야
	
		//3. 결과값을 request에 저장하기
		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);
		
		//4. 응답데이터 생성하기 - jsp로 위임 - forward
		request.getRequestDispatcher("views/listPage.jsp").forward(request, response);
		
		
	}

}
