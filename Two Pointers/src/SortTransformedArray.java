/**
 * Created by thanksgiving on 7/19/16.
 */
public class SortTransformedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 2, 4};
        int[] res = sortTransformedArray2(nums, 0, 3, 5);
        printArray(res);
    }

    public static int[] sortTransformedArray2(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];

        int index = a >= 0 ? n - 1 : 0;

        int i = 0, j = n - 1;
        while (i <= j) {
            int left = function(nums[i], a, b, c);
            int right = function(nums[j], a, b, c);
            if (a >= 0) {
                if (left >= right) {
                    res[index] = left;
                    i++;
                } else {
                    res[index] = right;
                    j--;
                }
                index--;
            } else {
                if (left < right) {
                    res[index] = left;
                    i++;
                } else {
                    res[index] = right;
                    j--;
                }
                index++;
            }
        }
        return res;
    }

    private static int function(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }




    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double mid = -b / (2.0 * a);
        int n = nums.length;
        int breakPoint = 0;
        double min = Integer.MAX_VALUE;
        double[] relative = new double[n];
        for (int i = 0; i < n; i++) {
            relative[i] = Math.abs(nums[i] - mid);
            if (min > relative[i]) {
                min = relative[i];
                breakPoint = i;
            }
        }

        Pair[] reverse = new Pair[breakPoint - 0 + 1];
        Pair[] pos = new Pair[n - breakPoint - 1];
        for (int i = 0; i < n; i++) {
            if (i <= breakPoint) {
                reverse[i] = new Pair(i, relative[i]);
            } else {
                pos[i - breakPoint - 1] = new Pair(i, relative[i]);
            }
        }
        reverse(reverse);

        Pair[] total = new Pair[n];
        int l = 0, r = 0, k = 0;
        while (l < reverse.length && r < pos.length) {
            if (reverse[l].val < pos[r].val) {
                total[k] = reverse[l];
                l++;
            } else {
                total[k] = pos[r];
                r++;
            }
            k++;
        }

        while (l < reverse.length) {
            total[k] = reverse[l];
            l++;
            k++;
        }
        while (r < pos.length) {
            total[k] = pos[r];
            r++;
            k++;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }

        int[] output = new int[n];
        if (a < 0) {
            reverse(total);
        } else if (a == 0) {
            if (b > 0) {
                return res;
            } else {
                reverse(res);
                return res;
            }
        }
        for (int i = 0; i < n; i++) {
            output[i] = res[total[i].index];
        }
        return output;
    }

    private static class Pair {
        int index;
        double val;

        public Pair(int i, double v) {
            index = i;
            val = v;
        }

        public String toString() {
            return "[" + index + "," + val + "]";
        }
    }

    private static void reverse(Pair[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            Pair temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            left++;
            right--;
        }
    }

    private static void reverse(int[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            left++;
            right--;
        }
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
