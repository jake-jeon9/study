package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

//빈객체로 설정
@Repository
public class ScoreDAO {

	// 커넥션
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	// sql
	String sql_insert = "insert into score values(?,?,?,?,?,?,?,sysdate)";
	String sql_list = "select * from score";
	String sql_getData = "select * from score where studno = ?";
	String sql_update = "update score set kor=?,eng=?,mat=?,tot=?,avg=? where studno=?";
	String sql_delete = "delete score where studno =?";

	public int insertData(ScoreVO vo) {
		int result = 0;

		conn = JDBCUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setNString(1, vo.getStudNo());
			pstmt.setNString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMat());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return result;
	}

	// 데이터 삭제
	public int deleteData(ScoreVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return result;
	}

	public ScoreVO getData(ScoreVO vo) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_getData);
			pstmt.setString(1, vo.getStudNo());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo= new ScoreVO();
				vo.setStudNo(rs.getString("studno"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getDouble("avg"));
				vo.setLogtime(rs.getNString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return vo;
	}

	public List<ScoreVO> getList() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		conn = JDBCUtil.getConnection();
		try {

			pstmt = conn.prepareStatement(sql_list);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setStudNo(rs.getString("studno"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getDouble("avg"));
				vo.setLogtime(rs.getNString("logtime"));

				// 리스트에 저장
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return list;
	}

	public int updataData(ScoreVO vo) {
		int result = 0;
		;
		vo.setTot(vo.getKor() + vo.getEng() + vo.getMat());
		vo.setAvg(vo.getTot() / 3.0);
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getKor());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getMat());
			pstmt.setInt(4, vo.getTot());
			pstmt.setDouble(5, vo.getAvg());
			pstmt.setString(6, vo.getStudNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return result;
	}
}
