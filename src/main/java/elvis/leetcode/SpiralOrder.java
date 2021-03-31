package elvis.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int i = 0, j = 0;
        int r = matrix.length, c = matrix[0].length;
        int up = 1, right = matrix[0].length - 1, down = matrix.length - 1, left = 0;
        //dir 0 to right, 1 to down, 2 to left , 3 to up
        int dir = 0;
        if (c == 1)
            dir = 1;
        while (l.size() < r * c) {
            l.add(matrix[i][j]);
            switch (dir) {
                case 0:
                    j++;
                    if (j == right) {
                        dir = 1;
                        right--;
                    }
                    break;
                case 1:
                    i++;
                    if (i == down) {
                        dir = 2;
                        down--;
                    }
                    break;
                case 2:
                    j--;
                    if (j == left) {
                        dir = 3;
                        left++;
                    }
                    break;
                case 3:
                    i--;
                    if (i == up) {
                        dir = 0;
                        up++;
                    }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        SpiralOrder so = new SpiralOrder();
//        System.out.println(so.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
//        System.out.println(so.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(so.spiralOrder(new int[][]{{3}, {2}}));
    }
}
