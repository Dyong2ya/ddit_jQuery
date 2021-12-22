package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.vo.JoinVO;
import kr.or.ddit.member.vo.ZipVO;

//Dao의 메서드를 호출하여 실행 - dao객체가 필요
//controller에서 사용할 자신의 객체를 생성하고 리턴하는 메서드

public class MemberService implements IMemberService{
	
	private IMemberDao dao;
	private static IMemberService service;

	private MemberService() {
		dao = MemberDao.getDao(); //싱글톤해놔서 new뭐시기 안 해도 돼
	}
	
	public static IMemberService getservice() {  //이 서비스는 컨트롤러가 사용하고 서비시는 다오사용. 다오는 매퍼사용
		if(service == null) service = new MemberService();
		
		return service;
	}
	
	@Override
	public List<JoinVO> selectAll() {
//		List<JoinVO> list = null;
//		list = dao.selectAll();
//		return list;
		
		return dao.selectAll(); //변수선언 안 하고 이렇게 한 줄로  끝내도 돼
	}

	@Override
	public String insertMember(JoinVO vo) {

		return dao.insertMember(vo);
	}

	@Override
	public String searchId(String id) {

		return dao.searchId(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {

		return dao.selectByDong(dong);
	}

}
