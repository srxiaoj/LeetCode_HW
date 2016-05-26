import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/26/16.
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        System.out.println(obj.grayCode(3));

    }

    /**
     * 非常巧妙的解法：i ^ (i >> 1)
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        int count = (int) Math.pow(2, n);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int temp = i >> 1;
            System.out.print(temp + " ");
            res.add(i ^ temp);
        }
        return res;
    }
}
