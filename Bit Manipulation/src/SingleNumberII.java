/**
 * Created by thanksgiving on 4/25/16.
 */
public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII obj = new SingleNumberII();
        int[] nums = {1, 2, 2, 2, 3, 4, 3, 3, 4, 4, 5, 5, 5};
        System.out.println(obj.singleNumber(nums));
    }

    /**
     *The usual bit manipulation code is bit hard to get and replicate. I like to think about the number in 32 bits
     *and just count how many 1s are there in each bit, and sum %= 3 will clear it once it reaches 3.
     * After running for all the numbers for each bit, if we have a 1, then that 1 belongs to the single number,
     * we can simply move it back to its spot by doing ans |= sum << i
     * This has complexity of O(32n), which is essentially O(n) and very easy to think and implement.
     * Plus, you get a general solution for any times of occurrence. Say all the numbers have 5 times, just do sum %= 5
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                int temp = nums[j] >> i;
                if((temp & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }
}
