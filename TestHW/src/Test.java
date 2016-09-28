import java.util.*;

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

    private static int getum(String a) throws ArithmeticException {
        if (Long.parseLong(a) > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer Overflow");
        }
        return Integer.parseInt(a);
    }

    public static void main(String[] args) {
        //
        System.out.println((int) Math.log10(4101));



        // test of set contains array (equals)
       /* int[] arrayA = new int[] {1, 2};
        int[] arrayB = new int[] {1, 2};
        System.out.println(arrayA.equals(arrayB));
        System.out.println(arrayA == arrayB);
        System.out.println(Arrays.equals(arrayA, arrayB));
        Set<int[]> set = new HashSet<>();
        set.add(arrayA);
        set.add(arrayB);
        System.out.println(set.size());
        // arraylist (equals)
        List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> listB = new ArrayList<>(Arrays.asList(2, 1));
        System.out.println(listA.equals(listB));
        Set<List<Integer>> set2 = new HashSet<>();
        set2.add(listA);
        set2.add(listB);
        System.out.println(set2.size());*/



//        int a = 1;
//        int b = a++;
//        int c = ++b;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

//        a = 1 << 2;
//        System.out.println(a);

        List<String> list = new ArrayList<>(Arrays.asList("good", "bad", "bad", "bad", "yes"));
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("bad")) {
                list.remove(i);
            }
        }*/
       /* for (String s : list) {
            if (s.equals("bad")) {
                list.remove(s);
            }
        }*/

       /* Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if ("bad".equals(value)) {
                iterator.remove();
            }
        }*/
        for (Iterator itr = list.iterator(); itr.hasNext();) {
            if ("bad".equals(itr.next())) itr.remove();
        }
//        System.out.println(list);

       /* int[] num = {1, 2, 3, 4};
        int[] copy = Arrays.copyOfRange(num, 0, 6);
        printArray(copy);*/


       /* try {
            getum("109823019823098123");
        } catch (Exception e) {
            System.out.println("exception caught");
            e.printStackTrace();
        }
*/

//        System.out.println((-4 % 2));
//        System.out.println("1213".compareTo("133"));
//        System.out.println("abcd".substring(0, 4));
//        System.out.println(gcd(18, 0));
//        String s = "great";
//        String s1 = "grea";
//        int n = s.length();
//        int n1 = s1.length();
//        System.out.println(s.substring(0, (n + 1) / 2));
//        System.out.println(s.substring(0, (n - 1) / 2));
//        System.out.println(s.substring(0, n / 2));
//        System.out.println(s1.substring(0, (n1 + 1) / 2));
//        System.out.println(s1.substring(0, (n1 - 1) / 2));
//        System.out.println(s1.substring(0, n / 2));
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
