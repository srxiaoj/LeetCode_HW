/**
 * Created by thanksgiving on 1/8/16.
 */
public class NumberofDigitOne {
    public static void main(String[] args) {
        NumberofDigitOne obj = new NumberofDigitOne();
        System.out.println(obj.countDigitOne(109));
        System.out.println(obj.countDigitOne(32145));
        System.out.println(obj.countDigitOne(1410065408));
    }

    /**
     * 【解题思路】
     这个题其实和题目1491：求1和2的个数完全一样。
     不一样的地方只是输入。一个输入的是数字，一个是字符串，处理方式完全一样。
     来分析一下思路。尽量简单一点。
     1)、假设有一个五位数，32145
     那么从1到32145一共包含多少个1呢。
     我们对百位数1开始分析。也就是百位数为1的个数一共有多少个呢。
     对于它的高位来说，是32。一共有00100~00199，01100~01199，02100~02199，.....，31100~31199，一共是32*100个数。
     对于它的低位来说，是45。一共有100~145，46个数。
     加起来是highNum*100+lowNum+1；
     2)、那如果百位不是1呢，是0怎么算呢。
     如果是32045，
     对于它的高位来说，是32。一共有00100~00199，01100~01199，02100~02199，.....，31100~31199，一共是32*100个数。
     对于它的地位来说，是45。无论怎么样，都不可能让百位出现1，
     个数加起来是highNum*100
     3)、如果是32445，
     对于它的高位来说，是32。一共有00100~00199，01100~01199，02100~02199，.....，31100~31199，一共是32*100个数。
     对于它的低位来说，是100。一共有100~199，100个数。
     个数加起来是（highNum+1）*100
     所以总结起来就是
     如果当前位为0，该位出现1的情况仅仅取决于高位
     如果当前位为1，该位出现1的情况为高位*倍数 + 低位 + 1;
     如果当前位大于1，该位出现1的情况仅仅取决于高位+1 乘以倍数；
     所以结果就应该是对每个位求1出现的个数，加起来就是最终的结果。
     */
    public int countDigitOne(int n) {
        long iCount = 0;
        long iFactor = 1;
        int iLowerNum = 0;
        int iHigherNum = 0;
        int iCurrNum = 0;
        while (iFactor <= n) {
            iLowerNum =(int)  (n % iFactor);
            iCurrNum = (int) (n / iFactor) % 10;
            iHigherNum = (int) (n / (iFactor * 10));
//            System.out.println("iLowerNum: " + iLowerNum + ", iCurrNum: " + iCurrNum + ", iHigherNum: " + iHigherNum);
            switch (iCurrNum) {
                case 0:
                    iCount += iHigherNum * iFactor;
                    break;
                case 1:
                    iCount += iHigherNum * iFactor + iLowerNum + 1;
                    break;
                default:
                    iCount += (iHigherNum + 1) * iFactor;
                    break;
            }
            iFactor *= 10;
        }
        return (int) iCount;


       /* if (n <= 0) return 0;
        int remainder = n, fac = 1, count = 0;
        do {
            int cur = remainder % 10;
            remainder /= 10;
            count += remainder * fac;
            if (cur == 1) {
                count += n % fac + 1;
            } else if (cur > 1) {
                count += fac;
            }
            fac *= 10;
        } while (remainder > 0);
        return count;*/
    }
}
