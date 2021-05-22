package tojeju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOInsertToServer {

	// 전역변수생성
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	Login login;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DAOInsertToServer() {
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

	// 3. SQL 작업처리
	// (1) insert - 입력 (콘트롤에서 입력받은거 schoolDTO를 넣어서 sql에 입력)
	public int insertArticle(DTOInsertToServer reviewDTO3) {
		int su = 0;
		String id = login.getMyId();
		// insert into category values ('관광지', '리뷰','만족도')
		String sql = "insert into category values (?,?,?,?,sysdate)"; // 데이터가 들어가는 곳에 물음표로 설정
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewDTO3.getSubject());
			pstmt.setString(2, id);
			pstmt.setString(3, reviewDTO3.getReview());
			pstmt.setString(4, reviewDTO3.getRating());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return su;
	}

	public int insertroot(String subject, String rootPhoto, String title) {
		int su = 0;
		String sql = "insert into rootphoto values (?,?,?,sysdate)"; // 데이터가 들어가는 곳에 물음표로 설정
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, subject);
			pstmt.setString(3, rootPhoto);
			pstmt.executeUpdate();
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}

	public DTOInsertToServer takeroot(String getsubject, String title) {
		DTOInsertToServer dTOInsertToServer = new DTOInsertToServer();
		String sql = "SELECT * FROM rootphoto where subject =? and title = ? "; // 데이터가 들어가는 곳에 물음표로 설정
		conn = getConnection();// 첫 번째 서브젝트 , 2번 리뷰 , 3번 레이팅
//		System.out.println("함수 호출 후 값들" + getsubject+","+title);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, getsubject);
			pstmt.setString(2, title);
			rs = pstmt.executeQuery();
//			System.out.println("try내부 : " + getsubject+","+title);
			while (rs.next()) {
				
				String subject1 = rs.getString("subject");
				String root = rs.getString("root");
				dTOInsertToServer.setRootPhoto(root);
				dTOInsertToServer.setSubject(subject1);
//				System.out.println("while문 내부 root: "+root+", 서브젝트" + subject1);
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}

		return dTOInsertToServer;
	}

	public List<DTOInsertToServer> takerootAll(String title) {
		conn = getConnection();
		List<DTOInsertToServer> list = new ArrayList<DTOInsertToServer>();
		String sql = "SELECT * FROM rootphoto where title = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DTOInsertToServer dTOInsertToServer = new DTOInsertToServer();
				dTOInsertToServer.setSubject(rs.getString("subject"));
				dTOInsertToServer.setRootPhoto(rs.getString("root"));
				list.add(dTOInsertToServer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}


}
