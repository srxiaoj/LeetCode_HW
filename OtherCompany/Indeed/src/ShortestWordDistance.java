/**
 * Created by thanksgiving on 10/29/16.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        String s = "Indeed use python and java to deal with the python python and is for java";
        System.out.println(shortestDistance(s, "java", "python"));
    }

    public static String shortestDistance(String s, String word1, String word2) {
        String[] array = s.split(" ");
        int i = 0, n = array.length, min = Integer.MAX_VALUE;
        Integer index1 = null, index2 = null;
        int left = 0, right = 0;
        while (i < n) {
            if (array[i].equals(word1)) {
                index1 = i;
            } else if (array[i].equals(word2)) {
                index2 = i;
            }

            if (index1 != null && index2 != null) {
                if (Math.abs(index1 - index2) < min) {
                    left = Math.min(index1, index2);
                    right = Math.max(index1, index2);
                    min = Math.min(min, Math.abs(index1 - index2));
                }
            }
            i++;
        }

        if (left > 2) {
            left -= 3;
        } else {
            left = 0;
        }

        if (right < n - 3) {
            right += 3;
        } else {
            right = n - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = left; k <= right; k++) {
            sb.append(" " + array[k]);
        }
        return sb.toString().substring(1);
    }
}
