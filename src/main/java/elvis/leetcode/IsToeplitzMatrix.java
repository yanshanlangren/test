package elvis.leetcode;

public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        //竖边
        for (int i = 0; i < r; i++) {
            int m0 = matrix[i][0];
            for (int j = 1; i + j < r && j < c; j++) {
                if (matrix[i + j][j] != m0)
                    return false;
            }
        }
        //横边
        for (int j = 1; j < c; j++) {
            int m0 = matrix[0][j];
            for (int i = 1; i + j < c && i < r; i++) {
                if (matrix[i][i + j] != m0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsToeplitzMatrix itm = new IsToeplitzMatrix();
        System.out.println(itm.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
//        System.out.println(itm.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
//        System.out.println(itm.isToeplitzMatrix(new int[][]{{11, 74, 0, 93}, {40, 11, 74, 7}}));
    }
}
