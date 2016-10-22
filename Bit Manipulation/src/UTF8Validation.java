/**
 * Created by Administrator on 2016/10/22.
 */
public class UTF8Validation {
    public static void main(String[] args) {

        System.out.println(validUtf8(new int[]{197, 130, 1})); // 11000101 10000010 00000001
        System.out.println(validUtf8(new int[]{235, 140, 4}));
        System.out.println(validUtf8(new int[]{145})); // 10010001
    }

    public static boolean validUtf8(int[] data) {
        int n = data.length;
        if (n == 0) return true;
        int skip = 0b10000000;
        int numOfBits = 0;
        for (int i = 0; i < data.length; i++) {
            if (numOfBits > 0) {
                if ((data[i] & skip) == skip) numOfBits--;
                else return false;
            } else {
                numOfBits = getOneBitCountFromHead(data[i]);
                if (numOfBits < 0) return false;
            }
        }
        return numOfBits == 0;
    }

    private static int getOneBitCountFromHead(int num) {
        if ((num & 0b11110000) == 0b11110000) return 3;
        if ((num & 0b11100000) == 0b11100000) return 2;
        if ((num & 0b11000000) == 0b11000000) return 1;
        // 如果某个UTF8起始数字bit以10开头，则肯定是错误的
        if ((num & 0b10000000) == 0b10000000) return -1; //error
        return 0;
    }
}
