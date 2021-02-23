package elvis.leetcode;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c)
            return nums;
        int[][] ret = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            ret[i / c][i % c] = nums[i / col][i % col];
        }
        return ret;
    }

    public static void main(String[] args) {
        MatrixReshape mr = new MatrixReshape();
        int[][] ret = mr.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
//        int[][] ret = mr.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}
