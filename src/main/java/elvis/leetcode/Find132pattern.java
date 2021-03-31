package elvis.leetcode;

import java.util.Stack;

public class Find132pattern {
    public boolean find132pattern_Loop(int[] nums) {
        int len = nums.length, n1, n2;
        for (int i = 0; i < len - 2; i++) {
            n1 = nums[i];
            for (int j = i + 1; j < len - 1; j++)
                if (nums[j] > n1) {
                    n2 = nums[j];
                    for (int k = j + 1; k < len; k++)
                        if (nums[k] < n2 && nums[k] > n1)
                            return true;
                }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n2 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < n2)
                return true;
            while (!s.empty() && nums[i] > s.peek()) {
                n2 = s.peek();
                s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Find132pattern f = new Find132pattern();
        System.out.println(f.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(f.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(f.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(f.find132pattern(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
    }
}
