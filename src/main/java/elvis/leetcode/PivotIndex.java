package elvis.leetcode;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length < 1)
            return -1;
        int right = 0;
        for (int i = 1; i < nums.length; i++)
            right += nums[i];
        if (right == 0)
            return 0;
        int left = 0;
        for (int i = 1; i < nums.length; i++)
            if ((right -= nums[i]) == (left += nums[i - 1]))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pi = new PivotIndex();
        System.out.println(pi.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pi.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pi.pivotIndex(new int[]{2, 1, -1}));
        System.out.println(pi.pivotIndex(new int[]{0, 0, 0, 0, 1}));
    }
}
