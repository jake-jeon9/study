package board.dao;

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

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 데이터 저장 : insert
	public int boardWrite(BoardDTO boardDTO) {		
		return sqlSession.insert("mybatis.boardMapper.boardWrite", boardDTO);
	}	
	// 데이터 삭제 : delete
	public int boardDelete(int seq) {		
		return sqlSession.delete("mybatis.boardMapper.boardDelete", seq);
	}	
	// 조회수 증가 : update
	public int updateHit(int seq) {		
		return sqlSession.update("mybatis.boardMapper.updateHit", seq);
	}	
	// 목록보기 : select
	public List<BoardDTO> boardList(int startNum, int endNum) {		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}	
	// 상세보기 : select	
	public BoardDTO boardView(int seq) {		
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}	
	// 총 목록 수 구하기 : select
	public int getTotalA() {		
		return sqlSession.selectOne("mybatis.boardMapper.getTotalA");
	}
}











