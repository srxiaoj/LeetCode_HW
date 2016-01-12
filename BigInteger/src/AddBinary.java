import java.math.BigInteger;

public class AddBinary {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AddBinary obj = new AddBinary();
        String a = "111";
        String b = "111";
        System.out.println(obj.addBinary(a, b));
        
    }
    public String addBinary(String a, String b) {
        /*
        // method 1
        return (new BigInteger(a, 2)).add(new BigInteger(b, 2)).toString(2);
        */
        
        
        // method 2: add character by character
        if (a.equals("") && b.equals("")) {
            return "";
        } else if (a.equals("")) {
            return b;
        } else if (b.equals("")) {
            return a;
        }
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder aSB;
        StringBuilder bSB;
        if (aLen < bLen) {
            aSB = new StringBuilder(b);
            bSB = new StringBuilder(a);
        } else {
            aSB = new StringBuilder(a);
            bSB = new StringBuilder(b);
        }
//        int loopLength = Math.min(aLen, bLen);
        int diff = Math.abs(aLen - bLen);
        for (int i = aSB.length() - 1; i >= diff; i--) {
            int sum = Character.getNumericValue(aSB.charAt(i)) + Character.getNumericValue(bSB.charAt(i - diff));
            if (sum == 1) {
                aSB.setCharAt(i, '1');
            }
            if (sum == 2) {
                aSB.setCharAt(i, '0'); // set current character to 0
                if (i > 0) {
                    int preBit = Character.getNumericValue(aSB.charAt(i - 1)) + 1;
                    String bit = String.valueOf(preBit);
                    aSB.setCharAt(i - 1, bit.charAt(0));
                } else {
                    aSB.insert(0, '1');
                }
            }
            if (sum == 3) {
                aSB.setCharAt(i, '1'); // set current character to 1
                if (i > 0) {
                    int preBit = Character.getNumericValue(aSB.charAt(i - 1)) + 1;
                    String bit = String.valueOf(preBit);
                    aSB.setCharAt(i - 1, bit.charAt(0));
                } else {
                    aSB.insert(0, '1');
                }
            }
        }
        System.out.println(diff - 1);
        for (int i = diff - 1; i >= 0; i--) {
            if (aSB.charAt(i) == '2') {
                aSB.setCharAt(i, '0');
                if (i > 0) {
                    int preBit = Character.getNumericValue(aSB.charAt(i - 1)) + 1;
                    String bit = String.valueOf(preBit);
                    aSB.setCharAt(i - 1, bit.charAt(0));
                }
                else 
                    aSB.insert(0, '1');
            }
        }
        return aSB.toString();
        
        
        
        /*
        // method 3: overflow if a and b is large integer 
        if (a.equals("") && b.equals("")) return "";
        if (a.equals("")) return b;
        if (b.equals("")) return a;
        int sum = binaryToDecimal(Integer.parseInt(a)) + binaryToDecimal(Integer.parseInt(b));
        return decimalToBinary(sum);
        */
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
