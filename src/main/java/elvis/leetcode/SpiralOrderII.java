package elvis.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 1, right = n - 1, down = n - 1, left = 0;
        int i = 0, r = 0, c = 0;
        // 0 -> right, 1->down, 2-> left, 3->up,
        int dir = 0;
        while (i < n * n) {
            matrix[r][c] = i + 1;
            switch (dir) {
                case 0:
                    c++;
                    if (c == right) {
                        dir = (dir + 1) % 4;
                        right--;
                    }
                    break;
                case 1:
                    r++;
                    if (r == down) {
                        dir = (dir + 1) % 4;
                        down--;
                    }
                    break;
                case 2:
                    c--;
                    if (c == left) {
                        dir = (dir + 1) % 4;
                        left++;
                    }
                    break;
                case 3:
                    r--;
                    if (r == up) {
                        dir = (dir + 1) % 4;
                        up++;
                    }
            }
            i++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralOrderII so = new SpiralOrderII();
        int[][] x = so.generateMatrix(3);
    }
}
