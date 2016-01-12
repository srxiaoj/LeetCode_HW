import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    /**
	     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	     * for example,
	     * If n = 4 and k = 2, a solution is:
	     * [
	     *  [2,4],
	     *  [3,4],
	     *  [2,3],
	     *  [1,2],
	     *  [1,3],
	     *  [1,4],
	     * ]
	     */
	    
		List<List<Integer>> A = combine(4,3);
		printArray(A);
	}
	public static List<List<Integer>> combine(int n, int k)
	{
        if (n == 0 || k == 0 || k > n)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++)
            res.add(Arrays.asList(i));// get the array for the first element
        for (int i = 2; i <= k; i++)// iterate all the combination numbers
        {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (int j = i; j <= n; j++) {
                for (List<Integer> list : res) {
                    // System.out.println("list is: " + list);
                    // if new value is larger than the largest value
                    // in the previous list, then add this value to
                    // the larger dimension list
                    if (list.get(list.size() - 1) < j) {
                        List<Integer> newList = new ArrayList<Integer>(list);
                        newList.add(j);
                        tmp.add(newList);
                    }
                }
            }
            res = tmp;
        }
        return res;
	}
	public static void printArray(List<List<Integer>> A)
	{
		for(int i = 0; i < A.size(); i++)
		{
			System.out.print(A.get(i) + " ");
		}
	}

}
