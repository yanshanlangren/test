package elvis.leetcode;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        //init window
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int max = sum;
        for (int i = 1; i <= nums.length - k; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            if (max < sum)
                max = sum;
        }
        return ((double) max) / k;
    }

    public static void main(String[] args) {
        FindMaxAverage fma = new FindMaxAverage();
        System.out.println(fma.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
