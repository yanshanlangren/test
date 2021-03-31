package elvis.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] a = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    a[i][0]++;
                else a[i][1]++;
            }
        }
        Arrays.sort(a, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return m * (a1[1] - a2[1]) + n * (a1[0] - a2[0]);
            }
        });
        int M = 0, N = 0, i;
        for (i = 0; i < strs.length; i++) {
            M += a[i][0];
            N += a[i][1];
            if (M > m || N > n) {
                break;
            }
        }
        return i;
    }

    public int findMaxForm_DP(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];
        //dp[i][j][k] = Math.max(dp[i-1][j-c0][k-c1]+1, dp[i][j][k])
        for (int i = 0; i < len; i++) {
            int c0 = 0, c1 = 0;
            for (char c : strs[i].toCharArray())
                if (c == '0')
                    c0++;
                else c1++;
            for (int j = 1; j <= m; j++)
                for (int k = 1; k <= n; k++)
                    if (j < c0 || k < c1)
                        dp[i][j][k] = i == 0 ? 0 : dp[i - 1][j][k];
                    else
                        dp[i][j][k] = Math.max(i == 0 ? 0 : dp[i - 1][j - c0][k - c1] + 1, dp[i][j][k]);
        }
        return dp[len - 1][m][n];
    }

    public static void main(String[] args) {
        FindMaxForm fmf = new FindMaxForm();
        System.out.println(fmf.findMaxForm_DP(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(fmf.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
//        System.out.println(fmf.findMaxForm_DP(new String[]{"111", "1000", "1000", "1000"}, 9, 3));
    }

}
