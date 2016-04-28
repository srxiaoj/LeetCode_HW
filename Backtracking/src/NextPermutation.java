import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        List<Integer> t1 = new ArrayList<Integer>(Arrays.asList(1, 3, 2));
        nextPermu(t1);
        System.out.println(t1);

        int[] test2 = new int[]{1, 2, 5, 4, 3};
        nextPermutation(test2);
        printArray(test2);

        int[] test3 = new int[]{1, 2, 4, 5, 3};
        nextPermutation(test3);
        printArray(test3);
    }

    /**
     * Input is an array
     * 从后往前loop，如果前面一个数小于当前的数，那么则要将这个小的数替换为下一个比他稍大的数
     * 那么则需要对当前之后的array进行排序，然后寻找到第一个这个稍大的数进行swap
     *
     * @param num
     */
    public static void nextPermutation(int[] num) {
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                Arrays.sort(num, i, num.length);
                for (int j = i; j < num.length; j++) {
                    if (num[j] > num[i - 1]) {
                        swap(num, j, i - 1);
                        return;
                    }
                }
            }
        }
        // if all the num[i-1] > num[i]
        Arrays.sort(num);
        return;
    }

    /**
     * In place swap.
     *
     * @param num
     * @param i
     * @param j
     */
    private static void swap(int[] num, int i, int j) {
        // swap num[i-1] and num[j]
        num[i] = num[i] + num[j];
        num[j] = num[i] - num[j];
        num[i] = num[i] - num[j];
    }

    /**
     * Input is a list
     *
     * @param list
     * @return
     */
    public static List<Integer> nextPermu(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i - 1) < list.get(i)) {
                Collections.sort(list.subList(i, list.size()));
                for (int j = i; j < list.size(); j++) {
                    if (list.get(j) > list.get(i - 1)) {
                        Collections.swap(list, j, i - 1);
                        return list;
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
