package elvis.leetcode;


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements_Mine(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (nums[j % nums.length] <= nums[i]) {
                j++;
                if (j % nums.length == i) {
                    break;
                }
            }
            if (j % nums.length == i)
                ans[i] = -1;
            else
                ans[i] = nums[j % nums.length];
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i % n]) {
                ans[s.pop()] = nums[i % n];
            }
            if (i < n)
                s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElements nge = new NextGreaterElements();
//        int[] a = nge.nextGreaterElements(new int[]{1, 2, 1});
        int[] a = nge.nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        System.out.println(a);
    }
}
