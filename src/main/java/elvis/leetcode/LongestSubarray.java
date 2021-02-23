package elvis.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LongestSubarray {
    public int longestSubarray_PriorityQueue(int[] nums, int limit) {
        int left = 0, right = 0, max = 1;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        while (right < nums.length) {
            maxQueue.add(nums[right]);
            minQueue.add(nums[right]);
            right++;

            while (maxQueue.peek() - minQueue.peek() > limit && left < right) {
                maxQueue.remove(nums[left]);
                minQueue.remove(nums[left]);
                left++;
            }

            if (maxQueue.peek() - minQueue.peek() <= limit && max < right - left) {
                max = right - left;
            }
        }
        return max;
    }

    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int left = 0, right = 0, len = nums.length;

        while (right < len) {
            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[right])
                minQueue.pollLast();
            minQueue.offerLast(right);
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[right])
                maxQueue.pollLast();
            maxQueue.offerLast(right);

            if (nums[maxQueue.peek()] - nums[minQueue.peek()] > limit) {
                if (maxQueue.peek() <= left)
                    maxQueue.poll();
                if (minQueue.peek() <= left)
                    minQueue.poll();
                left++;
            }

            right++;
        }
        return right - left;
    }

//    public int longestSubarray_Array(int[] nums, int limit) {
//        int[] minQueue = new int[nums.length];
//        int[] maxQueue = new int[nums.length];
//        int left = 0, right = 0, minHead = 0, minTail = 0, maxHead = 0, maxTail = 0, len = nums.length;
//        while (right < len) {
//            // add right
//            while (minHead < minTail && nums[minQueue[minHead - 1]] > nums[right])
//                minHead++;
//            minQueue[minTail++] = right;
//            while (maxHead < maxTail && nums[maxQueue[minHead - 1]] < nums[right])
//                maxHead++;
//            maxQueue[maxTail++] = right;
//
//            //whether add left
//            if (nums[maxQueue[maxHead - 1]] - nums[minQueue[minHead - 1]] > limit) {
//                if (maxQueue[maxHead] <= left)
//                    maxHead++;
//                if (minQueue[minHead] <= left)
//                    minHead++;
//                left++;
//            }
//
//            right++;
//        }
//        return right - left;
//    }

    public static void main(String[] args) {
        LongestSubarray ls = new LongestSubarray();
        long t0 = System.currentTimeMillis();
        System.out.println(ls.longestSubarray(new int[]{8, 2, 4, 7}, 4));
//        System.out.println(ls.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
//        System.out.println(ls.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
//        System.out.println(ls.longestSubarray(new int[]{2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2}, 2));

        System.out.println((System.currentTimeMillis() - t0) + "ms");
    }
}
