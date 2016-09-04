import java.util.*;

/**
 * Created by thanksgiving on 4/25/16.
 */
public class _Test {
    public static void main(String[] args) {
        Integer[] num2 = new Integer[] {1, 2, 3};
//        String[] nums = new String[]{"a", "b"};
//        List<String> v1 = Arrays.asList(nums);
        List<Integer> l1 = Arrays.asList(num2);
        List<Integer> l2 = Arrays.asList(num2);
        Set<Integer> set = new HashSet<>(Arrays.asList(num2));
        System.out.println(set);
        List<Integer> l3 = new ArrayList<>(Arrays.asList(num2));
//        System.out.println(l1);
//        System.out.println(l3);
        num2[0] = 4;
//        System.out.println(l1);
//        System.out.println(l3);


        /*// shift test
        int n1 = 16;
        System.out.println(n1 + ": " + IntToBit.intToBit(n1));
        int n1LeftShift = n1 << 3;
        System.out.println(n1LeftShift + ": " + IntToBit.intToBit(n1LeftShift));
        int n1RightShift = n1 >> 2;
        System.out.println(n1RightShift + ": " + IntToBit.intToBit(n1RightShift));
        // power of four test
        int cur = 1;
        for (int i = 0; i < 5; i++) {
            cur = cur << 2;
            System.out.print(cur + " ");
        }*/
      /*  System.out.println(IntToBit.intToBit((-2 >>> 1)));
        System.out.println(IntToBit.intToBit((-2 >> 1)));
        System.out.println(IntToBit.intToBit((2147483647 >>> 1)));
        System.out.println(IntToBit.intToBit((2147483647 >> 1)));*/

        // int to bit
 /*       int n = -1;
        System.out.println((n & 1));
        System.out.println(-1 << 1);
        System.out.println(IntToBit.intToBit(9));
        System.out.println(Integer.toBinaryString(-9));
        System.out.println(Integer.toBinaryString(-1).length());
        System.out.println(Integer.toBinaryString(-2));*/


        /*// parent of bit i
        for (int i = 1; i <= 20; i++) {
            System.out.println(getParent(i));
        }

        System.out.println(6 & 5);
        System.out.println(6 & (-6));*/



    }

    private static int getParent(int i) {
        int temp = i & (-i);
        System.out.println( i + " & (-" + i + ") = " + temp);
        return i - (i & (-i));
    }
}
