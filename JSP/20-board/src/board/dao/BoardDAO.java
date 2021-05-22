package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardBean;

public class BoardDAO {

	
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		DataSource ds;
		
		public BoardDAO() {
			try {
				Context context = new InitialContext();			 //파일 읽기
				ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
			
			public void close() {
			try {
				if(rs!=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null)conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
			
			//글 등록 : insert
			public int insertArticle(BoardBean boardBean) {
				int insertCount = 0; 	//처리결과 저장
				String sql = "insert into board2 values(seq_num.nextval, ? , ? , ? , ? , ? , seq_num.currval, 0,0,0,sysdate)";
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setNString(1, boardBean.getBoard_name());
					pstmt.setNString(2, boardBean.getBoard_pass());
					pstmt.setNString(3, boardBean.getBoard_subject());
					pstmt.setNString(4, boardBean.getBoard_content());
					pstmt.setNString(5, boardBean.getBoard_file());
					
					insertCount = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return insertCount;
			}
			
			//총 글수 구하기
			public int getTotalPage() {
				int totalPage = 0;
				String sql = "select count(*) as cnt from board2";
				
				try {
					conn=ds.getConnection();
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						totalPage = rs.getInt("cnt");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				return totalPage;
			}
			
			//글 목록보기
			//=답변보기 기능이 추가돈 코드로 수정
			public List<BoardBean> selectArticleList(int startNum, int endNum) {
				List<BoardBean> list = new ArrayList<BoardBean>();
				/*String sql="select * from(select rownum rn, tt.*from"
						+ "(select * from board2 order by board_num desc) tt)" + 
					"where rn>= ? and rn<=?";
				*/
				String sql = "select * from(select rownum rn, tt.* from"
						+ "(select * from board2 order by board_re_ref desc, board_re_seq asc) tt)"
						+ "where rn>=? and rn<=?";
				
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startNum);
					pstmt.setInt(2, endNum);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						BoardBean boardBean = new BoardBean();
						boardBean.setBoard_num(rs.getInt("board_num"));
						boardBean.setBoard_name(rs.getString("board_name"));
						boardBean.setBoard_subject(rs.getString("board_subject"));
						boardBean.setBoard_content(rs.getString("board_content"));
						boardBean.setBoard_file(rs.getString("board_file"));
						boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
						boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
						boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
						boardBean.setBoard_readcount(rs.getInt("board_readcount"));
						boardBean.setBoard_date(rs.getString("board_date"));
						//리스트에 저장
						list.add(boardBean);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return list;
			}
			
			//조회수 증가
			public int updateReadCount(int board_num) {
				int updateResult = 0; 	//처리결과 저장
				String sql = "update board2 set board_readcount =board_readcount+1 where board_num=?";
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, board_num);
					updateResult= pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return updateResult;
			}
			
			//상세보기
			public BoardBean selectArticle(int board_num) {
				BoardBean boardBean = new BoardBean();
				String sql="select * from board2 where board_num=?";
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, board_num);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						boardBean.setBoard_num(rs.getInt("board_num"));
						boardBean.setBoard_name(rs.getString("board_name"));
						boardBean.setBoard_subject(rs.getString("board_subject"));
						boardBean.setBoard_content(rs.getString("board_content"));
						boardBean.setBoard_file(rs.getString("board_file"));
						boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
						boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
						boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
						boardBean.setBoard_readcount(rs.getInt("board_readcount"));
						boardBean.setBoard_date(rs.getString("board_date"));
						
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return boardBean;
						
			}
			
			//비밀번호 얻기
			public boolean getPassword(int board_num, String password) {
				boolean result=false;
				String board_pw="";
				String sql="select * from board2 where board_num=?";
				
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, board_num);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						board_pw=rs.getString("board_pass");
					}
					if(password.equals(board_pw)) {
						result=true;
					}else {
						result=false;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return result;
						
			}
			
			//글삭제
			public int deleteArticle(int board_num) {
				int result=0;
				String sql = "delete board2 where board_num=?";
				
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, board_num);
					result= pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return result;
			}
			
			//글 업데이트
			public int updateArticle(BoardBean boardBean ){
				int result=0;
				String sql="update board2 set  board_name=?, board_subject=?,"
						+ " board_content = ?  where board_num = ?";
				try {
				conn = ds.getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1,boardBean.getBoard_name());
				pstmt.setString(2,boardBean.getBoard_subject());
				pstmt.setString(3,boardBean.getBoard_content());
				pstmt.setInt(4, boardBean.getBoard_num());
				result=pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return result;
			}
			
			//답변글 저장
			public int insertReplyArticle(BoardBean boardBean) {
				int result =0;
				String sql="";
				int board_re_ref = boardBean.getBoard_re_ref();
				int board_re_lev =  boardBean.getBoard_re_lev();
				int board_re_seq =  boardBean.getBoard_re_seq();
				try {
					conn = ds.getConnection();
					//1.기존 답글의 등록 순서를 재정리함
					//=>원글 board_re_seq보다 큰 답글의 board_re_seq값을 1씩 증가
					
					sql="update board2 set board_re_seq = board_re_seq+1 where board_re_ref =? and board_re_seq>?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, board_re_ref);
					pstmt.setInt(2, board_re_seq);
					pstmt.executeUpdate();			
					
					//2. 추가된 답글의 board_re_seq는 원글 board_re_seq에 +1 증가 한 값을 가진다
						//추가된 답글의 board_Re_lev는 원글 board_re_lev에 +1 증가한 값을 가진다
						board_re_lev=board_re_lev+1;
						board_re_seq=board_re_seq+1;
						sql="insert into board2 values"
								+ "(seq_num.nextval, ?, ?,?,?,?,?, ?,?,0,sysdate)";
						
						pstmt=conn.prepareStatement(sql);
						pstmt.setNString(1, boardBean.getBoard_name());
						pstmt.setNString(2, boardBean.getBoard_pass());
						pstmt.setNString(3, boardBean.getBoard_subject());
						pstmt.setNString(4, boardBean.getBoard_content());
						pstmt.setNString(5, "  "); //답글에는 파일 업로드 시키지 않음
						pstmt.setInt(6, board_re_ref);
						pstmt.setInt(7, board_re_lev);
						pstmt.setInt(8, board_re_seq);
						result = pstmt.executeUpdate();
						
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return result;
			}
			
			
}
















