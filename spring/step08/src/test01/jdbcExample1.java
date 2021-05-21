package test01;


import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


public class jdbcExample1 {
	public static void main(String[] args) {
		//1.spring container
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		//2. get service
		GoodsService goodsService =(GoodsService) context.getBean("goodsService");

		
		//3.enrollment book
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0002");
		vo.setName("Java2");
		vo.setPrice(20000);
		vo.setMaker("6666한샘출판사1");
		
		int result = goodsService.insertGoods(vo);
		if(result >0) {
			System.out.println("저장성공");
		}else {
			System.out.println("저장실패");
		}
		
		//4. list of books
		List<GoodsVO> list =goodsService.getGoodsList();
		for(GoodsVO vo1 : list) {
			System.out.println("--->" + vo1.toString());
		}
		
		//5.close spring container
		context.close();
	}
}
