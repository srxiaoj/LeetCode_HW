
public class decimalToBinary {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        String binaryStr = "";
        while (true) {
            if (decimal == 0) {
                break;
            } else {
                int reminder = decimal % 2;
                binaryStr = reminder + binaryStr; // the sequence of "+" sign is important
                decimal = decimal >> 1;
            }
        }
        return binaryStr;
    }
}
