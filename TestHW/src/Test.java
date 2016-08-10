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

    private static int gcd(int a, int b) {
        if (a > b) {
            return gcd(b, a);
        } else {
            if (a == 0) {
                return 0;
            } else if (b % a == 0) {
                return a;
            } else {
                return gcd(b % a, a);
            }
        }
    }
        
    public static void main(String[] args) {
//        System.out.println((-4 % 2));
//        System.out.println("1213".compareTo("133"));
//        System.out.println("abcd".substring(0, 4));
//        System.out.println(gcd(18, 0));
        String s = "great";
        String s1 = "grea";
        int n = s.length();
        int n1 = s1.length();
        System.out.println(s.substring(0, (n + 1) / 2));
        System.out.println(s.substring(0, (n - 1) / 2));
        System.out.println(s.substring(0, n / 2));
        System.out.println(s1.substring(0, (n1 + 1) / 2));
        System.out.println(s1.substring(0, (n1 - 1) / 2));
        System.out.println(s1.substring(0, n / 2));
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
