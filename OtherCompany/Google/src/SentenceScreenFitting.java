/**
 * Created by Administrator on 2016/10/12.
 */
public class SentenceScreenFitting {
    public static void main(String[] args) {
        System.out.println(wordsTyping(new String[]{"I", "had", "apple", "pie"}, 8, 5));
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int sum = 0, ans = 0, j = 0;
        for (String s : sentence) sum += s.length();
        for (int i = 0; i < rows; i++) {
            int remaining = cols + 1; // reserve an extra space for the dummy space to the left of the first letter
            while (j < sentence.length && sentence[j].length() + 1 <= remaining) {
                remaining -= sentence[j++].length() + 1;
            }

            if (j >= sentence.length) {
                j = 0;
                // one row can hold multiple cycle
                ans += 1 + remaining / (sum + sentence.length);
                remaining %= (sum + sentence.length);
                while (j < sentence.length && sentence[j].length() + 1 <= remaining)
                    remaining -= sentence[j++].length() + 1;
            }
        }
        return ans;
    }
}
