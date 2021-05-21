package score.controller;

import java.util.List;
import score.bean.ScoreDTO;

public interface ScoreService {
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreDTO dto);
	// 성적 수정
	public int updateScore(ScoreDTO dto);
	// 성적 삭제
	public int deleteScore(ScoreDTO dto);
	// 성적 목록보기
	public List<ScoreDTO> getScoreList(int startNum, int endNum);
	// 성적 상세보기
	public ScoreDTO getScore(ScoreDTO dto);
	// 총 데이터 수 구하기
	public int selectListCount();
}
