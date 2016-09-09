import java.util.Random;

/**
 * Created by thanksgiving on 7/13/16.
 */
public class RandomPhoneNumber {
    public static void main(String[] args) {
        System.out.println(generateRandomPhoneNumber());
    }

    public static String generateRandomPhoneNumber() {
        Random r = new Random();
        int first = r.nextInt(10);
        String res = String.valueOf(first) + randInt(100000000, 999999999);
        return res;
    }

    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
