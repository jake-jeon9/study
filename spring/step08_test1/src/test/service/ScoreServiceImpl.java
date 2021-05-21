package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

public class ScoreServiceImpl implements ScoreService  {


	ScoreDAOSpring scoreDAOSpring;
	
	
	public ScoreDAOSpring getScoreDAOSpring() {
		return scoreDAOSpring;
	}

	public void setScoreDAOSpring(ScoreDAOSpring scoreDAOSpring) {
		this.scoreDAOSpring = scoreDAOSpring;
	}

	@Override
	public int insertData(ScoreVO vo) {
		
		return scoreDAOSpring.insertData(vo);
	}

	@Override
	public int deleteData(ScoreVO vo) {
		return scoreDAOSpring.deleteData(vo);
	}

	@Override
	public ScoreVO getData(ScoreVO vo) {
		return scoreDAOSpring.getData(vo);
	}

	@Override
	public List<ScoreVO> getList() {
		return scoreDAOSpring.getList();
	}

	@Override
	public int updataData(ScoreVO vo) {
		return scoreDAOSpring.updataData(vo);
	}

}
