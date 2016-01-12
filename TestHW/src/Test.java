import java.util.Arrays;


public class Test {
    // instance variable
    private int x = 1;
    private int y = 1;
    
    public synchronized int getSum() {
        x = 3;
        y = 4;
        int k = 5;
        return x + y + k;
    }
    
    public synchronized int getDiff() {
        x = 8;
        y = 6;
        return x - y;
    }
        
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        double x = 2.2;
//        int y = 6;
//        int res = (int) x;
//        double res2 = (double) y;
//        System.out.println(res);
//        System.out.println(res2);
//        try {
//            System.out.println("try");
//            System.out.println(args.length / 0);
//        } finally {
//            System.out.println("finally");
//        }
//        int a = Integer.MIN_VALUE;
//        System.out.println(a * 2);
        
        Test obj1 = new Test();
        Test obj2 = new Test();
        System.out.println(obj1.getSum());
        System.out.println(obj2.getDiff());
        
//        System.out.println(x);
//        x++;
//        System.out.println(x);
//        int[] test = {5, 1, 6, 3, 9};
//        Arrays.sort(test);
//        System.out.println(test[0]);
        
    }

}
