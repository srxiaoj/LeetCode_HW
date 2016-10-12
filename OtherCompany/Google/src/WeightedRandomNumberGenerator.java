import java.util.Random;

/**
 * Created by Administrator on 2016/10/12.
 */
public class WeightedRandomNumberGenerator {
    public static void main(String[] args) {
        System.out.println(myRand(new int[] {10, 20, 30}, new int[] {2, 3, 1}));
        for (int i = 1; i <= 6; i++) {
            System.out.println(findCeil(new int[] {2, 5, 6}, i, 0, 5));
        }
    }

    // 根据index r 找到prefix中r应该对应nums中的哪个index
    public static int findCeil(int prefix[], int r, int i, int j) {
        while (i < j) {
            int mid = i + ((j - i) >> 1);
            if (r > prefix[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (prefix[i] >= r) return i;
        return -1;
    }

    // The main function that returns a random number from nums[] according to
    // distribution array defined by freq[].
    public static int myRand(int nums[], int freq[]) {
        Random random = new Random();
        int n = nums.length;
        int[] prefix = new int[n];
        int i;
        prefix[0] = freq[0];
        for (i = 1; i < n; i++) prefix[i] = prefix[i - 1] + freq[i];

        // prefix[n-1] is sum of all frequencies. Generate a random number with value from 1 to this sum
        int r = random.nextInt(prefix[n - 1]) + 1;

        // Find index of ceiling of r in prefix arrat
        int indexc = findCeil(prefix, r, 0, n - 1);
        return nums[indexc];
    }
}
