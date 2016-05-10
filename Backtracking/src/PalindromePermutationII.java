import java.util.*;

public class PalindromePermutationII {

    public static void main(String[] args) {
        PalindromePermutationII obj = new PalindromePermutationII();
        String s = "aabb";
        System.out.println(obj.generatePalindromes(s));
        String s1 = "aaa";
        System.out.println(obj.generatePalindromes(s1));
    }

    /**
     * 先用map找到每个char的次数，如果多于2个char的count为奇数，则不是palindrome
     * 然后讲得到偶数个count的一半，再加上奇数个count的那一个char去组成palindrome
     * 不断的对那一半进行permutation直到没有更多的permutation, 参考nextPermutation
     */
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }

        // get half palindrome list
        int singleCount = 0;
        char single = '0';
        List<Character> half = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue() % 2) == 1) {
                singleCount++;
                single = (char) entry.getKey();
                if (singleCount > 1) return res;
                for (int i = 0; i < ((Integer) entry.getValue() - 1) / 2; i++) {
                    half.add((Character) entry.getKey());
                }
            } else {
                for (int i = 0; i < (Integer) entry.getValue() / 2; i++) {
                    half.add((Character) entry.getKey());
                }
            }
        }

        List<List<Character>> all = new ArrayList<>();
        List<String> result = new ArrayList<>();
        while (!all.contains(half)) {
            all.add(new ArrayList<>(half));
            result.add(getPalindrome(half, single));
            half = nextPermute(half);
        }
        return result;
    }

    private String getPalindrome(List<Character> a, char single) {
        StringBuilder sb = new StringBuilder();
        for (Character c : a) {
            sb.append(c);
        }
        if (single == '0') {
            return sb.toString() + sb.reverse().toString();
        }
        return sb.toString() + single + sb.reverse().toString();
    }


    private List<Character> nextPermute(List<Character> half) {
        for (int i = half.size() - 1; i >= 1; i--) {
            if (half.get(i) > half.get(i - 1)) {
                Collections.sort(half.subList(i, half.size()));
                for (int j = i; j < half.size(); j++) {
                    if (half.get(j) > half.get(i - 1)) {
                        Collections.swap(half, i - 1, j);
                        return half;
                    }
                }
            }
        }
        Collections.sort(half);
        return half;
    }
}
