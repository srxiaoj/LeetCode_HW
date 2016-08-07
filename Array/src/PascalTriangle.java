import java.util.ArrayList;
import java.util.List;


public class PascalTriangle {

	public static void main(String[] args) {
//		List<List<Integer>> A = generate(5);
//		printArray(A);
        System.out.println(getRow(3));
    }

	public static List<Integer> getRow(int k) {
		if (k == 0) return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k+ 2; i++) {
            res.add(0);
        }
		res.set(k, 1);
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= k; j++) {
				int cur = res.get(j) + res.get(j + 1);
				res.set(j, cur);
			}
		}
		res.remove(k + 1);
		return res;
	}

	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return res;
		for(int i = 0; i < numRows; i++)
		{
        	List<Integer> tmp = new ArrayList();
        	for(int j = 0; j <= i; j++)
            {
                //System.out.println("j is: " + j);
                tmp.add(1);
            }
        	res.add(tmp);
        }
        for(int i = 2; i < numRows; i++)
        {
        	int j = 1;
        	while (j >= 1 && j <= i-1)
        	{
        		System.out.println("i is: " + i + ", j is " + j);
        		res.get(i).set(j, res.get(i-1).get(j-1)+res.get(i-1).get(j));//current value is the sum of two values above it
        		j++;
        	}
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
