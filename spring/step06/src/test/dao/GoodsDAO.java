package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;


@Repository
public class GoodsDAO {

	JDBCUtil util = new JDBCUtil();

	// JDBC 관련 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// sql명령문
	String sql_insert = "insert into goods values(?,?,?,?)";
	String sql_delete = "delete goods where code=?";
	String sql_get = "select * from goods where code=?";
	String sql_list = "select * from goods ";

	/* CRUD 기능의 메소드 구현 */
	// 책등록
	public int insetGoods(GoodsVO vo) {
		int result = 0;
		conn = util.getConnection();

		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(null, pstmt, conn);
		}
		return result;
	}

	// 책 삭제
	public int deleteGoods(GoodsVO vo) {
		int result = 0;
		conn = util.getConnection();

		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(null, pstmt, conn);
		}
		return result;
	}

	// 책 1권 데이터 상세 조회
	public GoodsVO getGoods(GoodsVO vo) {
		int result = 0;
		GoodsVO goodsVO = null ;
		conn = util.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_get);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				goodsVO= new GoodsVO();
				goodsVO.setCode(rs.getString("code"));
				goodsVO.setName(rs.getString("name"));
				goodsVO.setPrice(rs.getInt("price"));
				goodsVO.setMaker(rs.getString("maker"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return goodsVO;
	}

	// list
	public List<GoodsVO> getGoodsList() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		conn = util.getConnection();
		try {

			pstmt = conn.prepareStatement(sql_list);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
				// 리스트에 저장
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return list;
	}

}
