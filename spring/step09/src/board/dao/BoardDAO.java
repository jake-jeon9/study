package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardDTO;

public class BoardDAO {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	String driver = "oracle.jdbc.driver.OracleDriver";

	public BoardDAO() {
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
	
	//insert : 글저장
		public int writeContent(BoardDTO boardDTO) {
			int su = 0;	//처리 결과 저장
			String sql="insert into board values(seq_board.nextval,?,?,?,?,0,sysdate)";

			//conn=getConnection();//접속 시도 (커넥션 풀 사용으로 주석처리)
			try {
				//1)오라클 서버에 접속
				conn = getConnection();
				//2) prepareStatement객체 생성
				pstmt =conn.prepareStatement(sql);
				//3) sql문 완성
				pstmt.setString(1, boardDTO.getId());
				pstmt.setString(2, boardDTO.getName());
				pstmt.setString(3, boardDTO.getSubject());
				pstmt.setString(4, boardDTO.getContent());
				//4) 서버에 데이터 처리 요청 -> 처리결과를 pstmt가 받음
				su=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return su;
			}
		
		//목록 5개씩 끊어 읽기
		public List<BoardDTO> boardList(int startNum, int endNum){
			List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql="select seq,id,name,subject,content,hit,to_char"
				+"(logtime,'YYYY.MM.DD') as logtime from" 
				+"(select rownum rn, tt.*from " 
				+"(select * from board order by seq desc) tt) "
				+"where rn>= ? and rn<= ?";
		
		try {
			//1)오라클 서버에 접속
			conn = getConnection();
			//2) prepareStatement객체 생성
			pstmt =conn.prepareStatement(sql);
			//3) sql문 완성
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			//4) 서버에 데이터 처리 요청 -> 처리결과를 pstmt가 받음
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getString("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getString("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				
				//리스트에 저장
				list.add(boardDTO);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
		}
		
		
		//상세보기 : 목록 1개
		public BoardDTO boardView(int seq) {
			BoardDTO boardDTO = new BoardDTO();
			String sql="select * from board where seq=?";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					boardDTO.setSeq(rs.getString("seq"));
					boardDTO.setId(rs.getString("id"));
					boardDTO.setName(rs.getString("name"));
					boardDTO.setSubject(rs.getString("subject"));
					boardDTO.setContent(rs.getString("content"));
					boardDTO.setHit(rs.getString("hit"));
					boardDTO.setLogtime(rs.getString("logtime"));
					//리스트에 저장
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return boardDTO;
			}
		
		
		
		public int getDataNumber() {
			int count=0 ;
			String sql="select * from board";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					count++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return count;
			}	
		
		
		//조회수 증가
		public void updateHit(int seq) {
			String sql="update board set hit=hit+1 where seq=?";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
		}
		
		//글삭제
		public int boardDelete(int seq) {
			int su = 0;	//처리 결과 저장
			String sql="delete board where seq=?";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				su=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return su;
			
		}
		
		//글수정 ( boardModify() )
		public int boardEdit(String subject,String content, int seq) {
			int su = 0;	//처리 결과 저장
			String sql="update board set subject = ?,content=? where seq=?";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1,subject);
				pstmt.setString(2,content);
				pstmt.setInt(3, seq);
				su=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return su;
			
		}
		//총 글수 얻기
		public int getTotalA() {
			int totalA = 0;	//처리 결과 저장
			String sql="select count(*) as cnt from board";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					totalA=rs.getInt("cnt");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return totalA;
			}
		
		public int boardModify(String subject,String content, int seq) {
			int result=0;
			String sql="update board set subject = ?,content=? where seq=?";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1,subject);
				pstmt.setString(2,content);
				pstmt.setInt(3, seq);
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return result;
		}
		public int editMyInfo(int tel1, int tel2, int tel3,String id) {
			int su = 0;	//처리 결과 저장
			String sql="update member1 set tel1=?, tel2=?, tel3=? where id=?";
			try {
				conn = getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, tel1);
				pstmt.setInt(2, tel2);
				pstmt.setInt(3, tel3);
				pstmt.setString(4,id);
				su=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return su;
			
		}
	
	
	
}
