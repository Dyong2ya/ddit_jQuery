package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {

	//전체리스트
	public List<BoardVO> selectAll(); //메서드이름은 매퍼별명이랑 똑같
	
	//페이지별 리스트 
	public List<BoardVO> selectByPage(Map<String, Integer> map);
	
	//전체 글 개수 가져오기
	public int getTotalCount();
	
	//글 수정하기
	
	//글 저장하기 -- 저장은 return없어서 void야 근데 글번호로 받아올거라 int로 바꿨어
	public int insertBoard(BoardVO vo);
	
	//글 삭제하기
	
	//답변달기저장
	public int replySave(ReplyVO vo);
	
	//답변 리스트
	public List<ReplyVO> replyList(int bonum);
	
	//답변수정
	public int replyModify(ReplyVO vo);
	
	//답변삭제
	public int replyDelete(int renum);
	
	//조회수 증가
	public int hitUpdate(int seq);
	
	//
	
}
