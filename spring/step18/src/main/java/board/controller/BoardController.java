package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		/* DB */
		// 1. 목록 가져오기
		// => 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		//BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardService.boardList(startNum, endNum);
		
		// 2. 페이징 처리
		// => 3블럭
		int totalA = boardService.getTotalA();  // 총 글수
		int totalP = (totalA + 4) / 5; 		// 총 페이지수
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("../board/boardList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		//BoardDAO boardDAO = new BoardDAO();	
		boardService.updateHit(seq); // 조회수 증가
		BoardDTO boardDTO = boardService.boardView(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.setViewName("../board/boardView.jsp"); 
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView boardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../board/boardWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) {
		// 데이터 처리
		// 한글 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");

		// DB
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setName(name);
		boardDTO.setId(id);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardWrite(boardDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("../board/boardWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardDelete(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("../board/boardDelete.jsp");
		
		return modelAndView;
	}
}























