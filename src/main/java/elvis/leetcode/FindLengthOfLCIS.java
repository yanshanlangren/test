package elvis.leetcode;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int left = 0, right = 1, nonIncreaseCount = 0, max = nums.length > 1 ? 1 : nums.length;
        while (right < nums.length) {
            if (nums[right] <= nums[right - 1])
                nonIncreaseCount++;
            right++;

            if (nonIncreaseCount > 0) {
                if (nums[left] >= nums[left + 1])
                    nonIncreaseCount--;
                left++;
            }

            if (nonIncreaseCount == 0 && right - left > max) {
                max = right - left;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindLengthOfLCIS flol = new FindLengthOfLCIS();
        System.out.println(flol.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
//        System.out.println(flol.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }
}
