
public class binaryToDecimal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public int binaryToDecimal(int binaryNumber) {
        int decimal = 0;
        int p = 0;
        while (true) {
            if (binaryNumber == 0) {
                break;
            } else {
                int temp = binaryNumber % 10;
//                decimal += temp * Math.pow(2, p);
                decimal += temp * (1 << p);
                binaryNumber = binaryNumber / 10;
                p++;
            }
        }
        return decimal;
    }
}
