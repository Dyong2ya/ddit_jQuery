package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.JoinVO;
import kr.or.ddit.member.vo.ZipVO;

//ibatis mapper를 실행시킨다 - SqlMapclient객체 필요
//service에서 사용할 자신의 객체를 생성해서 리턴하는 메서드 -- service에서 new MemberDao안 만들라공!(싱글톤~)

public class MemberDao implements IMemberDao{

	private SqlMapClient client;
	private static MemberDao dao; //IMemberDao를 상속한 클래스가 많을 경우 IMemberDao가 와도 된다. 
	
	private MemberDao() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IMemberDao getDao() {
		if(dao == null)dao = new MemberDao();
		
		return dao;
	}

	@Override
	public List<JoinVO> selectAll() { //서비스가 메서드 불러와
		List<JoinVO> list = null;
		
		try {
			list = client.queryForList("join.selectAll"); //client를 xml 매퍼통해서 list(dao)로 리턴돼서 list(service) 해서 컨트롤러로 보내
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertMember(JoinVO vo) {
		String id = null;
		
		try {
			id = (String)client.insert("join.insertMember", vo);  //namespace이름.id이름
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return id;
	}

	@Override
	public String searchId(String id) { //입력한 id
		String dbId = null;  //xml에서 id가 있나없나 볼 dbid
		
		try {
			dbId = (String)client.queryForObject("join.searchId", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbId; 
	}

	@Override
	public List<ZipVO> selectByDong(String dong){
		List<ZipVO> list = null;
		
		try {
			list = client.queryForList("join.selectByDong" , dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
