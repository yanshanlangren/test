package elvis.leetcode;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++)
            res[i / c][i % c] = (1 - A[i / c][c - i % c - 1]);
        return res;
    }

    public static void main(String[] args) {
        FlipAndInvertImage faii = new FlipAndInvertImage();
//        int[][] res = faii.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        int[][] res = faii.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}});
        System.out.println("");
    }
}
