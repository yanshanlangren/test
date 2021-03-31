package elvis.leetcode;

public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                t[j][i] = matrix[i][j];
        }
        return t;
    }

    public static void main(String[] args) {
        Transpose t = new Transpose();
        int[][] res = t.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(res);
    }
}
