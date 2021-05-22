package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardBean;

import java.sql.ResultSet;


import member.bean.MemberDTO;

//서버 연결
public class MemberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="javaexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//드라이버 라이브러리가 등록되었는지 확인
	public MemberDAO() {
		try {
			Class.forName(driver);//라이브러리가 등록되어 있는지 확인( jar파일 )
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//커넥션 객체 얻기
	public Connection getConnection() {
		try {
			conn= DriverManager.getConnection(url,user,password);//연결 셋팅
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return conn;	
	}
	//커넥션 객체 닫기
	public void close() {
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null)pstmt.close();
			if(conn !=null)	conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	//데이터 추가하기
	public int write(MemberDTO memberDTO) {
		int su = 0;
		String sql="insert into member1 values(?,?,?,?,?,?,?,?,?,?,sysdate)";
		conn=getConnection();//접속 시도
		//System.out.println(conn);
		try {
			//System.out.println(sql);
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPw());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return su;
		}
	
	//데이터 처리(로그인)
	public String login(String id,String pw) {
		String name=null;
		
		String sql="select * from member1 where id =? and pw=?";
		conn=getConnection();
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return name;
	}
	
	//데이터 처리(로그인)
	public boolean checkId(String id) {
		boolean exist = false; 
//		String chId=null;
		
		String sql="select * from member1 where id =?";
		conn=getConnection();
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//			chId = rs.getString("id");
			exist = true; //re.next() 가 트루이면 while이 작동해서 exist 값을
			//true를 반환하고 종료됨. 없다면 while함수가 작동되지 않아서 default값인 false가 리턴
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return exist;
	}
	
	//회원정보 가져오기
	
	public MemberDTO getMyInfo(String id) {
		MemberDTO memberDTO = new MemberDTO();
		String sql="select * from member1 where id = ?";
		conn=getConnection();
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				memberDTO.setId(rs.getString("id"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setAddr(rs.getString("addr"));
				memberDTO.setLogtime(rs.getString("logtime"));
				memberDTO.setPw(rs.getString("pw"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return memberDTO;
		}
	
	//회원정보 수정하기
	public int EditMyInfo(MemberDTO memberDTO) {
		int su = 0;	//처리 결과 저장
		String sql="update member1 set tel1=?, tel2=?, tel3=? where id=?";
		conn=getConnection();
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getTel1());
			pstmt.setString(2, memberDTO.getTel2());
			pstmt.setString(3, memberDTO.getTel3());
			pstmt.setString(4, memberDTO.getId());
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return su;
		
	}
		//총 맴버수  얻기
		public int getTotalMember() {
			int totalMember = 0;	//처리 결과 저장
			String sql="select count(*) as cnt from member1";
			conn = getConnection();
			try {
				pstmt =conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					totalMember=rs.getInt("cnt");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return totalMember;
			}
		
	public List<MemberDTO> memberList(int startNum, int endNum){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO memberDTO;
		//String sql="select * from member1";
		String sql="select * from(select rownum rn, tt.*from(select * from member1 order by name asc) tt)"+
		"where rn>= ? and rn<=?";
		conn=getConnection();
	
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs=pstmt.executeQuery();
			
		while(rs.next()) {
			memberDTO=new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setGender(rs.getString("gender"));
			memberDTO.setEmail1(rs.getString("email1"));
			memberDTO.setEmail2(rs.getString("email2"));
			memberDTO.setTel1(rs.getString("tel1"));
			memberDTO.setTel2(rs.getString("tel2"));
			memberDTO.setTel3(rs.getString("tel3"));
			memberDTO.setAddr(rs.getString("addr"));
			memberDTO.setLogtime(rs.getString("logtime"));
			memberDTO.setPw(rs.getString("pw"));
			
			//리스트에 저장
			list.add(memberDTO);
			//System.out.println("리스트 사이즈 : "+list.size());
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		close();
	}
	
	return list;
	}
	
	//회원정보삭제
	public int DeleteMyInfo(String id) {
		int result = 0;	//처리 결과 저장
		String sql="delete member1 where id =?";
		conn=getConnection();
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return result;
		
	}
	
}
