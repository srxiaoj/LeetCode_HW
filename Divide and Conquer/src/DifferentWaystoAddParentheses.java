import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DifferentWaystoAddParentheses {
    public static void main(String[] args) {
        String test = "2*3-4*5";
        List<Integer> result = diffWaysToCompute(test);
        System.out.println(result);
    }

    /**
     * 关键词: divide and conquer
     * 求出符号前一部分的子结果，和符号后一部分的子结果，再进行合并
     */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for (Integer p1 : part1Res) {
                    for (Integer p2 : part2Res) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                c = p1 + p2;
                                break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1 * p2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;

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
                while (i < input.length() && input.charAt(i) >= 48 && input.charAt(i) <= 57) {
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
                while (i < input.length() && input.charAt(i) >= 42 && input.charAt(i) <= 45) {
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
