import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Conbination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> A = combine(4,3);
		printArray(A);
	}
	public static List<List<Integer>> combine(int n, int k)
	{
		if(n == 0 || k == 0 || k > n) return null;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 1; i <= n; i++) res.add(Arrays.asList(i));//get the array for the first element
		for(int i = 2; i <= k; i++)//iterate all the combination numbers
		{
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for(int j = i; j <= n; j++)
			{
				for(List<Integer> list:res)
				{
					//System.out.println("list is: " + list);
					if(list.get(list.size()-1) < j)//if new value is larger than the largest value in the previous list, then add this value to the larger dimension list
					{
						List<Integer> newList = new ArrayList<Integer>(list);
						newList.add(j);
						tmp.add(newList);
					}
				}
			}
			res = tmp;
		}
		/*for(int i = 1; i <= n-k+1; i++) res.add(Arrays.asList(i));//get the array for the first element, the largest value for the first element is n-k+1
		for(int i = 2; i <= k; i++)
		{
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for(List<Integer> list:res)//iterate all the first element
			{
				System.out.println("list is: " + list);
				for(int m = list.get(list.size()-1)+1; m <= n-(k-i); m++)
				{
					System.out.println("m is: " + m);
					List<Integer> newList = new ArrayList<Integer>(list);
					newList.add(m);
					tmp.add(newList);
				}
			}
			res = tmp;*/
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
