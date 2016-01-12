import java.util.ArrayList;
import java.util.List;


public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> A = generate(5);
		printArray(A);
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
