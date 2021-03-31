package elvis.leetcode;

public class NumDistinct {
    String s, t;
    int count = 0;

    public int numDistinct_traceBack(String s, String t) {
        this.s = s;
        this.t = t;
        traceBack(0, 0);
        return count;
    }

    public void traceBack(int match, int i) {
        if (match == t.length()) {
            count++;
            return;
        }
        while (i < s.length()) {
            if (t.charAt(match) == s.charAt(i))
                traceBack(match + 1, i + 1);
            i++;
        }
    }

    public int numDistinct(String s, String t) {
        //dp[i][j]=n s的第i位前有n个j
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++)
            dp[0][i] = 1;
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        NumDistinct nd = new NumDistinct();
//        System.out.println(nd.numDistinct("rabbbit", "rabbit"));
//        System.out.println(nd.numDistinct("babgbag", "bag"));
        System.out.println(nd.numDistinct_traceBack("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
    }
}
