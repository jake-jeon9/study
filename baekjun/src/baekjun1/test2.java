package baekjun1;

import java.util.Scanner;

public class test2 {
public static void main(String[] args)  {
	
	Scanner scan = new Scanner(System.in); 
	int num; 
	String str; 
	System.out.print("num �Է�> ");
	num = scan.nextInt();
	scan.nextLine(); //���๮��(����)�� �����ϱ����� �߰� 
	System.out.print("str �Է�> "); 
	str = scan.nextLine(); 
	System.out.println(); 
	System.out.println("num : " + num); 
	System.out.println("str : " + str); 
	scan.close();

}

}