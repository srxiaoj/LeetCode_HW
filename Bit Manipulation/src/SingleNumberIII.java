
public class SingleNumberIII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = new int[]{1,2,1,3,2,5};
        int a = 6;
        System.out.println("a in bit is: " + Integer.toBinaryString(a));
        int b = 5;
        System.out.println("b in bit is: " + Integer.toBinaryString(b));
        int c = a^b;
        System.out.println("the xor is " + c);
        System.out.println("xor in bit is: " + Integer.toBinaryString(c));
        c &= -c;
        System.out.println("the last different bit num is: " + c);
        System.out.println("the last different bit in bit is: " + Integer.toBinaryString(c));//2^32-1
        //System.out.println(singleNumber(test)[1]);
    }
    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num : nums){
            diff^=num;
        }
        //diff &= -diff;//get the last bit that two numbers are different
        //or you can use
        diff = (diff&(diff-1))^diff;
        int sum[] = new int[]{0,0};
        for(int num : nums){
            if((num & diff) == 0){
                sum[0]^=num;
            }
            else{
                sum[1]^=num;
            }
        }
        return sum;
    }

}
