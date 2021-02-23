package elvis.leetcode;

public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //前面比后面大
            if (nums[i] > nums[i + 1]) {
                if (i == 0 || nums[i - 1] <= nums[i + 1])
                    nums[i] = nums[i + 1];
                else if (nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
                if (count++ > 0)
                    return false;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        CheckPossibility cp = new CheckPossibility();
//        System.out.println(cp.checkPossibility(new int[]{4, 2, 3}));
//        System.out.println(cp.checkPossibility(new int[]{4, 3, 2}));
//        System.out.println(cp.checkPossibility(new int[]{5, 7, 1, 8}));
        System.out.println(cp.checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
