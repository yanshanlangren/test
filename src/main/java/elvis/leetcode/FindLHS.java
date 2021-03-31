package elvis.leetcode;

import java.util.Arrays;

public class FindLHS {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0, mxLen = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] == 1 && right - left + 1 > mxLen) {
                mxLen = right - left + 1;
            }
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            right++;
        }
        return mxLen;
    }

    public static void main(String[] args) {
        FindLHS fl = new FindLHS();
//        System.out.println(fl.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
//        System.out.println(fl.findLHS(new int[]{1,2,3,4}));
        System.out.println(fl.findLHS(new int[]{1,1,1,1}));
    }
}
