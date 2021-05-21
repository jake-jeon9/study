package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;

/*
 * <bean id=scoreSerivce" class="test.service.ScoreServiceImpl"> <-@Service
 * 	<property name="scoreDAO" ref="scoreDAO"/> <- @autoWired
 * </bean> 
 * 
 * 오토 와이드를 하려려면 대상 객체가 반드시 빈 객체여야함( 실제 scoreDAO는 빈객체(repository로 설정함)
 * 
 * 	main() 함수에서 일반적인 방법으로 객체 생성할 경우
 * 	ScoreSerivceImpl scoreSerivce = new ScoreSerivceImpl();
 * 	scoreSerivce.setScoreDAO(scoreDAO);
 */

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	private ScoreDAO scoreDAO;
	
	@Override
	public int insertData(ScoreVO vo) {
		return scoreDAO.insertData(vo);
	}

	@Override
	public int deleteData(ScoreVO vo) {
		return scoreDAO.deleteData(vo);
	}

	@Override
	public ScoreVO getData(ScoreVO vo) {
		return scoreDAO.getData(vo);
	}

	@Override
	public List<ScoreVO> getList() {
		return scoreDAO.getList();
	}

	@Override
	public int updataData(ScoreVO vo) {
		return scoreDAO.updataData(vo);
	}

}
