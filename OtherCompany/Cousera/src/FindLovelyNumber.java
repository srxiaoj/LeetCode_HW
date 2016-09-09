/**
 * Created by thanksgiving on 9/9/16.
 */
public class FindLovelyNumber {
    public static void main(String[] args) {
        System.out.println(findLovelyNumber(10, 100));
    }

    public static int findLovelyNumber(int a, int b){
        int[] count = new int[1];
        int bits = 0;
        int number = 0;
        for(int i = 1 ; i <= 9; i++){
            bits |= (1 << i);
            number = i;
            dfs(number, bits, a, b, count);
            bits &= ~(1 << i);
        }
        return count[0];
    }

    private static void dfs(int number, int bits, int floor, int ceil, int[] count){
        if(number > ceil)
        return;
        else if(number >= floor && number <= ceil)
            count[0]++;

        for(int i = 0 ; i <= 9; i++){
            if((bits & (1 << i)) != 0) continue;
            bits |= (1 << i);
            number = 10 * number + i;
            dfs(number, bits, floor, ceil, count);
            bits &= ~(1 << i);//回溯时，去掉之前的占位
            number /= 10;
        }
    }
}
