/**
 * Created by thanksgiving on 4/25/16.
 */
public class _Test {
    public static void main(String[] args) {
        // shift test
/*        int n1 = 16;
        System.out.println(IntToBit.intToBit(n1));
        int n1LeftShift = n1 << 3;
        System.out.println(n1LeftShift);
        System.out.println(IntToBit.intToBit(n1LeftShift));
        int n1RightShift = n1 >> 2;
        System.out.println(n1RightShift);
        System.out.println(IntToBit.intToBit(n1RightShift));*/
        // power of four test
        int cur = 1;
        for (int i = 0; i < 5; i++) {
            cur = cur << 2;
            System.out.print(cur + " ");
        }
    }
}
