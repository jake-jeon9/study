package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// sql명령문
		String sql_insert = "insert into goods values(?,?,?,?)";
		String sql_delete = "delete goods where code=?";
		String sql_get = "select * from goods where code=?";
		String sql_list = "select * from goods ";
	
		/* CRUD 기능의 메소드*/
		
		// 책 등록
		int insertGoods(GoodsVO vo) {
			//방법 1.
			int result = jdbcTemplate.update(sql_insert,vo.getCode(),vo.getName(),vo.getPrice(),vo.getMaker());
			
			//방법2.
			Object[] args = {vo.getCode(),vo.getName(),vo.getPrice(),vo.getMaker()};
			int k = jdbcTemplate.update(sql_insert, args);
			return result;
		}
		//책삭제
		int deleteGoods(GoodsVO vo) {
			return jdbcTemplate.update(sql_delete,vo.getCode());
		}
		//책 상세 조회
		GoodsVO getGoods(GoodsVO vo) {
			Object[] args = {vo.getCode()};
			return jdbcTemplate.queryForObject(sql_get, args,new GoodsRowMapper());// 1. sql문 ,2.  ? 에들어갈 데이터-배열 / 리턴값의 자료형.  즉, goodsMapper 의자료형( goodsVO) 또는 스트링,인트 등 
			//쿼리 포 오브젝트에서 DB에따라 vo가 다 다르기 때문에 인터페이스를 만들어서 정의해줘야 함. 
			
		}
		//책 목록 조회
		List<GoodsVO> getGoodsList(){
			return jdbcTemplate.query(sql_list, new GoodsRowMapper());
		}
		
}
