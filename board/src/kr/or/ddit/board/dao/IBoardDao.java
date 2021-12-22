package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
   // 전체리스트
   public List<BoardVO> selectAll() throws SQLException;
   
   // 페이지별리스트
   public List<BoardVO> selectByPage(Map<String, Integer> map) throws SQLException;
   
   // 전체글갯수
   public int getTotalCount() throws SQLException;
   
   // 글수정하기
   
   // 글저장하기
   public int insertBoard(BoardVO vo) throws SQLException;
   
   // 글삭제하기
   
   // 답변달기저장
   public int replySave(ReplyVO vo)throws SQLException;
   
   //답변 리스트 
   public List<ReplyVO> replyList(int bonum)throws SQLException;
   
   // 답변수정
   public int replyModify(ReplyVO vo)throws SQLException;;
   
   // 답변삭제
   public int replyDelete(int renum) throws SQLException;
   
   // 조회수 증가
   public int hitUpdate(int seq) throws SQLException;
}