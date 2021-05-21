package score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreDAO scoreDAO;

	@Override
	public int insertScore(ScoreDTO dto) {
		return scoreDAO.insertScore(dto);
	}
	@Override
	public int updateScore(ScoreDTO dto) {
		return scoreDAO.updateScore(dto);
	}
	@Override
	public int deleteScore(ScoreDTO dto) {
		return scoreDAO.deleteScore(dto);
	}
	@Override
	public List<ScoreDTO> getScoreList(int startNum, int endNum) {
		return scoreDAO.getScoreList(startNum, endNum);
	}
	@Override
	public ScoreDTO getScore(ScoreDTO dto) {
		return scoreDAO.getScore(dto);
	}
	@Override
	public int selectListCount() {
		return scoreDAO.selectListCount();
	}
}






