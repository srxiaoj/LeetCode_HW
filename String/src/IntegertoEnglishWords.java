
public class IntegertoEnglishWords {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 11000000;//1000010
        System.out.println(numberToWords(a));
    }
    public static String numberToWords(int num) {
        if(num == 0)return "Zero";
        if(num < 1000)
            return threeDigNum(num);
        else if(num < 1000000){
            int thousands = num/1000;
            if(num%1000 != 0)
                return threeDigNum(thousands) + " Thousand " + threeDigNum(num%1000);//use threeDigNum function to avoid having a zero in case 11000
            else
                return threeDigNum(thousands) + " Thousand";
        }
        else if(num < 1000000000){
            int millions = num/1000000;
            int thousands = num%1000000;
            if(num%1000000 != 0)
                return threeDigNum(millions) + " Million " + numberToWords(thousands);
            else
                return threeDigNum(millions) + " Million";
        }
        else{
            int billions = num/1000000000;
            int millions = num%1000000000;
            if(num%1000000000 != 0)
                return threeDigNum(billions) + " Billion " + numberToWords(millions);
            else
                return threeDigNum(billions) + " Billion";
        }
    }
    
    private static String threeDigNum(int n){
        String res;
        String[] singleName = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tenthName = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", 
                "Sixty", "Seventy", "Eighty", "Ninety"};
        //if(n == 0)return "Zero";
        if(n < 20){
            return singleName[n];
        }
        else if(n < 100){
            int mod = n/10;
            if(n%10 != 0)
                return tenthName[mod] + " " + threeDigNum(n%10);
            else
                return tenthName[mod];
        }
        else{
            int hundreds = n/100;
            if(n%100 != 0)
                return singleName[hundreds] + " Hundred " + threeDigNum(n%100);
            else
                return singleName[hundreds] + " Hundred";
        }
    }

}
