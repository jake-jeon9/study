package test02;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class GoodsDAO {

	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	// sqlSession에 있는 CRUD 함수를 이용, 사용방법은 mapper에 "등록된 별칭 + 각 CRUD 에 지정된 id값"의 스트링타입
	// 과 vo 객체(이때 변수가 아닌 객체를 주면 객체에 있는 타입에 맞춰서 자동 사용됨.
	public int insertGoods(GoodsVO vo) {
		return sqlSession.insert("mybatis.goodsMapper.insert", vo);
		// 질문,,, vo 객체는 mapper에 지정한 parameter 타입과 일치해야만 하는지??
	}

	public int deleteGoods(GoodsVO vo) {
		return sqlSession.delete("mybatis.goodsMapper.delete", vo);
	}

	public List<GoodsVO> getGoodsList() {
		return sqlSession.selectList("mybatis.goodsMapper.list");
	}

	public GoodsVO getGoods(GoodsVO vo) {
		return sqlSession.selectOne("mybatis.goodsMapper.get", vo);
	}

}
