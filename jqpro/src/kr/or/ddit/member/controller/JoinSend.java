package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.JoinVO;

/**
 * Servlet implementation class JoinSend
 */
@WebServlet("/JoinSend.do")
public class JoinSend extends HttpServlet { //애초에 만들 때 class가 아니라 servlet으로 만들어서 .do찍어주고 그 다음 doget만 만들어주고
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinSend() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   request.setCharacterEncoding("UTF-8");
      // 0. 클라이언트 전송시 데이터
     
	   //db랑 vo랑 name이 다르면 이렇게 일일이 써야되는데 만약 같으면 이렇게 주석처리 된 거 말고 밑에 봐봐
	/*String sid = request.getParameter("id"); 					//	!!!!!serialize해서 form의 "name"을 받아온 거야!!!!!
      String sname = request.getParameter("name");
      String spass = request.getParameter("pass");
      String semail = request.getParameter("email");
      String shp = request.getParameter("hp");
      String sbir = request.getParameter("bir");
      String szip = request.getParameter("zip");
      String sadd1 = request.getParameter("add1");
      String sadd2 = request.getParameter("add2");
      
      JoinVO vo = new JoinVO();
      vo.setId(sid);
      vo.setName(sname);
      vo.setPass(spass);
      vo.setEmail(semail);
      vo.setHp(shp);
      vo.setBir(sbir);
      vo.setZip(szip);
      vo.setAdd1(sadd1);
      vo.setAdd2(sadd2);*/
      
	  JoinVO vo = new JoinVO(); //valueObject, Bean, DTO
	  
	  try {
		BeanUtils.populate(vo, request.getParameterMap()); //jar받아오면 위처럼 일일이 안 써줘도 map으로 묶을 수 있엉 -- 한꺼번에 가져와서 vo에 넣었어
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  
      // 1. 서비스객체 얻어오기
      IMemberService service = MemberService.getservice();
    		  
      // 2. 서비스 메서드 호출하기
      String id = service.insertMember(vo);
    		  
      // 3. 결과값을 request 에 저장하기 -- request를 통해 jsp에 값을 저장하는 거야
      request.setAttribute("joinSend1", id); //db에 저장 성공 후 가져온 id
      request.setAttribute("joinSend2", vo.getId()); //폼에서 입력한 id
    		  
      // 4. 응답데이터를 생성 - jsp로 위임 (forward방식)
      request.getRequestDispatcher("0805/join.jsp").forward(request, response); //jsp불러오는거야
      
      
      
   }

}