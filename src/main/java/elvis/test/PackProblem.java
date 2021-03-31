package elvis.test;

public class PackProblem {
    /**
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    public int ZeroOnePack(int V, int N, int[] weight, int[] value) {
        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[N][V];
        //则容量为V的背包能够装入物品的最大值为
//        int maxValue = dp[N][V];
//        //逆推找出装入背包的所有商品的编号
//        int j = V;
//        String numStr = "";
//        for (int i = N; i > 0; i--) {
//            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
//            if (dp[i][j] > dp[i - 1][j]) {
//                numStr = i + " " + numStr;
//                j = j - weight[i - 1];
//            }
//            if (j == 0)
//                break;
//        }
//        return numStr;
    }

    /**
     * 0-1背包问题优化
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    public int ZeroOnePack_Optimised(int V, int N, int[] weight, int[] value) {
        int[] dp = new int[V + 1];
        for (int i = 1; i < N; i++) {
            for (int j = V; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }

    /**
     * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param n 台阶数
     */
    public int frogJump(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            if (i >= 2)
                dp[i] += dp[i - 2];
            if (i >= 1)
                dp[i] += dp[i - 1];
        }
        return dp[n];
    }

    public int frogJump_Other(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     */
    public int robotPath(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0)
                    dp[i][j] += dp[i - 1][j];
                if (j > 0)
                    dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     *
     * @param arr
     * @return
     */
    public int minPath(int[][] arr) {
        int r = arr.length, c = arr[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < r; i++)
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        for (int i = 1; i < c; i++)
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[r - 1][c - 1];
    }

    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        //dp[i][j] 表示word1的前i个字符转成word2的前j个字符需要的最少操作;
        int[][] dp = new int[n1 + 1][n2 + 1];
        //初始化w1 0长度到w2 i长度最少操作(增加i个字符)
        for (int i = 1; i <= n2; i++)
            dp[0][i] = dp[0][i - 1] + 1;
        //初始化w1 i长度到w2 0 长度操作(删除i个字符)
        for (int i = 1; i <= n1; i++)
            dp[i][0] = dp[i - 1][0] + 1;
        //状态转移, w1 i-1 到 w2 j-1 需要最少dp[i-1][j-1]次操作, 如果w1[i]和w2[j]相等, dp[i][j] = dp[i-1][j-1] (不用操作)
        //如不相等, 可以从dp[i-1][j] 减少w1[i]字符/dp[i][j-1]增加w2[j]到达w2[j]/dp[i-1][j-1]把w1[i]改成w2[j],都需要一次操作, 选最小值
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        PackProblem pp = new PackProblem();
//        System.out.println(pp.ZeroOnePack_Optimised(5, 4, new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 5}));
//        System.out.println(pp.frogJump(10));
//        System.out.println(pp.robotPath(2, 2));
//        System.out.println(pp.minPath(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
//        System.out.println(pp.minDistance("horse", "ros"));
        System.out.println(pp.minDistance("intention", "execution"));
    }
}
