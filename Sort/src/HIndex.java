public class HIndex {
    public static void main(String[] args) {
        int test[] = new int[]{3, 0, 6, 1, 5};
        System.out.println("The h index is: " + hIndex(test));
    }

    public static int hIndex(int[] citations) {
        // method 1: 排序再数大于citation[i]的个数
        /*Arrays.sort(citations);
        int n = citations.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int k = n - i;
            if (k <= citations[i]) {
                max = Math.max(k, max);
            }
        }
        return max;*/

        /**
         * method2: Basically we iterate the array for two rounds.
         * In first round we count how many citation in each bucket and
         * in the second round we traverse back to find the maximum h.
         */
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int index = Math.min(n, citations[i]);
            count[index]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println(" ");
    }
}