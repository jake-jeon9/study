package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baek1316 {
public static void main(String[] args) throws Exception{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int index = Integer.parseInt(br.readLine());
	String[] items = new String[index];
	int itemCount = items.length;
	for (int i = 0 ; i<index ; i++){
		items[i] = br.readLine();
	}
	for (int i = 0 ; i<index ; i++){
	String chars[] = items[i].split("");
	List<String> list = new ArrayList<>();
	
	for(int k =0; k<chars.length;k++) {
		//System.out.println("���� K? "+k);
		if(chars[k].length()==0) {
			//System.out.println("ũ�� 0����");
			itemCount -=1;
			continue;
		}
		if(!list.contains(chars[k])) {
			//System.out.println("���� ����Ʈ : "+chars[k]);
			list.add(chars[k]);
		}else {
			if(chars[k].equals(chars[k-1])) {
				//System.out.println("������ ���� :"+chars[k-1]);
//				k+=1;
				continue;
			}else {
				//System.out.println("������ �ٸ�:"+chars[k-1]);
				itemCount -=1;
				break;
			}
			
		}
		
	}
	}
	System.out.println(itemCount);
	
	
}

}
