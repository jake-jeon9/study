package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value = "/score/scoreWriteForm.do")
	public ModelAndView scoreWriteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("scoreWriteForm.jsp");				
		return modelAndView;
	}
	@RequestMapping(value = "/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		request.setCharacterEncoding("UTF-8");	// 한글 설정
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
		// DB
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		
		//ScoreDAO scoreDAO = new ScoreDAO();
		int result = scoreService.insertScore(dto);	
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scoreWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 목록 : 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		//ScoreDAO scoreDAO = new ScoreDAO();
		List<ScoreDTO> list = scoreService.getScoreList(startNum, endNum);
		
		// 페이징 : 3블럭
		int listCount = scoreService.selectListCount();  // 총 저장 데이터 수
		int maxPage = (listCount + 4) / 5;			 // 총 페이지 수
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > maxPage) endPage = maxPage;
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("maxPage", maxPage);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("scoreList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		//ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		dto = scoreService.getScore(dto);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("scoreView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		String studNo = request.getParameter("studNo");
		// DB
		//ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		int su = scoreService.deleteScore(dto);
		
		// 화면 네비게이션 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("scoreDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreModifyForm.do")
	public ModelAndView scoreModifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB
		//ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		scoreDTO = scoreService.getScore(scoreDTO);
		
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("scoreDTO", scoreDTO);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreModifyForm.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/score/scoreModify.do")
	public ModelAndView scoreModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터
		request.setCharacterEncoding("UTF-8");  // 한글 설정
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int pg = Integer.parseInt(request.getParameter("pg"));
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
//		System.out.println("studNo = " + studNo);
//		System.out.println("name = " + name);
//		System.out.println("pg = " + pg);
//		System.out.println("kor = " + kor);
//		System.out.println("eng = " + eng);
//		System.out.println("mat = " + mat);
		
		// 2. DB
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo); 
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		//ScoreDAO scoreDAO = new ScoreDAO();
		int result = scoreService.updateScore(dto);
		
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreModify.jsp");
		return modelAndView;
	}
}













