package elvis.leetcode;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            max = Math.max(max, dp[i]);
        }
        return max + 1;
    }

    public static void main(String[] args) {

        LengthOfLIS lol = new LengthOfLIS();
//        System.out.println(lol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

//        System.out.println(lol.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lol.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
