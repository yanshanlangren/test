package elvis.leetcode;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] sum_row = new int[row];
        int[] sum_col = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum_row[i] += mat[i][j];
                sum_col[j] += mat[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && sum_row[i] == 1 && sum_col[j] == 1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumSpecial ns = new NumSpecial();
        System.out.println(ns.numSpecial(new int[][]{{0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}));
    }
}
