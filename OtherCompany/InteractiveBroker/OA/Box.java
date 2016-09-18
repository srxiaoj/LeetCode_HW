/**
 * Created by thanksgiving on 9/8/16.
 */
public class Box {
    private double width;
    private double length;
    private double height;
    private static double DEFAULT_HEIGHT;

    public Box(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Box(double width, double length) {
        this.width = width;
        this.length = length;
        this.height = DEFAULT_HEIGHT;
    }

    public static void main(String[] args) {
        Box box1 = new Box(10, 20);
//        Box box2 = new Box();
        Box box3 = new Box(5, 5, 5);
        Box box4 = new Box(10, 20, Box.DEFAULT_HEIGHT);
    }
}
