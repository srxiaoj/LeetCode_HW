import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 6/3/16.
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection(nums1, nums2);
        printArray(res);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 1;
        List<Integer> l1 = new ArrayList<>();
        l1.add(nums1[0]);
        while (i < nums1.length) {
            while (i < nums1.length && nums1[i] == nums1[i - 1]) {
                i++;
            }
            if (i == nums1.length) break;
            l1.add(nums1[i]);
            i++;
        }
        i = 1;
        List<Integer> l2 = new ArrayList<>();
        l2.add(nums2[0]);
        while (i < nums2.length) {
            while (i < nums2.length && nums2[i] == nums2[i - 1]) {
                i++;
            }
            if (i == nums2.length) break;
            l2.add(nums2[i]);
            i++;
        }

        List<Integer> l3 = new ArrayList<>();
        int l = 0, r = 0;
        while (l < l1.size() && r < l2.size()) {
            if (l1.get(l) == l2.get(r)) {
                l3.add(l1.get(l));
                l++;
                r++;
            } else if (l1.get(l) > l2.get(r)) {
                r++;
            } else {
                l++;
            }
        }
        int[] res = new int[l3.size()];

        for (int k = 0; k < l3.size(); k++) {
            res[k] = l3.get(k);
        }
        return res;
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
