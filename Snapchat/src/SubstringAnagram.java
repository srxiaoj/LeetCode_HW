/**
 * Created by thanksgiving on 7/24/16.
 */
public class SubstringAnagram {
    public static void main(String[] args) {
        System.out.println(hasSubstringAnagram("car", "bbarcba"));
        System.out.println(hasSubstringAnagram("car", "bbarcbb"));
        System.out.println(hasSubstringAnagram("anagram", "naagranal"));
        System.out.println(hasSubstringAnagram("abcd", "aaabaaacdb"));
    }

    public static boolean hasSubstringAnagram(String pattern, String source) {
        if (source.length() < pattern.length()) return false;
        int[] a = new int[26];
        int distinctChar = 0;
        for (char c : pattern.toCharArray()) {
            if (a[c - 'a'] == 0) distinctChar++;
            a[c - 'a']--;
        }
//        printArray(a);

        char[] sourceArray = source.toCharArray();
        int i;
        // check first k character, k == pattern.length()
        for (i = 0; i < pattern.length(); i++) {
            if (a[sourceArray[i] - 'a'] == 0) {
                distinctChar++;
                a[sourceArray[i] - 'a']++;
            } else {
                a[sourceArray[i] - 'a']++;
                if (a[sourceArray[i] - 'a'] == 0) {
                    distinctChar--;
                }
            }
        }
//        if (hasResult(a)) return true;
        if (distinctChar == 0) return true;
//        printArray(a);

        int len = pattern.length();
        // check one character at a time
        while (i < source.length()) {
            // remove the i - len character
            if (a[sourceArray[i - len] - 'a'] == 0) distinctChar++;
            a[sourceArray[i - len] - 'a']--;
            if (a[sourceArray[i - len] - 'a'] == 0) distinctChar--;

            if (a[sourceArray[i] - 'a'] == 0) {
                distinctChar++;
                a[sourceArray[i] - 'a']++;
            } else {
                a[sourceArray[i] - 'a']++;
                if (a[sourceArray[i] - 'a'] == 0) {
                    distinctChar--;
                }
            }
//            if (hasResult(a)) return true;
            if (distinctChar == 0) return true;
            i++;
        }
        return false;
    }


    private static boolean hasResult(int[] a) {
        for (int i : a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
