package elvis.leetcode;

public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        sums = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                sums[i][j] = sum + (i == 0 ? 0 : sums[i - 1][j]) - (i == 0 ? 0 : sums[i - 1][sums[0].length - 1]);
            }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2][col2] - (col1 == 0 ? 0 : sums[row2][col1 - 1]) - (row1 == 0 ? 0 : sums[row1 - 1][col2]) + (col1 * row1 == 0 ? 0 : sums[row1 - 1][col1 - 1]);
    }

    public static void main(String[] args) {
        NumMatrix nm = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(nm.sumRegion(2, 1, 4, 3));
        System.out.println(nm.sumRegion(1, 1, 2, 2));
        System.out.println(nm.sumRegion(1, 2, 2, 4));
    }
}
