/**
 * Created by thanksgiving on 4/24/16.
 */
public class MaximumProductofWordLengths {
    public static void main(String[] args) {
        MaximumProductofWordLengths obj = new MaximumProductofWordLengths();
        String[] test = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(obj.maxProduct(test));
    }

    /**
     * 非常好的判断两个字符串是否有共同字符的题
     * 先将每个String中的字符进行 bits[i] = bits[i] | (1 << c - 'a') 存为一个int
     * 然后判断bits[i] & bits[j] 是否为 0， 为0则没有共同字符
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                // c 与 a差多少位，该位则为1
                bits[i] = bits[i] | (1 << c - 'a');
//                System.out.println("1 << c - 'a': " + Integer.toBinaryString(1 << c - 'a'));
//                System.out.println(Integer.toBinaryString(bits[i]));
            }
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
