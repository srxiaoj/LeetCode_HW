/**
 * Created by thanksgiving on 8/10/16.
 */
public class IntegertoEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(23));
        System.out.println(numberToWords(1003));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(20));
        System.out.println(numberToWords(18));
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else {
            String res = helper(num);
            return res.substring(1);
        }

    }

    public static String helper(int num) {
        String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num >= 1000000000) {
            return helper(num / 1000000000) + " Billion" + helper(num % 1000000000);
        } else if (num >= 1000000) {
            return helper(num / 1000000) + " Million" + helper(num % 1000000);
        } else if (num >= 1000) {
            return helper(num / 1000) + " Thousand" + helper(num % 1000);
        } else if (num >= 100) {
            return helper(num / 100) + " Hundred" + helper(num % 100);
        } else if (num >= 20) {
            return " " + tens[num / 10] + helper(num % 10);
        } else if (num >= 1) {
            return " " + digits[num];
        } else if (num == 0) {
            return "";
        } else
            return null;
    }
}
