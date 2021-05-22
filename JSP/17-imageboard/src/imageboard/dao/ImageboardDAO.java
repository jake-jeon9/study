package imageboard.dao;

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

import imageboard.bean.ImageboardDTO;


public class ImageboardDAO {

	Connection conn;		//오라클서버와 접속하는 클래스
	PreparedStatement pstmt;//보조  스트림클래스, 오라클 서버와 데이터 처리
	ResultSet rs;			//select문 처리결과값을 사용하는 인터페이스
	DataSource ds;			//커넥션 풀을 담당하는 클래스 (import javax.sql.DataSource)
	
	//1. 톰캣서버로부터 dataSource 객체 얻어오기
	public ImageboardDAO() {
		//import javax.naming.Context;
		try {
			Context context = new InitialContext();// context.xml 파일을 읽어옴
			//톰캣인 경우 DataSource객체를 찾을 경우,
			//반드시 커넥션 풀 설정 앞에,"java:comp/env/"를 붙여줘야 한다.
			//이것의 의미는 context.xml-> <Context> -> <Resource> -> "name"
			//속성까지를 나타낸다.
			ds= (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
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
		//insert : 글저장
	public int writeContent(ImageboardDTO imageboardDAO) {
		int su = 0;	//처리 결과 저장
		String sql="insert into imageboard values(seq_imageboard.nextval,?,?,?,?,?,?,sysdate)";

		//conn=getConnection();//접속 시도 (커넥션 풀 사용으로 주석처리)
		try {
			//1)오라클 서버에 접속
			conn = ds.getConnection();
			//2) prepareStatement객체 생성
			pstmt =conn.prepareStatement(sql);
			//3) sql문 완성
			pstmt.setString(1, imageboardDAO.getImageId());
			pstmt.setString(2, imageboardDAO.getImageName());
			pstmt.setInt(3, imageboardDAO.getImagePrice());
			pstmt.setInt(4, imageboardDAO.getImageQty());
			pstmt.setString(5, imageboardDAO.getImageContent());
			pstmt.setString(6, imageboardDAO.getImage1());
			//4) 서버에 데이터 처리 요청 -> 처리결과를 pstmt가 받음
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return su;
		}
	
	public List<ImageboardDTO> imageboardList(int startNum, int endNum){
		List<ImageboardDTO> list = new ArrayList<ImageboardDTO>();
	String sql="select SEQ, IMAGEID, IMAGENAME, IMAGEPRICE, IMAGEQTY, "
			+ "IMAGECONTENT, IMAGE1, to_char(logtime, 'YYYY.MM.DD') "
			+ "as logtime from (select rownum rn, tt. * from"
			+ " (select * from IMAGEBOARD order by seq desc) tt)"
			+ " where rn>=? and rn<=?";
	
	try {
		//1)오라클 서버에 접속
		conn = ds.getConnection();
		//2) prepareStatement객체 생성
		pstmt =conn.prepareStatement(sql);
		//3) sql문 완성
		pstmt.setInt(1, startNum);
		pstmt.setInt(2, endNum);
		//4) 서버에 데이터 처리 요청 -> 처리결과를 pstmt가 받음
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			ImageboardDTO imageboardDTO = new ImageboardDTO();
			imageboardDTO.setSeq(rs.getInt("seq"));
			imageboardDTO.setImageId(rs.getString("imageId"));
			imageboardDTO.setImageName(rs.getString("imageName"));
			imageboardDTO.setImageContent(rs.getString("imageContent"));
			imageboardDTO.setImage1(rs.getString("image1"));
			imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
			imageboardDTO.setImageQty(rs.getInt("imageQty"));
			
			//리스트에 저장
			list.add(imageboardDTO);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		close();
	}
	
	return list;
	}
	
	//총 글수 얻기
		public int getTotalA() {
			int totalA = 0;	//처리 결과 저장
			String sql="select count(*) as cnt from IMAGEBOARD";
			try {
				conn = ds.getConnection();
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
		
		//1개의 데이터 얻기
		public ImageboardDTO getView(int seq) {
			ImageboardDTO imageboardDTO = new ImageboardDTO();
			String sql="select * from imageboard where seq=?";
			try {
				conn = ds.getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					imageboardDTO.setSeq(rs.getInt("seq"));
					imageboardDTO.setImageId(rs.getString("imageId"));
					imageboardDTO.setImageName(rs.getString("imageName"));
					imageboardDTO.setImageContent(rs.getString("imageContent"));
					imageboardDTO.setImage1(rs.getString("image1"));
					imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
					imageboardDTO.setImageQty(rs.getInt("imageQty"));
					imageboardDTO.setLogtime(rs.getString("logtime"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return imageboardDTO;
			}
		
		//데이터 삭제.
		public int deleteContent(int seq) {
			int result = 0;	//처리 결과 저장
			String sql="delete imageboard where seq=?";

			try {
				conn = ds.getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return result;
			}
		
		//글수정 ( boardModify() )
		public int editContent(ImageboardDTO imageboardDTO) {
			int result = 0;	//처리 결과 저장
			
			if(imageboardDTO.getImage1()!=null) {
			
			String sql="update imageboard set  imageid=?, imagename=?, imagePrice = ?, imageQty = ? ,imagecontent=? ,"
					+"image1=? where seq = ? ";
			try {
				conn = ds.getConnection();
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1,imageboardDTO.getImageId());
				pstmt.setString(2,imageboardDTO.getImageName());
				pstmt.setInt(3,imageboardDTO.getImagePrice());
				pstmt.setInt(4,imageboardDTO.getImageQty());
				pstmt.setString(5,imageboardDTO.getImageContent());
				pstmt.setString(6,imageboardDTO.getImage1());
				pstmt.setInt(7, imageboardDTO.getSeq());
				result=pstmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			
			}else {
				String sql="update imageboard set  imageid=?, imagename=?, imagePrice = ?, imageQty = ? ,imagecontent=?  where seq = ? ";
				try {
					conn = ds.getConnection();
					pstmt =conn.prepareStatement(sql);
					pstmt.setString(1,imageboardDTO.getImageId());
					pstmt.setString(2,imageboardDTO.getImageName());
					pstmt.setInt(3,imageboardDTO.getImagePrice());
					pstmt.setInt(4,imageboardDTO.getImageQty());
					pstmt.setString(5,imageboardDTO.getImageContent());
					pstmt.setInt(6, imageboardDTO.getSeq());
					result=pstmt.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
				}finally{
					close();
				}
			}
			return result;
		}
		
}
