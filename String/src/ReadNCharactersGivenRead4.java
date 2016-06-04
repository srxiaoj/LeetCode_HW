/**
 * Created by thanksgiving on 6/3/16.
 */
public class ReadNCharactersGivenRead4 extends Reader4 {
    public int read(char[] buf, int n) {
        int totalRead = 0;
        boolean eof = false;
        char[] temp = new char[4];
        while (!eof && totalRead < n) {
            int count = read4(temp);
            eof = (count < 4);

            if (n - totalRead < count) {
                count = n - totalRead;
            }
            for (int i = 0; i < count; i++) {
                buf[totalRead] = temp[i];
                totalRead++;
            }
        }
        return totalRead;
    }

    public static void main(String[] args) {

    }
}

class Reader4 {
    int read4(char[] buf) {
        // fake implementation
        return 4;
    }
}