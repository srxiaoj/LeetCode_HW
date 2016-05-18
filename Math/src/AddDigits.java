
public class AddDigits {

    public static void main(String[] args) {
        int test = 1982;
        System.out.println("the result is " + addDigits(test));
    }

    public static int addDigits(int num) {
        return 1 + (num - 1) % 9;
        /*
        //method 1
        int res = 0;
        while (num / 10 >= 0) {
            res = num/10 + num%10;
            num = res;
        }
        return res;
        */
    }

}
