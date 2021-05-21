package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class back2869 {
	public static void main(String[] args) throws Exception {
		System.out.println("���� ����");
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] items = br.readLine().split(" ");
		double days;
		int A = Integer.parseInt(items[0]); // ���� �ö󰡴°Ÿ�
		int B = Integer.parseInt(items[1]); // �㿡 �̲������� �Ÿ�
		int V = Integer.parseInt(items[2]); // ��ǥ�Ÿ�
		
		//days = V / A-B;
		//-> �̷��ԵǸ� �����ϱ� �̲����� �Ϸ縦 �� �����.
		days = (V-B) / (A-B);

		// �̷��� �ϸ� ���� �������� ������ ������ .
		//days �̰� ������ �ƴҰ�� �Ϸ簡 �����ϰ� ��.
		int newdays = (int) Math.ceil(days);
		

		
		bw.write(newdays+"");
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		bw.flush();
		bw.close();
		
	}
}
/*

		while(true) {
			int AT = A*days;
			int BT = B*(days-1);
			if(AT-BT >= V) {
				break;
			}else {
				days++;	
			}
					
		}
		// 2 1 5 


*/