/**
 * Created by thanksgiving on 6/4/16.
 */
public class TwoOperations {
    public static void main(String[] args) {
        String[] string = {"2", "3", "4", "2147483647"};
        int[] res = twoOperation(string);
        printArray(res);
    }

    private static int[] twoOperation(String[] string) {
        if (string == null || string.length == 0) return null;
        int[] num = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            num[i] = count(Long.parseLong(string[i]));
        }
        return num;
    }

    private static int count(long num) {
        if (num <= 0) return 0;
        int i = 0;
        while (num != 0) {
            if (num % 2 != 0) {
                num -= 1;
            } else {
                num /= 2;
            }
            i++;
        }
        return i;
    }

    private static void printArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
