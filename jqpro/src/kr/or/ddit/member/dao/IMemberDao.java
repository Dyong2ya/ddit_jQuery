package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.JoinVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao { //메서드가 서비스랑 똑같앙~ 매퍼랑 이름 똑같이 해줘야 안 헷갈령~
	
	//전체 리스트
	public List<JoinVO> selectAll(); 
	
	//회원가입 메서드
	public String insertMember(JoinVO vo);
	
	//id중복검사 메서드
	public String searchId(String id);
	
	//우편번호 검색 메서드
	public List<ZipVO> selectByDong(String dong);
	
}
