package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import test.bean.ScoreVO;

public class ScoreDAOSpring {

	private SqlSession sqlSession = null;
	
	public ScoreDAOSpring(){
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	//성적등록
	public int insertData(ScoreVO vo) {
	
	return sqlSession.insert("mybatis.scoreMapper.insert",vo);	
	}
	//성적 삭제
	public int deleteData(ScoreVO vo) {
	
		return sqlSession.delete("mybatis.scoreMapper.delete",vo);
	}
	//1명 정보얻기
	public ScoreVO getData(ScoreVO vo) {
		
		return sqlSession.selectOne("mybatis.scoreMapper.getOne",vo);
	}
	//모든 정보 얻기
	public List<ScoreVO> getList(){
		
		return sqlSession.selectList("mybatis.scoreMapper.list");
	}
	//데이터 수정
	public int updataData(ScoreVO vo) {
		
		return sqlSession.update("mybatis.scoreMapper.update",vo);
	}
		
}
