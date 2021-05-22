package tojeju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAONotice {

	// 전역변수생성
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	Login login;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DAONotice() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2. Connection 객체 생성 함수 - 오라클에 접속, DriverManager가 담당 클래스, 성공 conn, 실패 null =>
	// 성공시 conn 객체 얻을 수 있음
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 접속 끊기 - close 함수로 각각 다 끊기.
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

	public List<DTONotice> getNotice() {
		conn = getConnection();
		List<DTONotice> list = new ArrayList<DTONotice>();
		String sql = "SELECT * FROM notice";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DTONotice dTONotice = new DTONotice();
				dTONotice.setTitle(rs.getString("title"));
				dTONotice.setText(rs.getString("text"));
				dTONotice.setTime(rs.getString("time"));
				list.add(dTONotice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
}
