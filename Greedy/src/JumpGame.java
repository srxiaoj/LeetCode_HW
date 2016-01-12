
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] test = new int[]{2, 3, 1, 1, 4};
		int [] test2 = new int[]{3, 2, 1, 0, 4};
		System.out.println("this can be done ? " + canJump(test));
		System.out.println("this can be done ? " + canJump(test2));
	}
	public static boolean canJump(int[] nums) {
        //method 1
		//record the maximum distance currently can be reached
		int max = 0;
		int n = nums.length;
		//i has to less than the current maximum distance, otherwise we cannot reach i in the next jump
		for(int i = 0; i<=max && i < n; i++){
			if(nums[i] + i > max)
				max= nums[i]+i;
		}
		return max >= n-1;
		//method 2
		/*
		int n = nums.length;
        int last = n-1;
        
        for(int i = n-2; i>=0; i--){
        	if(i+nums[i] >= last)//if you can reach the last index from i, now i is the latest last index
        		last = i;
        }
        return last <= 0;
        */
    }

}
