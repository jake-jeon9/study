package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//도우미 클래스 : connection 설정
//JDBCUtil.getConnection();
//JDBCUtil.close(null,pstmt,conn); --result set이 없으면
//JDBCUtil.close(rs,pstmt,conn);--result set이 있으면

public class JDBCUtil {

	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "javaexam";
		String password = "m1234";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);//잘 되었을때 리턴
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//문제 발생시 null리턴
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {

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

}
