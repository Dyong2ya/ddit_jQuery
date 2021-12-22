package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;



import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardService implements IBoardService{
	
	//변수선언
	private IBoardDao dao;
	private static IBoardService service;
	
	//생성자
	private BoardService() {
		dao = BoardDao.getInstance();
	}
	
	//getService()
	public static IBoardService getService() {
		if(service == null) {
			service = new BoardService();
		}
		return service;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	

	@Override
	public int getTotalCount() {
		int cnt = 0;
		
		try {
			cnt = dao.getTotalCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map) {
			List<BoardVO> list = null;
		
		try {
			list = dao.selectByPage(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int seq = 0;
		
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seq;
	}

	@Override
	public int replySave(ReplyVO vo) {
		int seq = 0;
		
		try {
			seq = dao.replySave(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seq;
	}

	@Override
	public List<ReplyVO> replyList(int bonum) {
		List<ReplyVO> list = null;
		
		try {
			list = dao.replyList(bonum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int replyModify(ReplyVO vo) {
		int res = 0;
		
		try {
			res = dao.replyModify(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int replyDelete(int renum) {
		int cnt = 0;
		
		try {
			cnt = dao.replyDelete(renum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int hitUpdate(int seq) {
		int res = 0;  //참고로 변수이름 아무거나 줘도 돼
		
		try {
			res = dao.hitUpdate(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	
}
