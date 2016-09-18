/**
 * Created by thanksgiving on 9/8/16.
 */
public class Swapper {
    public void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        Swapper swapper = new Swapper();
        int x = 42, y = 24;
        swapper.swap(x, y);
        System.out.println(x + " " + y);
    }
}
