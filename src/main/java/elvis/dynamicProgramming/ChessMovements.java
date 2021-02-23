package elvis.dynamicProgramming;

public class ChessMovements {
    public int chessMovements(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++)
            cache[i][0] = 1;
        for (int i = 0; i < n; i++)
            cache[0][i] = 1;
        for (int i = 2; i < m + n - 1; i++) {
            for (int j = 1; j < i; j++) {
                cache[i - j][j] = cache[i - j - 1][j] + cache[i - j][j - 1];
            }
        }
        return cache[m - 1][n - 1];
    }

    public static void main(String[] args) {
        ChessMovements cm = new ChessMovements();
        System.out.println(cm.chessMovements(2, 2));
    }
}
