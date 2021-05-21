package board.controller;

import java.util.List;
import board.bean.BoardDTO;

public interface BoardService {
	// 데이터 저장 : insert
	public int boardWrite(BoardDTO boardDTO);
	// 데이터 삭제 : delete
	public int boardDelete(int seq);
	// 조회수 증가 : update
	public int updateHit(int seq);		
	// 목록보기 : select
	public List<BoardDTO> boardList(int startNum, int endNum);
	// 상세보기 : select	
	public BoardDTO boardView(int seq);
	// 총 목록 수 구하기 : select
	public int getTotalA();	
}







