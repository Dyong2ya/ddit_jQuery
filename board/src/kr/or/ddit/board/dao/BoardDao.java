package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;


import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
/* 
 * SqlMapClient 객체 - 생성자
 * 자신의 객체를 생성해서 리턴하는 메소드 - getDao();
 *
 */
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDao implements IBoardDao{
   private static IBoardDao dao;
   private SqlMapClient smc;
   private BoardDao() {
      smc = SqlMapClientFactory.getInstance();
   }
   
   public static IBoardDao getInstance() {
      if(dao == null) {
         dao = new BoardDao();
      }
      return dao;
   }
   
   
   @SuppressWarnings("unchecked")
   @Override
   public List<BoardVO> selectAll() throws SQLException {
//      List<BoardVO> list = null;
//      list = smc.queryForList("board.selectAll");
//      return list;
      
      return smc.queryForList("board.selectAll");
   }

 
@Override
public int getTotalCount() throws SQLException {
	int cnt = 0;
	
	cnt = (int)smc.queryForObject("board.getTotalCount");
	
	return cnt;
}


@Override
public List<BoardVO> selectByPage(Map<String, Integer> map) throws SQLException{
		
	// TODO Auto-generated method stub
	 return smc.queryForList("board.selectByPage", map);
}

@Override
public int insertBoard(BoardVO vo) throws SQLException {

	return (int)smc.insert("board.insertBoard", vo);
	
}

@Override
public int replySave(ReplyVO vo) throws SQLException {

	return (int)smc.insert("board.replySave", vo);
}

@Override
public List<ReplyVO> replyList(int bonum) throws SQLException {

	return smc.queryForList("board.replyList", bonum);
}

@Override
public int replyModify(ReplyVO vo) throws SQLException {

	return smc.update("board.replyModify", vo);
}

@Override
public int replyDelete(int renum) throws SQLException {

	return smc.delete("board.replyDelete", renum);
}

@Override
public int hitUpdate(int seq) throws SQLException {
	// TODO Auto-generated method stub
	return smc.update("board.hitUpdate", seq);
}

}
		
