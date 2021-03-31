package elvis.leetcode;

public class MaxDotProduct {
    public int maxDotProduct_origin(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 2; i <= nums1.length + nums2.length; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if (j <= nums1.length && i - j <= nums2.length)
                    dp[j][i - j] = Math.max(Math.max(dp[j - 1][i - j], dp[j][i - j - 1]), dp[j - 1][i - j - 1] + nums1[j - 1] * nums2[i - j - 1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + nums1[i] * nums2[j]);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        MaxDotProduct m = new MaxDotProduct();
//        System.out.println(m.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
//        System.out.println(m.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
//        System.out.println(m.maxDotProduct(new int[]{1, 1}, new int[]{-1, -1}));
        System.out.println(m.maxDotProduct(new int[]{5, -4, -3}, new int[]{-4, -3, 0, -4, 2}));
    }
}
