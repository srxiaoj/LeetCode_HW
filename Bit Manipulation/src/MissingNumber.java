
public class MissingNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = new int[]{0,1,2,3};
        System.out.println("result is: " + missingNumber(test));
        System.out.println(3^3);
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for(int i = 0; i < n; i++){
            res ^= nums[i];
            res ^= (i);
        }
        return res;
    }

}
