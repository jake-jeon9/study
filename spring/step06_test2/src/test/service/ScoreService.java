package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	/* CRUD 기능의 메소드 구현*/
	//성적등록
	int insertData(ScoreVO vo);
	//성적 삭제
	int deleteData(ScoreVO vo);
	//1명 정보얻기
	ScoreVO getData(ScoreVO vo);
	//모든 정보 얻기
	List<ScoreVO> getList();
	//데이터 수정
	int updataData(ScoreVO vo);
	
}
