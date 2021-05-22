package board.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;
import member.bean.MemberDTO;

public class BoardDAO {
	/* 커넥션 풀 사용으로 주석처리
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	
	Connection conn;			// 오라클서버와 접속하는 클래스
	PreparedStatement pstmt;	// 보조 스트림 클래스, 오라클 서버와 데이터 처리
	ResultSet rs;				// select문 처리 결과값을 사용하는 인터페이스
	
	// 1. driver 라이브러리가 등록되었는지 확인
	public BoardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. 커넥션 객체 얻기
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	*/
	
	Connection conn;			// 오라클서버와 접속하는 클래스
	PreparedStatement pstmt;	// 보조 스트림 클래스, 오라클 서버와 데이터 처리
	ResultSet rs;				// select문 처리 결과값을 사용하는 인터페이스
	// import javax.sql.DataSource;
	DataSource ds;				// 커넥션 풀을 담당하는 클래스
	
	// 1. 톰캣 서버로부터 DataSource 객체 얻어오기
	public BoardDAO() {
			try {
				// import javax.naming.Context;
				Context context = new InitialContext();	// context.xml 파일을 읽어옴
				// 톰캣인 경우, DataSource 객체를 찾을 경우,
				// 반드시 커넥션 풀 성정 앞에, "java:comp/env/"를 붙여야 한다.
				// 이것의 의미는 context.xml -> <Context> -> <Resource> -> "name" 속성 까지를 나타낸다.
				ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		
		
	}
	
	// 3. 커넥션 객체 닫기 (접속 종료)
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int boardWrite(BoardDTO boardDTO) {
		int su = 0;
		String sql = "insert into board values(seq_board.nextval,"
				   + "?,?,?,?,0,sysdate)";
		// conn = getConnection();	커넥션 풀 사용으로 주석처리
		
		try {
			// (1) 오라클 서버에 접속
			conn = ds.getConnection();
			// (2) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// (3) sql문 완성
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getContent());
			// (4) 서버에 데이터 처리 요청
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 목록 읽기 - 5개씩 끊어서 읽어오기
	// int startNum, int endNum : rn>=1, rn<=5
	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select seq, id, name, subject, content, hit, "
				   + " to_char(logtime, 'YYYY.MM.DD') as logtime "  
				   +  " from (select rownum rn, tt. * from "
				   + " (select * from board order by seq desc) tt) "  
				   +  " where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				// 리스트에 저장
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 상세보기 : 목록 1개
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = null;
		String sql = "select * from board where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardDTO;
	}
	
	// 조회수 증가
	public void updateHit(int seq) {
		String sql = "update board set hit=hit+1 where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 글 삭제
	public int boardDelete(int seq) {
		int su = 0;
		String sql = "delete board where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return su;
	}
	
	// 총 글수 구하기
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) as cnt from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalA = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}
	
	// 글 수정
	public int boardUpdate(String subject, String content, int seq) {
		int su = 0;
		String sql = "update board set subject=?, content=? where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return su;
	}
}
