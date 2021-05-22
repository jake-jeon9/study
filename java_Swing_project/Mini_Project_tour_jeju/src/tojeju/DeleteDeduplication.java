package tojeju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDeduplication {


	// 전역변수생성
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	String login;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String result;
	
	public DeleteDeduplication() {
	
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	 public String DeleteDeduplicationCall() {
			int num1 = deleteDeduplicationMyreview();
			int num2 =deleteDeduplicationComments(); 
			int num3 =deleteDeduplicationId(); 
			int num4 =deleteDeduplicationReview(); 
			int num5 =deleteDeduplicationRoot(); 
			
			result = "중복 아이디 제거 : " + num3 + " / 중복 리뷰제거 : "+num4+" / 중복 코멘트제거 : "+num2+
					" / 중복 내가 쓴 글 제거 : " + num1 + " / 중복 파일 루트 제거 : "+ num5;
			return result;
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
	public int deleteDeduplicationRoot() {
		int su = 0;
		String sql = "DELETE FROM rootphoto a  WHERE ROWID < (SELECT MAX(ROWID)  FROM rootphoto b WHERE a.root = b.root)"; 
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {
			pstmt = conn.prepareStatement(sql);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return su;
	}
	public int deleteDeduplicationId() {
		int su = 0;
		String sql = " DELETE FROM member a  WHERE ROWID < (SELECT MAX(ROWID)  FROM member b WHERE a.id = b.id)"; 
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {
			pstmt = conn.prepareStatement(sql);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return su;
	}
	public int deleteDeduplicationReview() {
		int su = 0;
		String sql = "DELETE FROM category a  WHERE ROWID < (SELECT MAX(ROWID)  FROM category b WHERE a.review = b.review)"; 
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {
			pstmt = conn.prepareStatement(sql);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return su;
	}
	public int deleteDeduplicationComments() {
		int su = 0;
		String sql = "DELETE FROM categoryreview a  WHERE ROWID < (SELECT MAX(ROWID)  FROM categoryreview b WHERE a.comments = b.comments)"; 
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {
			pstmt = conn.prepareStatement(sql);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return su;
	}
	public int deleteDeduplicationMyreview() {
		int su = 0;
		String sql = " DELETE FROM mypage a  WHERE ROWID < (SELECT MAX(ROWID)  FROM mypage b WHERE a.text = b.text)"; 
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {
			pstmt = conn.prepareStatement(sql);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return su;
	}
}
