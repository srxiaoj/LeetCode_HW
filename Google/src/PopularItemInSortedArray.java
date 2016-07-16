class PopularItemInSortedArray {
    public static void main(String[] args) {
        System.out.println(getSmallPopular(new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 5, 5, 6}, 4));
        System.out.println(getSmallPopular(new int[]{1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5}, 3));
    }

    public static int getSmallPopular(int[] a, int N) {
        if (a == null || a.length == 0) return -1;
        System.out.println("length is: " + a.length);
        int n = a.length;
        int i = N - 1;
        while (i < n) {
            int first = findFirst(a[i], 0, i, a);
            int last = findLast(a[i], i, n - 1, a);
            if (last - first + 1 > n / N) {
                return a[i];
            }
            i += n / N;
        }
        return -1;
    }

    private static int findFirst(int t, int start, int end, int[] a) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < t) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (a[start] == t) return start;
        else return end;
    }

    private static int findLast(int t, int start, int end, int[] a) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > t) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (a[end] == t) return end;
        else return start;
    }
}