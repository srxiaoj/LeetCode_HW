import java.util.HashMap;
import java.util.Map;


public class TwoSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {0,4,3,0};
        int[] B = twoSum(A, 7);
        printArray(B);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++)
        {
            if(map.containsKey(target-numbers[i]))
            {
                result[1] = i+1;
                result[0] = map.get(target-numbers[i]);
                return result;
            }
            map.put(numbers[i],  i+1);//store each number at index i into hashtable at location i+1
        }
        return result;
    }
    public static void printArray(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
