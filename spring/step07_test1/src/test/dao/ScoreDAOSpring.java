package test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository
public class ScoreDAOSpring {

	// sql문
	String sql_insert = "insert into score values(?,?,?,?,?,?,?,sysdate)";
	String sql_list = "select * from score";
	String sql_getData = "select * from score where studno = ?";
	String sql_update = "update score set kor=?,eng=?,mat=?,tot=?,avg=? where studno=?";
	String sql_delete = "delete score where studno =?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertData(ScoreVO vo) {
		Object[] arg = { vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(),
				vo.getAvg() };

		return jdbcTemplate.update(sql_insert, arg);
	}

	public int deleteData(ScoreVO vo) {

		return jdbcTemplate.update(sql_delete, vo.getStudNo());
	}

	public ScoreVO getData(ScoreVO vo) {
		Object[] arg = { vo.getStudNo() };

		return jdbcTemplate.queryForObject(sql_getData, arg, new ScoreRowMapper());
	}

	public List<ScoreVO> getList() {
		return jdbcTemplate.query(sql_list, new ScoreRowMapper());
	}

	public int updataData(ScoreVO vo) {
		Object[] arg = { vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg(), vo.getStudNo() };
		return jdbcTemplate.update(sql_update, arg);
	}

}
