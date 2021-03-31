package elvis.leetcode;

import java.util.LinkedList;

public class ShortestPath {
    public int shortestPath(int[][] grid, int k) {
        int r = grid.length, c = grid[0].length;
        int[][][] shortest = new int[r][c][k + 1];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int l = 0; l <= k; l++)
                    shortest[i][j][l] = Integer.MAX_VALUE;
        shortest[0][0][k] = 0;
        LinkedList<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0, k});
        int[][] v = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            Integer[] node = q.poll();
            System.out.println("x=" + node[0] + ", y=" + node[1] + ", k=" + node[2]);
            for (int i = 0; i < 4; i++) {
                int x = node[0] + v[i][0];
                int y = node[1] + v[i][1];
                int s = shortest[node[0]][node[1]][node[2]];
                if (x < r && x >= 0 && y < c && y >= 0) {
                    if (grid[x][y] == 1 && node[2] > 0 && s + 1 < shortest[x][y][node[2] - 1]) {
                        q.add(new Integer[]{x, y, node[2] - 1});
                        shortest[x][y][node[2] - 1] = s + 1;
                    } else if (grid[x][y] == 0 && s + 1 < shortest[x][y][node[2]]) {
                        q.add(new Integer[]{x, y, node[2]});
                        shortest[x][y][node[2]] = s + 1;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++)
            min = Math.min(min, shortest[r - 1][c - 1][i]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
//        System.out.println(sp.shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
//        System.out.println(sp.shortestPath(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}}, 1));
        System.out.println(sp.shortestPath(new int[][]{{0, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {0, 0}, {0, 1}, {0, 1}, {0, 1}, {0, 0}, {1, 0}, {1, 0}, {0, 0}}, 4));
    }
}
