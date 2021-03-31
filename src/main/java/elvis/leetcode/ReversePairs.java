package elvis.leetcode;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = dp[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i])
                    dp[i + 1]++;
            }
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        ReversePairs r = new ReversePairs();
        System.out.println(r.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
