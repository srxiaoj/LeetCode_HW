/**
 * Created by thanksgiving on 12/25/15.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();
//        System.out.println(obj.divide(2147483647, 2147483646));
        System.out.println(obj.divide(2147483647,1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        int signal;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            signal = -1;
        else
            signal = 1;
        //Math.abs(最小负数) 结果还是其本身. 在进行该运算前，要将其转化为long类型
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);//
        long result = 0;
        while (absDividend >= absDivisor) {
            long tmp = absDivisor, count = 1;
            ;
            while (tmp <= absDividend) {
                tmp = tmp << 1;//这里可能溢出！！超出int表示的范围
                count = count << 1;//这里可能溢出！！超出int表示的范围
            }
            tmp = tmp >> 1;
            count = count >> 1;
            result += count;
            absDividend -= tmp;
        }
        if (signal == -1)
            return (int) (signal * result);
        else {
            if (result > Integer.MAX_VALUE)//溢出
                return Integer.MAX_VALUE;
            else
                return (int) result;
        }
    }
}
