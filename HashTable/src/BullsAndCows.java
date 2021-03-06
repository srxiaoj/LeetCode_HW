import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thanksgiving on 1/12/16.
 */
public class BullsAndCows {

  public static void main(String[] args) {
    BullsAndCows obj = new BullsAndCows();
    String secret = "11";
    String guess = "10";
    System.out.println(obj.getHint(secret, guess));

    String secret2 = "1123";
    String guess2 = "0111";
    System.out.println(obj.getHint(secret2, guess2));
  }

  public String getHint(String secret, String guess) {
    int[] a = new int[10];
    int[] b = new int[10];
    int bull = 0;

    for (int i = 0; i < secret.length(); i++) {
      a[secret.charAt(i) - '0']++;
      b[guess.charAt(i) - '0']++;

      if (secret.charAt(i) == guess.charAt(i)) {
        bull++;
      }
    }

    int cow = 0;
    for (int i = 0; i < 10; i++) {
      if (a[i] > 0) {
        cow += Math.min(a[i], b[i]);
      }
    }
    cow -= bull;
    return bull + "A" + cow + "B";
  }

    /*public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretMap = new HashMap<>();
        HashMap<Character, Integer> guessMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                list.add(i);
            } else {
                if (!secretMap.containsKey(secret.charAt(i))) {
                    secretMap.put(secret.charAt(i), 1);
                } else {
                    secretMap.put(secret.charAt(i), secretMap.get(secret.charAt(i)) + 1);
                }

                if (!guessMap.containsKey(guess.charAt(i))) {
                    guessMap.put(guess.charAt(i), 1);
                } else {
                    guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i)) + 1);
                }
            }
        }
        int bull = list.size();
        int cow = 0;
        for (Character key : secretMap.keySet()) {
            if (guessMap.containsKey(key)) {
                cow += Math.min(guessMap.get(key), secretMap.get(key));
            }
        }
        return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
    }*/
}
