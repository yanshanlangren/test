package elvis.leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], curMax, pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(curMax, ans);
            pre = curMax;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubArray m = new MaxSubArray();
        System.out.println(m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
