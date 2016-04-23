
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 1, 3, 2, 5};
        int a = 3;
        System.out.println("a in bit is: " + Integer.toBinaryString(a));
        int b = 5;
        System.out.println("b in bit is: " + Integer.toBinaryString(b));
        int c = a ^ b;
        System.out.println("a xor b is " + c);
        System.out.println("a xor b in bit is: " + Integer.toBinaryString(c));
        c &= -c;
        System.out.println(Integer.toBinaryString(-c));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("the last different bit num is: " + c);
        System.out.println("the last different bit in bit is: " + Integer.toBinaryString(c));//2^32-1
//        System.out.println(singleNumber(test)[1]);
    }

    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
//        System.out.println("After xor " + diff);
        diff &= -diff;//get the last bit that two numbers are different
        //or you can use
//        diff = (diff & (diff - 1)) ^ diff;
//        System.out.println("Get last different bit " + diff);
        int sum[] = new int[]{0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                sum[0] ^= num;
            } else {
                sum[1] ^= num;
            }
        }
        return sum;
    }

}
