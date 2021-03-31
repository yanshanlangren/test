package elvis.leetcode;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] w = new int[n];
        w[0] = 1;
        w[1] = 2;
        for (int i = 2; i < n; i++) {
            w[i] = w[i - 2] + w[i - 1];
        }
        return w[n - 1];
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(9));
    }
}
