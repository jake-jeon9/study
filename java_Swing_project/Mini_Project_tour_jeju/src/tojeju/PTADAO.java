package tojeju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PTADAO {


	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public PTADAO() {
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
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public int insertMyReview(DTOTourismArea placeTourismArea) {
		int su=0;
		String sql = "insert into category values (?,?,?,?,sysdate)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeTourismArea.getSubject());
			pstmt.setString(2, placeTourismArea.getId());
			pstmt.setString(3, placeTourismArea.getReview());
			pstmt.setString(4, placeTourismArea.getRating());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	public List<DTOTourismArea> getReviewList(String subject){
		List<DTOTourismArea> list = new ArrayList<DTOTourismArea>();
		String sql = "select * from category where subject = ?";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTOTourismArea dTOTourismArea = new DTOTourismArea();
				dTOTourismArea.setSubject(rs.getString("subject"));
				dTOTourismArea.setId(rs.getString("id"));
				dTOTourismArea.setReview(rs.getString("review"));
				dTOTourismArea.setRating(rs.getString("rating"));
				dTOTourismArea.setTime(rs.getString("logtime"));
				list.add(dTOTourismArea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	public DTOTourismArea getDReviewList(){
		DTOTourismArea dto= null;
		String sql = "select * from category ";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String subject = rs.getString("subject");
				String id = rs.getString("id");
				String review = rs.getString("review");
				String rating = rs.getString("rating");
				String logtime = rs.getString("logtime");
				dto= new DTOTourismArea(subject,id,review,rating,logtime);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	public int addComment(String subject,String id,String review){
		int su=0;
		String review1 = "";
		DTOTourismArea dto= null;
		String sql = " insert into categoryreview values (?,?,?)";
		
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, id);
			pstmt.setString(3, review);
			rs = pstmt.executeQuery();
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return su;
	}
	public List<DTOCategoryComments> getCommentsList(String subject){
		List<DTOCategoryComments> list = new ArrayList<DTOCategoryComments>();
		String sql = "select * from categoryreview where subject = ?";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTOCategoryComments dTOCategoryComments = new DTOCategoryComments();
				dTOCategoryComments.setSubject(rs.getString("subject"));
				dTOCategoryComments.setId(rs.getString("id"));
				dTOCategoryComments.setComments(rs.getString("comments"));
				list.add(dTOCategoryComments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	
}
