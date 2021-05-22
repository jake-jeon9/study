package tojeju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO() {
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
	public int insertArticle(MemberDTO memberDTO) {
		int su=0;
		String sql = "insert into member values (?,?,?,?,?)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getBirth());
			pstmt.setInt(5, memberDTO.getAge());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	public int insertDirect(String Id, String Password,String Name, String Birth, int Age) {
		int su=0;
		String sql = "insert into member values (?,?,?,?,?)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Id);
			pstmt.setString(2, Password);
			pstmt.setString(3, Name);
			pstmt.setString(4, Birth);
			pstmt.setInt(5, Age);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	public List<MemberDTO> selectList(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getString("pw"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setName(rs.getString("birth"));
				memberDTO.setName(rs.getString("age"));
				list.add(memberDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public MemberDTO searchName(String name){
		MemberDTO memberDTO = null;
			String sql = "SELECT * FROM member where name like ?";
			conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String name1 = rs.getString("name");
					String birth = rs.getString("birth");
					int age = rs.getInt("age");
					memberDTO = new MemberDTO(id,pw,name1,birth,age);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close();
			}
			
			return memberDTO;
		}
	public MemberDTO searchId(String id){
		MemberDTO memberDTO = null;
			String sql = "SELECT * FROM member where id = ?";
			conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String id1 = rs.getString("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String birth = rs.getString("birth");
					int age = rs.getInt("age");
					memberDTO = new MemberDTO(id1,pw,name,birth,age);
				}else {
					return null;	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return memberDTO;
		}
	public MemberDTO searchNameAndBirth(String name,String birth){
		MemberDTO memberDTO = null;
			String sql = "select * from member where name=? and birth = ?";
			conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, birth);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String name1 = rs.getString("name");
					String birth1 = rs.getString("birth");
					int age = rs.getInt("age");
					memberDTO = new MemberDTO(id,pw,name1,birth1,age);
				} else {
					memberDTO = null;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close();
			}
			
			return memberDTO;
		}
	public MemberDTO searchIdAndNameAndBirth(String id,String name,String birth){
		MemberDTO memberDTO = null;
			String sql = "select * from member where id = ? and name=? and birth = ?";
			conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, birth);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String id1 = rs.getString("id");
					String pw = rs.getString("pw");
					String name1 = rs.getString("name");
					String birth1 = rs.getString("birth");
					int age = rs.getInt("age");
					memberDTO = new MemberDTO(id,pw,name1,birth1,age);
				} else {
					memberDTO = null;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close();
			}
			
			return memberDTO;
		}
	public MemberDTO tryLogin(String id,String pw){
		MemberDTO memberDTO = null;
			String sql = "select * from member where id = ? and pw = ?";
			conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery();
//				System.out.println(rs);
				if(rs.next()) {
					String id1 = rs.getString("id");
					String pw1 = rs.getString("pw");
					String name1 = rs.getString("name");
					String birth1 = rs.getString("birth");
					int age = rs.getInt("age");
					memberDTO = new MemberDTO(id,pw,name1,birth1,age);
				} else {
					memberDTO = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return memberDTO;
		}
	
}
