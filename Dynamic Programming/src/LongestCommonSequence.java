
public class LongestCommonSequence {

    public static void main(String[] args) {
        char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
        int m = X.length;
        int n = Y.length;
        char[][] b = new char[m + 1][n + 1];
        int[][] c = new int[m + 1][n + 1];
        longestCommonSequence(X, Y, b, c);
        printLCS(b, X, m, n);
    }
    public static void longestCommonSequence(char[] X, char[] Y, char[][] b, int[][] c) {
        int m = X.length;
        int n = Y.length;
        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) { // compare the ith element in X and Y
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '\\';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '|';
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = '<';
                }
//                if (X[i - 1] == Y[j - 1]) { // compare the ith element in X and Y
//                  c[i][j] = c[i - 1][j - 1] + 1;
//              } else {
//                  c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
//              }
            }
        }
    }
    private static void printLCS(char[][] b, char[] X, int i, int j) {
        if (i == 0 || j == 0) return;
        if (b[i][j] == '\\') {
            printLCS(b, X, i - 1, j - 1);
            System.out.print(X[i - 1] + " ");
        } else if (b[i][j] == '|') {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }
}
