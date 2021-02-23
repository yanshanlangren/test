package elvis.leetcode;

import java.util.Arrays;

public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] cal = new int[100];
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            count += cal[domino[0] + domino[1] * 10]++;
        }
        return count;
    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        NumEquivDominoPairs nedp = new NumEquivDominoPairs();
        System.out.println(nedp.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println((System.currentTimeMillis() - t0) + " ms");
    }
}
