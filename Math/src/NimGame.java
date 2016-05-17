public class NimGame {
    public static void main(String[] args) {
        NimGame obj = new NimGame();
        // System.out.println(obj.canWinNim(1348820612));
        System.out.println(obj.canWinNim(7));
    }

    public boolean canWinNim(int n) {
        if (n % 4 == 0)
            return false;
        else
            return true;

        // if (n <= 3) return true;
        // if (n == 4) return false;
        // return canWinNim(n - 1) || canWinNim(n - 2) || canWinNim(n - 3);

    }
}
