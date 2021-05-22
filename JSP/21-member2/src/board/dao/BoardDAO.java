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

public class BoardDAO {
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="javaexam";
	String password = "l1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 1. 톰캣 서버로부터 DataSource 객체 얻어오기
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
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	
	// 3. 커넥션 객체 닫기
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 데이터 추가하기
		public int writeBoard(BoardDTO boardDTO) {
			//insert into board values (seq_board.nextval, 'num1','홍길동', '내일은','웃으리...',0, sysdate)
			//조회수는 초기값 (0)으로 지정하고 시작. 
			int su =0;
			String sql = "insert into board values (seq_board.nextval, ? ,?, ?, ? , 0, sysdate)";
			// 1) 오라클 서버에 접속
			// conn = getConnection();  => 커넥션 풀 사용으로 이건 주석처리
			try {
				// 1) 오라클 서버에 접속
				conn = getConnection();
				// 2) PreparedStatement 객체 생성
				pstmt = conn.prepareStatement(sql);
				// 3) sql문 완성
				pstmt.setString(1, boardDTO.getId());
				pstmt.setString(2, boardDTO.getName());
				pstmt.setString(3, boardDTO.getSubject());
				pstmt.setString(4, boardDTO.getContent());
				// 4) 서버에 데이터 처리요청 ->처리결과를 pstmt가 받음 -> pstmt가 결과를 리턴 
				su = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 5) 오라클 서버 접속 종료
				close();
			}
			// 6) 결과값 리턴
			return su;
		}
		
		
		// 목록 읽기 - 5개씩 끊어서 읽어오기 (rn>= 이게 스타트, rn<= 이건 엔드 / 숫자 지정은 boardList.jsp의 목록보기에 설정!)
		public List<BoardDTO> boardList(int startNum, int endNum) {
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			String sql = "select seq,id,name,subject,content,hit, "
					+ " to_char(logtime,'YYYY.MM.DD')as logtime from " 
					+ " (select rownum rn,tt.*from " 
					+ " (select * from board order by seq desc)tt) " 
					+ "where rn>=? and rn<=?";
			
			try {
				conn = getConnection();
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
					// 리스트에 저장 (각각 불러와서 boardDTO에 각각 저장하고, 리스트에 저장!)
					list.add(boardDTO);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
			
		}
		
		// 상세보기 : 목록 1개만 상세히 보여주기 (null로 처음에 써주고, 뉴를 한다음에 다시 리턴을 해줌.....) 모르겠다...
		public BoardDTO boardView (int seq) {
			BoardDTO boardDTO = null;
			String sql = "select * from board where seq=?";
			
			try {
				conn = getConnection();
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
			} return boardDTO;
		}
		
		// 조회수 증가
		public void updateHit (int seq) {
			String sql = "update board set hit=hit+1 where seq=?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				rs = pstmt.executeQuery();	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 5) 오라클 서버 접속 종료
				close();
			}
		}
		
		// 글 삭제 
		public int boardDelete(int seq) {
			int su =0;
			String sql = "delete board where seq=?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				su = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return su;
		}
		
		//총 글 수 구하기
		public int getTotalA () {
			int totalA = 0;
			String sql = "SELECT COUNT(*) as cnt FROM board";
			
			try {
				conn = getConnection();
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
		public void boardModify (String subject, String content, int seq) {
			String sql = "update board set content=?, subject=? where seq=?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
				pstmt.setString(2, subject);
				pstmt.setInt(3, seq);
				rs = pstmt.executeQuery();	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 5) 오라클 서버 접속 종료
				close();
			}
		}

}

















