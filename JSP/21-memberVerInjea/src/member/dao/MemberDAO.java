package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.bean.MemberDTO;

public class MemberDAO {
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="javaexam";
	String password = "l1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 1. driver 라이브러리가 등록되어있는지 확인
	public MemberDAO() {
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
	public int write(MemberDTO memberDTO) {
		// 자 이제 dao의 write 함수로 넘어왔네요. 우선 이 write는 반환 자료형이 int네요? 이 함수를 다 동작시키고 난다음에 어떤 int형태의 데이터를 반환시킨다는건데
		// 여기선 su라고 되어있네요. 그건 아래서 살짝 설명 드릴게요.
		int su = 0;
		//insert into member values ('홍길동', 'hong', '1234', '0', 
		// 							'hong','naver.com','010','1234','5678','경기도 수원시',sysdate)
		// 위에 적은 것 처럼 제가 아까 MemberWriteProAction.java에서 세팅한 DTO를 가지고 ?를 하나하나 채워갑니다. 그건 setString으로 채워주면 되는거겠죠?
		String sql = " insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate) ";
		conn = getConnection();
		try {
			// 아래 코드는 추가로 설명드릴 필요가 없기때문에 생략하겠습니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			
			// 자 이제 설정한 sql문을 실행시키면 oracle에서 보셨다시피 1행이 추가되었습니다. 라는 문구가 나올겁니다.
			// 그 1이라는 숫자를 바로 su가 저장하게 되는거에요.
			su = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		// 만약 5개를 추가했다면 su가 5겠죠? 근데 회원가입할때 누가 멀티로합니까.. 그냥 한개만 추가되는거죠. 여기서 su = 1이 반환되게 됩니다. 결국 지금 이 함수를
		// 처리한 결과는 1이라는거죠 그 수를 가지고 다시 MemberWriteProAction.java로 넘어가겠습니다.
		return su;
	}
	
	// 로그인 처리
	public String login(String id, String pwd) {
		String name = null;
		String sql = "select * from member where id = ? and pwd=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			// 그런 사람이 있으면 name이 널이 아니고 없으면 널
			// 여러데이터 중에 이름 꺼내온것! (name 님이 로그인하셨습니다.에 쓰려고)
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	
	// id확인
	public boolean isExistedId(String id) {
		boolean exist = false;
		String sql = "select * from member where id = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {			//rs.next() 이 true면 그런 id가 존재한다는 의미.
				exist = true;	 	//id가 있음을 나타냄
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
	
	public String passCheck(String id) {
		String password = "";
		String sql = "select * from member where id = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {			//rs.next() 이 true면 그런 id가 존재한다는 의미.
				password = rs.getString("pwd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return password;
		
	}
	
	// 회원정보 수정
		public int modify (String pwd ,String num1, String num2, String num3 , String email1, String email2, String addr, String id) {
			int su  = 0;
			String sql = "update member set pwd = ?, tel1 = ?, tel2 = ?, tel3 = ?, email1 = ?,email2 = ?, addr = ? where id = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pwd);
				pstmt.setString(2, num1);
				pstmt.setString(3, num2);
				pstmt.setString(4, num3);
				pstmt.setString(5, email1);
				pstmt.setString(6, email2);
				pstmt.setString(7, addr);
				pstmt.setString(8, id);
				su = pstmt.executeUpdate();	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 5) 오라클 서버 접속 종료
				close();
			}
			
			return su;
			
		}
		
		// 회원정보 수정
			public int modify2 (String pwd ,String num1, String num2, String num3, String id) {
				int su  = 0;
				String sql = "update member set pwd = ?, tel1 = ?, tel2 = ?, tel3 = ? where id = ?";
				conn = getConnection();
				try {
						
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pwd);
					pstmt.setString(2, num1);
					pstmt.setString(3, num2);
					pstmt.setString(4, num3);
					pstmt.setString(5, id);
					su = pstmt.executeUpdate();	
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					// 5) 오라클 서버 접속 종료
					close();
				}
				
				return su;
				
			}
			
			public List<MemberDTO> userInfo(String id) {
				MemberDTO memberDTO = new MemberDTO();
				List<MemberDTO> list = new ArrayList<MemberDTO>();
				
				String sql = "select * from member where id = ?";
				conn = getConnection();
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()) {			//rs.next() 이 true면 그런 id가 존재한다는 의미.
						memberDTO.setEmail2(rs.getString("email2"));
						memberDTO.setTel1("tel1");
						
						list.add(memberDTO);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return list;
				
			}
			
			public List<MemberDTO> selectList(int startNum, int endNum) {
				List<MemberDTO> list = new ArrayList<MemberDTO>();
				
			      String sql="select * from(select rownum rn, tt.*from(select * from member order by name asc) tt)"
			    	      		+"where rn>= ? and rn<=?";
				conn = getConnection();
				
				try {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startNum);
					pstmt.setInt(2, endNum);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {			//rs.next() 이 true면 그런 id가 존재한다는 의미.
						MemberDTO memberDTO = new MemberDTO();
						memberDTO.setName(rs.getString("name"));
						memberDTO.setId(rs.getString("id"));
						memberDTO.setGender(rs.getString("gender"));
						memberDTO.setEmail1(rs.getString("email1"));
						memberDTO.setEmail2(rs.getString("email2"));
						memberDTO.setTel1(rs.getString("tel1"));
						memberDTO.setTel2(rs.getString("tel2"));
						memberDTO.setTel3(rs.getString("tel3"));
						memberDTO.setLogtime(rs.getString("logtime"));
						
						list.add(memberDTO);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return list;
			}
			
			public int countList() {
				int listNum = 0;
				String sql = "select * from member";
				conn = getConnection();
				
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						listNum += 1;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return listNum;
			}
			
			public int delete(String id) {
				int su = 0;
				String sql = "delete member where id = ?";
				conn = getConnection();
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					
					su = pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return su;
			}
}


















