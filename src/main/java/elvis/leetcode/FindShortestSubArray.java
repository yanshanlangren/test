package elvis.leetcode;

import java.util.HashMap;

public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> du = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(nums[0], 0);
        du.put(nums[0], 1);
        int maxElement = nums[0], max = 1, lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (du.containsKey(nums[i])) {
                int count = du.get(nums[i]);
                du.put(nums[i], count + 1);
                if (count + 1 > max || (count + 1 == max && i - first.get(nums[i]) < lastIndex - first.get(maxElement))) {
                    max = count + 1;
                    maxElement = nums[i];
                    lastIndex = i;
                }
            } else {
                du.put(nums[i], 1);
                first.put(nums[i], i);
            }
        }
        return lastIndex - first.get(maxElement) + 1;
    }

    public static void main(String[] args) {
        FindShortestSubArray fssa = new FindShortestSubArray();
//        System.out.println(fssa.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
//        System.out.println(fssa.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
//        System.out.println(fssa.findShortestSubArray(new int[]{1}));
//        System.out.println(fssa.findShortestSubArray(new int[]{1, 1}));
        System.out.println(fssa.findShortestSubArray(new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2}));
    }
}
