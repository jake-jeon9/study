package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;
	//<bean id="goodsService" class="test.service.goodsServiceImpl">
	//	<property name="GoodsDAO" ref="goodsDAO"/>
	//</bean>
	//컴포턴트는 빈태그 설정
//@component와 같은 어노테이션
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	
	//autowired는 property역할
	@Autowired
	private GoodsDAO goodsDAO;
	
	@Override
	public int insertGoods(GoodsVO vo) {
		return goodsDAO.insetGoods(vo);
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
