package elvis.leetcode;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        int h = r * c - 1, l = 0;
        while (h > l) {
            int t = l + (h - l) / 2;
            int v = matrix[t / c][t % c];
            if (v < target) {
                l = t + 1;
            } else {
                h = t;
            }
        }
        return matrix[l / c][l % c] == target;
    }

    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
//        System.out.println(s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
//        System.out.println(s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        System.out.println(s.searchMatrix(new int[][]{{1}}, 1));
    }
}
