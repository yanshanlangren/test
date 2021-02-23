package elvis.leetcode;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, zCount = 0, max = 0;
        while (right < nums.length) {
            while (zCount > 0 && left < right) {
                if (nums[left] != 1)
                    zCount--;
                left++;
            }
            if (nums[right] != 1)
                zCount++;
            right++;

            if (zCount == 0 && right - left > max)
                max = right - left;
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes fmco = new FindMaxConsecutiveOnes();
//        System.out.println(fmco.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(fmco.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 0, 1, 1, 1}));
    }
}
