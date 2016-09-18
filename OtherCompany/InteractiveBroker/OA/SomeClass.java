class SomeClass {

    void divide(int num, int den) {
        if (den == 0) {
            throw new RuntimeException("");
        }
        System.out.println("" + (num / den));

    }

    void fun() {
        try {
            divide(4, 2);
        } catch (RuntimeException e) {

        }

    }

    public static void main(String[] args) {

        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {

            if (b == 0x90) {

                System.out.print("We found it");

            }

        }



    }

}