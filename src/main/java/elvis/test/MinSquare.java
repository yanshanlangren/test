package elvis.test;

import java.util.Arrays;

public class MinSquare {
    public static void main(String[] args) {
        MinSquare ms = new MinSquare();
//        System.out.println(ms.minSquare(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
        System.out.println(ms.minSquare(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}}));
    }

    public int minSquare(int[][] p) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(p, ((int[] a, int[] b) -> (a[0] + a[1] - b[0] - b[1])));
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                for (int k = j + 1; k < p.length; k++) {
                    for (int l = k + 1; l < p.length; l++) {
                        if ((p[j][0] - p[i][0]) * (p[k][0] - p[i][0]) == 0
                                && ((p[k][1] - p[i][1]) * (p[j][1] - p[i][1]) == 0)
                                && ((p[l][0] - p[j][0]) * (p[l][0] - p[k][0]) == 0)
                                && ((p[l][1] - p[j][1]) * (p[l][1] - p[k][1]) == 0)) {
                            int s = (p[j][0] - p[i][0] + p[j][1] - p[i][1]) * (p[k][0] - p[i][0] + p[k][1] - p[i][1]);
                            min = Math.min(min, s);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
