import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 10/29/16.
 */
public class OnlineCoding {
    public static void main(String[] args) throws IOException {
        String fileName = "";
//        Scanner sb = new Scanner(System.in);
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        getFrequency(list, "java", "python");
    }

    public static void getFrequency(List<String> list, String word1, String word2) {
        int n = list.size();
        int numOfA = 0, numOfAorB = 0, numOfAandB = 0;
        for (int i = 0; i < n; i++) {
            boolean hasWord1 = false, hasWord2 = false;
            String[] strings = list.get(i).split(" ");
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals(word1)) {
                    hasWord1 = true;
                } else if (strings[j].equals(word2)) {
                    hasWord2 = true;
                }

                if (hasWord1 && hasWord2) {
                    numOfAandB++;
                    numOfA++;
                    numOfAorB++;
                } else if (hasWord1 || hasWord2) {
                    numOfAorB++;
                    numOfA++;
                } else if (hasWord1) {
                    numOfA++;
                }
            }
        }
        System.out.println(numOfA);
        System.out.println(numOfAorB);
        System.out.println(numOfAandB);
    }
}
