package programmers;

public class makeId {
	public static String solution() {
		
	
//		String new_id = "z-+.^.";
//		String new_id = "=.=";
//		String new_id ="123_.def";
		String new_id = "";
//		String new_id = "...!@BaT#*..y.abcdefghijklm";

		return new_id;
	}
public static void main(String[] args) {
	String new_id =solution();
	 String answer = "";
	
	 //1�ܰ� 
	 new_id = new_id.toLowerCase();
	 String copy="";
	 
	 //2�ܰ�
	 for(int i = 0;i<new_id.length();i++) {
		 char item = new_id.charAt(i);
		 
		 if(Character.isDigit(item)) {
			 copy+= item;
		 }else if(Character.isAlphabetic(item)) {
			 copy+= item;
		 }else if(item == '-' || item =='_' || item== '.') {
			copy+= item;
			 
		 }
	 }
	 /*
	  
	    id = id.replaceAll("[^-_.a-z0-9]", ""); //-_. ������ ���ڸ� ���� 
        id = id.replaceAll("[.]{2,}", "."); // .2�� �̻� .���� 
        id = id.replaceAll("^[.]|[.]$", ""); // ó���� �� . ���� 
	  */
	 
	 
	 new_id=copy;

	 //3�ܰ�
	 while(new_id.contains("..")) {
		 new_id = new_id.replace("..", ".");
	 }


	 //4�ܰ�
	if(new_id.startsWith(".")) {
		 new_id = new_id.substring(1);
	}
	if(new_id.endsWith(".")) {
		new_id = new_id.substring(0,new_id.length()-1);
	}
		 

	
	 //5�ܰ�
	 if(new_id.length()==0) {
		 new_id = "a"; 
	 }
	 //6�ܰ�
	 if(new_id.length()>=16) {
		 new_id = new_id.substring(0,15);
		 if(new_id.charAt(new_id.length()-1)=='.') {
			 new_id = new_id.substring(0,new_id.length()-1);
		 }
	 }
	 //7�ܰ�
	 if(new_id.length()<=2) {
		 String last = new_id.charAt(new_id.length()-1)+"";
		 while (new_id.length()<3) {
			 new_id += last;
		 }
		 
	 }
	 System.out.println(new_id);
	 
	 
}
}
