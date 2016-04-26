import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DifferentWaystoAddParentheses {

    public static void main(String[] args) {
        String test = "2*3-4*5";
        List<Integer> result = diffWaysToCompute(test);
        System.out.println(result);
        
    }
    public static List<Integer> diffWaysToCompute(String input) {
 
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
        
    }
    //combine operator and numbers
    private static int operation(int a, int b, String op) {
        int res = 0;
        switch (op) {
        case "+":
            res = a + b;
            break;
        case "-":
            res = a - b;
            break;
        case "*":
            res = a * b;
            break;
        }
        return res;
    }
    //first get numbers from input
    private static List<Integer> getNum(String input) {
        List<Integer> num = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            int start = i;
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                while(i < input.length() && input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                    i++;
                }
                String nextNum = input.substring(start, i);
                num.add(Integer.parseInt(nextNum));
            } else {
                i++;
            }
        }
        return num;
    }
    //then extract the operators
    private static List<String> getOp(String input) {
        List<String> op = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            int start = i;
            if (input.charAt(i) >= 42 && input.charAt(i) <= 45) {
                while(i < input.length() && input.charAt(i) >= 42 && input.charAt(i) <= 45) {
                    i++;
                }
                String nextOp = input.substring(start, i);
                op.add(nextOp);
            } else {
                i++;
            }
        }
        return op;
    }
}
