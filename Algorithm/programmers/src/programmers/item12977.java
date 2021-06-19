package programmers;

public class item12977 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
	    int answer =0;

        for(int a = 0; a<nums.length-2;a++){
            for(int b =a+1;b<nums.length-1;b++){
                for(int c = b+1;c<nums.length;c++){
                    int num = nums[a]+nums[b]+nums[c];
                    if(!isPre(num)) answer ++;
                }
            }
        }
        
        System.out.println(answer);

	}
	 public static boolean isPre(int num){
	        for(int i =2;i<=Math.sqrt(num);i++){
	            if(num%i == 0) return true;
	        }

	        return  false;
	    }
}
