package elvis.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 */

public class SwimInWater {
    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //grid[i][j] 所需的最低水位
        int[][] min = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                min[i][j] = Integer.MAX_VALUE;
        min[0][0] = grid[0][0];
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, 0});

        int[][] load = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] n = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = n[0] + load[i][0];
                int y = n[1] + load[i][1];
                if (x < 0 || x >= row || y < 0 || y >= col)
                    continue;
                // x, y 需要的最低水位, 当前最低值和x, y水位中的大值
                int height = Math.max(min[n[0]][n[1]], grid[x][y]);
                if (height < min[x][y]) {
                    min[x][y] = height;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return min[row - 1][col - 1];
    }
}
