package main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import bean.ScoreVO;
import service.ScoreServiceImpl;



public class ver2HelloSpring {

	Scanner sc = new Scanner(System.in);
	ScoreVO vo;
	
	
	ScoreServiceImpl scoreService;

	public ScoreServiceImpl getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreServiceImpl scoreService) {
		this.scoreService = scoreService;
	}

	// 메뉴
	public void menu() {
		int result = 0;

		while (true) {
			do {
				System.out.println();
				System.out.println("1.입력");
				System.out.println("2.출력");
				System.out.println("3.검색");
				System.out.println("4.수정");
				System.out.println("5.삭제");
				System.out.println("6.종료");
				System.out.println("--------");
				System.out.print("번호 입력 : ");
				result = sc.nextInt();

			} while (result > 6 || result < 1);

			if (result == 6) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}

			switch (result) {
			case 1:
				score_insert();
				break; // 입력
			case 2:
				score_list();
				break; // 출력
			case 3:
				score_search();
				break; // 검색
			case 4:
				score_update();
				break; // 수정
			case 5:
				score_delete();
				break; // 삭제
			case 6:
				System.out.println("시스템종료 by case5");
				return;
			}

		}

	}	
	public void score_search() {
		
		vo = new ScoreVO();
		System.out.print("검색할 학생코드를 입력해주세요 : ");
		vo.setStudNo(sc.next());
		System.out.println("-----------------------");
		System.out.println("      학번\t 이름\t 국어\t 영어\t 수학\t 합계\t 평균\t 로그타임\t");
		try {
			vo = scoreService.getData(vo);	
			System.out.println(vo.toString());
		}catch(Exception e) {
			try {
			System.out.println(vo.toString());
			}catch(Exception k){
				System.out.println("vo.toString() 은 null일때");
			}
			
			System.out.println("출력할 데이터가 없습니다.");
		}
		
	}
	
	// 입력
	public void score_insert() {
		vo = new ScoreVO();
		try {
			System.out.print("학생 넘버 : ");
			vo.setStudNo(sc.next());
		} catch (Exception e) {
			System.out.println(vo.getStudNo() + "는 이미 등록된 학생번호 입니다. ");
		}

		System.out.print("학생 이름 : ");
		vo.setName(sc.next());
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		vo.setTot(vo.getKor() + vo.getEng() + vo.getMat());
		vo.setAvg(vo.getTot() / 3.0);

		int getResult = scoreService.insertData(vo);

		if (getResult > 0) {
			System.out.println("학생코드 : " + vo.getStudNo() + " 데이터가 정상적으로 등록되엇습니다.");
		} else {
			System.out.println("학생코드 : " + vo.getStudNo() + " 등록 실패..");
		}

	}

	// 수정
	public void score_update() {
		vo = new ScoreVO();
		System.out.print("수정할 학생코드를 입력해주세요 : ");
		vo.setStudNo(sc.next());
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		vo.setTot(vo.getKor() + vo.getEng() + vo.getMat());
		vo.setAvg(vo.getTot() / 3.0);

		int getResult = scoreService.updataData(vo);

		if (getResult > 0) {
			System.out.println("학생코드 : " + vo.getStudNo() + " 업데이트 성공");
		} else {
			System.out.println("학생코드 : " + vo.getStudNo() + " 업데이트 실패..");
		}

	}

	// 삭제
	public void score_delete() {
		vo = new ScoreVO();
		System.out.print("삭제할 학생코드를 입력해주세요 : ");
		vo.setStudNo(sc.next());

		int getResult = scoreService.deleteData(vo);

		if (getResult > 0) {
			System.out.println("학생코드 : " + vo.getStudNo() + " 삭제 성공");
		} else {
			System.out.println("학생코드 : " + vo.getStudNo() + " 삭제 실패..");
		}

	}

	// 목록보기
	public void score_list() {
//		System.out.println("1.전체 출력");
//		System.out.println("2.개별출력");
//		System.out.print("입력 : ");
//
//		int getResult = sc.nextInt();

//		if (getResult == 1) {
			System.out.println("-----------------------");
			System.out.println("     학번\t   이름\t 국어\t 영어\t 수학\t 합계\t 평균\t 로그타임\t");
			List<ScoreVO> list = scoreService.getList();

			for (ScoreVO vo1 : list) {
				if (list.size() == 0) {
					System.out.println("데이터가 없습니다.");
				} else {
					System.out.println(vo1.toString());
				}
			}
//		} else if (getResult == 2) {
//			vo = new ScoreVO();
//			System.out.print("검색할 학생코드를 입력해주세요 : ");
//			vo.setStudNo(sc.next());
//			System.out.println("-----------------------");
//			System.out.println("      학번\t 이름\t 국어\t 영어\t 수학\t 합계\t 평균\t 로그타임\t");
//			try {
//				vo = scoreService.getData(vo);	
//				System.out.println(vo.toString());
//			}catch(Exception e) {
//				System.out.println("출력할 데이터가 없습니다.");
//			}
//
//		}else {
//			System.out.println("잘못입력됨.");
//		}

	}

	// 스테틱은 함수가 독립함수 이기 때문에 해당 클래스를 받을 수 있음.
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");

		ver2HelloSpring helloSpring = (ver2HelloSpring) context.getBean("ver2HelloSpring");
		
		
		
		helloSpring.menu();

		context.close();

	}

}
