package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.JoinVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService { //인터페이스는 설계도. 구현할 때 상속받아서 하도록. 메소드 선언하는 거야
	
	//전체 리스트
	public List<JoinVO> selectAll(); 
	
	//회원가입 메서드
	public String insertMember(JoinVO vo);
	
	//id중복검사 메서드
	public String searchId(String id);
	
	//우편번호 검색 메서드 --자바에서 결과값 리스트
	public List<ZipVO> selectByDong(String dong);
	

}
 