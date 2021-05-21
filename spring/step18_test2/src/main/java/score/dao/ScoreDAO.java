package score.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import score.bean.ScoreDTO;

@Repository
public class ScoreDAO {	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreDTO dto) {			
		return sqlSession.insert("mybatis.scoreMapper.insertScore", dto);
	}
	// 성적 수정
	public int updateScore(ScoreDTO dto) {		
		return sqlSession.update("mybatis.scoreMapper.updateScore", dto);
	}
	// 성적 삭제
	public int deleteScore(ScoreDTO dto) {		
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", dto);
	}
	// 성적 목록보기
	public List<ScoreDTO> getScoreList(int startNum, int endNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum); 
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList", map);
	}	
	// 성적 상세보기
	public ScoreDTO getScore(ScoreDTO dto) {		
		return sqlSession.selectOne("mybatis.scoreMapper.getScore", dto);
	}	
	// 총 데이터 수 구하기
	public int selectListCount() {		
		return sqlSession.selectOne("mybatis.scoreMapper.selectListCount");
	}
}

















