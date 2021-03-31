package elvis.leetcode;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int r = mat.length, c = mat[0].length, window = 0;
        int[][] ans = new int[r][c];
        for (int i = 0; i <= K; i++) {
            if (i >= r)
                continue;
            for (int j = 0; j <= K; j++) {
                if (j >= c)
                    continue;
                ans[0][0] += mat[i][j];
            }
        }
        for (int i = 0; i < r; i++) {
            if (i != 0) {
                ans[i][0] = ans[i - 1][0];
                for (int j = 0; j <= K; j++) {
                    if (j >= c)
                        continue;
                    if (i + K < r)
                        ans[i][0] += mat[i + K][j];
                    if (i - K - 1 >= 0)
                        ans[i][0] -= mat[i - K - 1][j];
                }
            }
            for (int j = 0; j < c; j++) {
                if (j == 0)
                    continue;
                ans[i][j] = ans[i][j - 1];
                //k 表示行
                for (int k = i - K; k <= i + K; k++) {
                    if (k < 0 || k >= r)
                        continue;
                    if (j + K < c)
                        ans[i][j] += mat[k][j + K];
                    if (j - K - 1 >= 0)
                        ans[i][j] -= mat[k][j - K - 1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MatrixBlockSum mbs = new MatrixBlockSum();
        int[][] a = mbs.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2);
        System.out.println(a);
    }
}
