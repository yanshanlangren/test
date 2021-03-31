package elvis.leetcode;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1, mjEle = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == mjEle)
                count++;
            else if (--count == 0) {
                mjEle = nums[++i];
                count++;
            }
        return mjEle;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(me.majorityElement(new int[]{3, 2, 3}));
    }
}
