package tojeju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//오라클 서버에 접속하여 CRUD를 처리하는 클래스

class MypageDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MypageDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private void close() {

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

	// 입력하기
	public int insert(MypageDTO mypageDTO) {

		int su = 0; // 결과처리데이터 개수

		// 1.서버연결 얻어오기
		conn = getConnection();
		// 2.데이터처리
		String sql = "insert into mypage values (?, ?, ?, ?, ?, ?)"; // 실행할 명령문
		try {
			pstmt = conn.prepareStatement(sql); // 명령전달
			pstmt.setString(1, mypageDTO.getDaytime());
			pstmt.setString(2, mypageDTO.getWhether());
			pstmt.setString(3, mypageDTO.getPlace());
			pstmt.setString(4, mypageDTO.getTitle());
			pstmt.setString(5, mypageDTO.getText());
			pstmt.setString(6, mypageDTO.getFeel());
			su = pstmt.executeUpdate(); // 명령실행

		} catch (SQLException e) {
			e.printStackTrace();
			// 3.접속끊기
		} finally {
			close();
		}

		return su;

	}

	// 삭제하기
	public int delete(String subject) {

		int su = 0;

		// 1.서버연결 가져오기
		conn = getConnection();
		// 2.데이터처리
		String sql = " delete mypage where title = ?";

		try {
			pstmt = conn.prepareStatement(sql); // 명령전달
			pstmt.setString(1, subject);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// 3.접속끊기
		} finally {
			close();
		}

		return su;
	}

	// 이름검색
	public MypageDTO select(String title) {

		MypageDTO mypageDTO = null;

		// 1.서버연결
		conn = getConnection();

		// 2.데이터처리
		String sql = "select*from mypage where title = ?";
		try {
			pstmt = conn.prepareStatement(sql);// 명령전달
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();// 명령시행
			if (rs.next()) {
				String daytime = rs.getString("daytime");
				String whether = rs.getString("whether");
				String place = rs.getString("place");
				String title1 = rs.getString("title");
				String text = rs.getString("text");
				String feel = rs.getString("feel");
				mypageDTO = new MypageDTO(daytime, whether, place, title1, text, feel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 3.접속종료
		} finally {
			close();
		}

		return mypageDTO;

	}

	// 전체 불러오기
	public List<MypageDTO> allopen() {

		conn = getConnection();
		List<MypageDTO> list = new ArrayList<MypageDTO>();
		String sql = "select*from mypage";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MypageDTO mypageDTO = new MypageDTO();
				mypageDTO.setDaytime(rs.getString("daytime"));
				mypageDTO.setWhether(rs.getString("whether"));
				mypageDTO.setPlace(rs.getString("place"));
				mypageDTO.setTitle(rs.getString("title"));
				mypageDTO.setText(rs.getString("text"));
				mypageDTO.setFeel(rs.getString("feel"));
				list.add(mypageDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public MypageDTO lookAtMyContent(String text) {

		conn = getConnection();
		MypageDTO mypageDTO = new MypageDTO();
		String sql = "select*from mypage where text = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				mypageDTO.setDaytime(rs.getString("daytime"));
				mypageDTO.setWhether(rs.getString("whether"));
				mypageDTO.setPlace(rs.getString("place"));
				mypageDTO.setTitle(rs.getString("title"));
				mypageDTO.setText(rs.getString("text"));
				mypageDTO.setFeel(rs.getString("feel"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return mypageDTO;
	}

}
