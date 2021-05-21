package test02;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

	
	private GoodsDAO goodsDAO;
	
	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	@Override
	public int insertGoods(GoodsVO vo) {
		return goodsDAO.insertGoods(vo);
	}

	@Override
	public int deleteGoods(GoodsVO vo) {
		return goodsDAO.deleteGoods(vo);
	}

	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return goodsDAO.getGoods(vo);
	}

	@Override
	public List<GoodsVO> getGoodsList() {
		return goodsDAO.getGoodsList();
	}

}
