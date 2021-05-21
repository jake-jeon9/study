package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.service.ScoreService;

public class HelloSpring {

	public static void menu(ScoreService scoreService, int result) {
		ScoreVO vo;
		Scanner sc = new Scanner(System.in);

		switch (result) {
		case 1:
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
			break;

		case 2:

			System.out.println("1.전체 출력");
			System.out.println("2.개별출력");
			System.out.print("입력 : ");

			int getResult1 = sc.nextInt();

			if (getResult1 == 1) {
				System.out.println("-----------------------");
				System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 합계\t 평균\t 로그타임\t");
				List<ScoreVO> list = scoreService.getList();

				for (ScoreVO vo1 : list) {
					if (list.size() == 0) {
						System.out.println("데이터가 없습니다.");
					} else {
						System.out.println(vo1.toString());
					}
				}
			} else if (getResult1 == 2) {
				vo = new ScoreVO();
				System.out.print("검색할 학생코드를 입력해주세요 : ");
				vo.setStudNo(sc.next());
				System.out.println("-----------------------");
				System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 합계\t 평균\t 로그타임\t");
				vo = scoreService.getData(vo);
				if (vo != null) {
					System.out.println(vo.toString());
				} else {
					System.out.println("출력할 데이터가 없습니다.");
				}

			}

			break;

		case 3:
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

			int getResult3 = scoreService.updataData(vo);

			if (getResult3 > 0) {
				System.out.println("학생코드 : " + vo.getStudNo() + " 업데이트 성공");
			} else {
				System.out.println("학생코드 : " + vo.getStudNo() + " 업데이트 실패..");
			}

			break;
		case 4:
			vo = new ScoreVO();
			System.out.print("삭제할 학생코드를 입력해주세요 : ");
			vo.setStudNo(sc.next());

			int getResult4 = scoreService.deleteData(vo);

			if (getResult4 > 0) {
				System.out.println("학생코드 : " + vo.getStudNo() + " 삭제 성공");
			} else {
				System.out.println("학생코드 : " + vo.getStudNo() + " 삭제 실패..");
			}

			break;

		}

	}

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");

		ScoreService scoreService = (ScoreService) context.getBean("scoreService");

		while (true) {
			int result = menu();

			if (result == 5) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				context.close();
			}

			menu(scoreService, result);

		}

	}

	public static int menu() {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("1.입력");
		System.out.println("2.출력");
		System.out.println("3.수정");
		System.out.println("4.삭제");
		System.out.println("5.종료");
		System.out.println("--------");
		System.out.print("번호 입력 : ");
		int result = sc.nextInt();

		return result;
	}

}
