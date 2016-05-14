import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BasicCalculatorII {

    public static void main(String[] args) {
        String s1 = " 3+5 / 2 ";
        String s2 = "3+5 / 2  + 1 * 2";
        String s3 = "0-2147483647";
//        System.out.println(calculate3(s1));
        System.out.println(calculate3(s2));
        System.out.println(calculate3(s3));
    }

    public static int calculate3(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        int len = s.length();

        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }

        List<Character> op = new ArrayList<>(Arrays.asList('+','-','*','/'));
        int i = start;
        int res = 0;
        boolean hasOp = false;
        while (i < len) {
            char c = s.charAt(i);
            if (op.contains(c)) {
                hasOp = true;
                int first = Integer.parseInt(s.substring(start, i).trim());
                if (c == '+') {
                    return sign * (first + calculate3(s.substring(i + 1)));
                } else if (c == '-') {
                    return sign * (first - calculate3(s.substring(i + 1)));
                } else if (c == '*') {
                    int last = i;
                    while (i < len && !op.contains(s.charAt(i))) {
                        i++;
                    }
                    int second = Integer.parseInt(s.substring(last, i).trim());
                    res += first * second;
                } else {
                    i++;
                    int last = i;
                    while (i < len && !op.contains(s.charAt(i))) {
                        i++;
                    }
                    int second = Integer.parseInt(s.substring(last, i).trim());
                    res += first / second;
                }
            }

            i++;
        }
        if (!hasOp) {
            return Integer.parseInt(s.trim());
        } else {
            return sign * res;
        }

    }

   /* public static int calculate(String s) {
        int len = s.length();
        if(s==null || len==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);//pop the last element and multiply with current element
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);//pop the last element and divide with current element
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
        
        *//*
         * method 2
         *//*
        *//*
        s = s.replaceAll("\\s", "");//remove all spaces
        if (s.length() == 0) return 0;
        //compute the * and / first
        while (s.indexOf('*') != -1 || s.indexOf('/') != -1) {
            int first;
            if (s.indexOf('*') != -1 && s.indexOf('/') != -1)
                first = Math.min(s.indexOf('*'), s.indexOf('/'));//get the first encounter of whether * or /
            else if (s.indexOf('*') != -1)
                first = s.indexOf('*');
            else 
                first = s.indexOf('/');
            int i = first-1, j = first+1;
            while (i >= 0 && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                i--;
            }
            while (j < s.length() && s.charAt(j) >= 48 && s.charAt(j) <= 57) {
                j++;
            }
            if (j < s.length())
                s = s.substring(0, i+1) + operator(s.substring(i+1, first), s.charAt(first), s.substring(first+1, j)) + s.substring(j);
            else
                s = s.substring(0, i+1) + operator(s.substring(i+1, first), s.charAt(first), s.substring(first+1));
        }
        //then compute the + and -
        while (s.indexOf('+') != -1 || s.indexOf('-') != -1) {
            if (s.indexOf('-') == 0 && s.substring(1).indexOf('-') == -1 && s.substring(1).indexOf('+') == -1)//deal with negative result -11;
                return Integer.parseInt(s);
            int first;
            //if the first char is '-'
            if (s.substring(1).indexOf('-') == -1 && s.substring(1).indexOf('+') == -1)
                first = Math.min(s.substring(1).indexOf('+'), s.substring(1).indexOf('-')) + 1;//get the first encounter of whether * or /
            else if (s.substring(1).indexOf('+') != -1)
                first = s.substring(1).indexOf('+') + 1;
            else
                first = s.substring(1).indexOf('-') + 1;
            int i = first-1, j = first+1;
            while (i >= 0 && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                i--;
            }
            while (j < s.length() && s.charAt(j) >= 48 && s.charAt(j) <= 57) {
                j++;
            }
            if (j < s.length()) {
                if (i == 0) {//s.charAt(0) == '-'
                    s = operator(s.substring(0, first), s.charAt(first), s.substring(first+1, j)) + s.substring(j);
                } else {
                    s = s.substring(0, i+1) + operator(s.substring(i+1, first), s.charAt(first), s.substring(first+1, j)) + s.substring(j);
                }
            } else {
                if (i == 0) {//s.charAt(0) == '-'
                    s = String.valueOf(operator(s.substring(0, first), s.charAt(first), s.substring(first+1)));
                } else {
                    s = s.substring(0, i+1) + operator(s.substring(i+1, first), s.charAt(first), s.substring(first+1));
                }
            }
                
        }
        return Integer.parseInt(s);
        *//*
    }*/

    private static int operator(String a, char op, String b) {
        int i1;
        if (a.charAt(0) == '-')
            i1 = - Integer.parseInt(a.substring(1));
        else
            i1 = Integer.parseInt(a);
        int i2 = Integer.parseInt(b);
        switch (op) {
        case '+':
            return i1 + i2;
        case '-':
            return i1 - i2;
        case '*':
            return i1 * i2;
        case '/':
            return i1 / i2;
        default:
            return 0;
        }
    }

}
