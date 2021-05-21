package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	String driver = "oracle.jdbc.driver.OracleDriver";

	public MemberDAO() {
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
	
	public String checkId(String id, String pw) {
		int result=0;
		String sql = "select * from member1 where id=? and pw=?";
		conn=getConnection();
		String name=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
		 result=pstmt.executeUpdate();
		 
		 if(result>0) {
			 rs = pstmt.executeQuery();
			 MemberDTO dto = new MemberDTO();
			 while(rs.next()) {
				 dto.setName(rs.getNString("name"));
				 name = dto.getName();
			 }
		 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return name;
	}
	

}
