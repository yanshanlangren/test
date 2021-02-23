package elvis.leetcode;

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
//        fastSort(0, nums.length - 1, nums);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0)
                sum += nums[i];
        return sum;
    }

    public static void main(String[] args) {
        ArrayPairSum aps = new ArrayPairSum();
//        System.out.println(aps.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(aps.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }
}
