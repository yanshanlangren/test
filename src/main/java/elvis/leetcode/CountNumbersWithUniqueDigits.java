package elvis.leetcode;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sqr = 1;
            for (int j = 0; j < i - 1; j++)
                sqr *= (9 - j);
            dp[i] = dp[i - 1] + 9 * sqr;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits cnwud = new CountNumbersWithUniqueDigits();
        System.out.println(cnwud.countNumbersWithUniqueDigits(0));
    }
}
