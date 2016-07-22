
public class KthLargest {
    private static int L;

    public static void main(String[] args) {
        int[] test = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(test, 2));
    }


    /**
     * find kth largest element.
     * If index == k - 1, which means we've got the kth element
     * If index < k - 1, the kth element is to the right of the index, we need to search from index to right
     * If index > k - 1, the kth element is to the left of the index, we need to search from left to index
     */
    public static int findKthLargest(int[] nums, int k) {

        //method 1, heap sort
        heapSort(nums);
        return nums[nums.length - k];

        /*
        //method 2, partial quicksort, O(nlogk)
        int l = 0, r = nums.length-1;
        while (true) {
            int p = partition(nums, l, r);
            if (p == k - 1) return nums[k-1];
            if (p > k - 1) r = p - 1;
            else l = p + 1;
        }
        */
    }

    private static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = L; i >= 1; i--) {
            swap(nums, 0, i);
            L = L - 1;
            heapify(nums, 0);
        }
    }

    private static void buildHeap(int[] nums) {
        L = nums.length - 1;
        for (int i = L / 2; i >= 0; i--) {
            heapify(nums, i);
        }
    }

    //max-heap
    private static void heapify(int[] nums, int i) {
        int l = 2 * i;
        int r = l + 1;
        int largest = i;
        if ((l <= L) && (nums[l] > nums[largest]))
            largest = l;
        if ((r <= L) && (nums[r] > nums[largest]))
            largest = r;
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest);
        }
    }

    /**
     * use first index as initial pivot.
     * sorted in descendent sequence
     */
    private static int partition(int[] array, int l, int r) {
        int p = l;
        int pValue = array[l];
        for (int i = l + 1; i <= r; i++) {
            if (array[i] > pValue) {
                p++;
                swap(array, i, p);
            }
        }
        swap(array, p, l);
        return p;
    }

    /**
     * swap
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
