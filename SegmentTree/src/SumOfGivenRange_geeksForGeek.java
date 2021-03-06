// Java Program to show segment tree operations like construction,
// query and update
public class SumOfGivenRange_geeksForGeek {
    public static void main(String args[]) {
        int nums[] = {1, 3, 5, 7, 9, 11};
        int n = nums.length;
        SumOfGivenRange_geeksForGeek tree = new SumOfGivenRange_geeksForGeek(nums, n);
        // Print sum of values in array from index 1 to 3
        System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));
        // Update: set nums[1] = 10 and update corresponding segment
        tree.updateValue(nums, n, 1, 10);
        System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));
    }

    private int segtree[];

    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    public SumOfGivenRange_geeksForGeek(int nums[], int n) {
        // Allocate memory for segment tree
        // Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        segtree = new int[max_size];
        constructSTUtil(nums, 0, n - 1, 0);
    }

    /* A recursive function to update the nodes which have the given
       index in their range. The following are parameters
        segtree, si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    private void updateValueUtil(int ss, int se, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se) return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        segtree[si] = segtree[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    private void updateValue(int arr[], int n, int i, int new_val) {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        // Get the difference between new value and old value
        int diff = new_val - arr[i];
        // Update the value in array
        arr[i] = new_val;
        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    // A utility function to get the middle index from corner indexes.
    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /*  A recursive function to get the sum of values in given range
        of the array.  The following are parameters for this function.

      segtree    --> Pointer to segment tree
      si    --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
      ss & se  --> Starting and ending indexes of the segment represented
                    by current node, i.e., segtree[si]
      start & end  --> Starting and ending indexes of query range */
    private int getSumUtil(int ss, int se, int start, int end, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (start <= ss && end >= se) return segtree[si];
        // If segment of this node is outside the given range
        if (se < start || ss > end) return 0;
        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, start, end, 2 * si + 1) + getSumUtil(mid + 1, se, start, end, 2 * si + 2);
    }

    // Return sum of elements in range from index start (quey start) to
    // end (query end).  It mainly uses getSumUtil()
    private int getSum(int n, int start, int end) {
        // Check for erroneous input values
        if (start < 0 || end > n - 1 || start > end) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, start, end, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree segtree
    private int constructSTUtil(int arr[], int ss, int se, int si) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            segtree[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        segtree[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return segtree[si];
    }
}
