package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back5622 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = br.readLine().split("");
		int timer = 0;
		for (int i = 0 ; i < strs.length;i++) {
			//System.out.println("���� : "+strs[i]);
			int convertNum = (int)strs[i].charAt(0);
			//System.out.println("���� : "+convertNum);
			
			if(strs[i].equals("0")){//0
				timer +=11;
			}else if(strs[i].equals("1")){//1
				timer +=2;
			}else if(convertNum<68) {//abc
				timer +=3;
			}else if(convertNum<71){//def
				timer +=4;
			}else if(convertNum<74){//ghi
				timer +=5;
			}else if(convertNum<77){//jkl
				timer +=6;
			}else if(convertNum<80){//mno
				timer +=7;
			}else if(convertNum<84){//pqrs
				timer +=8;
			}else if(convertNum<87){//tuv
				timer +=9;
			}else if(convertNum<91){//wxyz
				timer +=10;
			}
		}
		System.out.println(timer);
		
	}
}
