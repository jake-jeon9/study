package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ScoreVO;

public class ScoreDAO {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	String driver = "oracle.jdbc.driver.OracleDriver";

	// sql
		String sql_insert = "insert into score values(?,?,?,?,?,?,?,sysdate)";
		String sql_list = "select * from score";
		String sql_getData = "select * from score where studno = ?";
		String sql_update = "update score set kor=?,eng=?,mat=?,tot=?,avg=? where studno=?";
		String sql_delete = "delete score where studno =?";
		String sql_getList = "select * from(select rownum rn, tt.*from" + 
				"(select * from score order by studno) tt) where rn>=? and rn<=?";
		String sql_getCount = "select count(*) as cnt from score";
	
	public ScoreDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);// 연결 셋팅
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertData(ScoreVO vo) {
		int result = 0;
		conn = getConnection();
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
			close();
		}
		return result;
	}

	// 데이터 삭제
	public int deleteData(String studNo) {
		int result = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, studNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public ScoreVO getData(String stunNo) {
		conn = getConnection();
		ScoreVO vo = new ScoreVO();
		try {
			pstmt = conn.prepareStatement(sql_getData);
			pstmt.setString(1, stunNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
			close();
		}
		return vo;
	}

	public List<ScoreVO> getList(int startNum, int endNum) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		conn = getConnection();
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
			close();
		}
		return list;
	}

	public int updataData(ScoreVO vo) {
		int result = 0;
		vo.setTot(vo.getKor() + vo.getEng() + vo.getMat());
		vo.setAvg(vo.getTot() / 3.0);
		conn = getConnection();
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
			close();
		}
		return result;
	}

	// 목록 5개씩 끊어 읽기
	public List<ScoreVO> ScoreList(int startNum, int endNum) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_getList);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setStudNo(rs.getNString("studno"));
				vo.setName(rs.getNString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getDouble("avg"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int getTotalA() {
		int totalA = 0; // 처리 결과 저장
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_getCount);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalA = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}

}
