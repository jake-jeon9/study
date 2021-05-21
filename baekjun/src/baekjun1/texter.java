package baekjun1;

import java.util.Scanner;

public class texter {
	public static void main (String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    
	    String [] cro = { "c=" , "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
	    int ans = 0;
	    char [] s = sc.next().toCharArray();
	    
	    for(int i = 0 ;i+1 < s.length ; i++){
	        
	       String sum = new String( ""+s[i]+s[i+1] );  
	       //System.out.println(sum);
	       //      System.out.println(i);
	       
	       for(int j = 0 ; j < cro.length; j++){
	            if (sum.equals("z=") && i > 0){
	               if( (""+s[i-1]+sum).equals("dz=")   ){
	                   //System.out.println(cro[j]+"//"+sum+":"+i);
	                    i = i+1;
	                    ans--;
	                    break;
	               }else {
    	               i = i+1;
    	                // System.out.println(cro[j]+"//"+sum+":"+i+":"+j);
    	               break;
	               }
	           }else if( cro[j].equals(sum) ){
	              // System.out.println(cro[j]+"//"+sum+":"+i+":"+j);
	               i = i+1;
	               break;
	           }
	       }
            
	       if(i+1 == s.length-1 ){
	           //System.out.println("������");
	           ans++;
	       }
	       ans++;
	    }
	    
	    //System.out.println(Arrays.toString(cro));
	  // System.out.println(Arrays.toString(s));
	    System.out.println(ans);
	}
}
