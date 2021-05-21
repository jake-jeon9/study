package test4;

import java.util.Scanner;

public class SungjukImpl implements Sungjuk{

	SungjukDTO dto;
	
	public SungjukImpl(SungjukDTO dto) {
		super();
		this.dto = dto;
	}

	public SungjukDTO getDto() {
		return dto;
	}

	public void setDto(SungjukDTO dto) {
		this.dto = dto;
	}

	public SungjukImpl() {
	}
	
	@Override
	public void calcTot() {
		dto.setTot(dto.getKor()+dto.getEng()+dto.getMath());
		
	}

	@Override
	public void calcAvg() {
		dto.setAvg((dto.getKor()+dto.getEng()+dto.getMath())/3.0);
	}

	@Override
	public void display() {
		System.out.println();
		System.out.println("이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t",dto.getName(),dto.getKor(),dto.getEng(),dto.getMath(),dto.getTot(),dto.getAvg());
		System.out.println();
		System.out.println();
	}

	@Override
	public void modify() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		dto.setName(sc.next());
		System.out.print("국어 입력 : ");
		dto.setKor(sc.nextInt());
		System.out.print("영어 입력 : ");
		dto.setEng(sc.nextInt());
		System.out.print("수학 입력 : ");
		dto.setMath(sc.nextInt());
		
		calcTot();
		calcAvg();
		
	}

}
