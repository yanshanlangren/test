package elvis.leetcode;

import java.util.Arrays;

public class CountVowelStrings {
    public int countVowelStrings(int n) {
        // {a,e,i,o,u} -> {0,1,2,3,4}
        int[][] dp = new int[n + 1][5];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j; k < 5; k++)
                    dp[i][j] += dp[i - 1][k];
            }
        }
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }

    public static void main(String[] args) {
        CountVowelStrings cvs = new CountVowelStrings();
        System.out.println(cvs.countVowelStrings(3));
    }
}
