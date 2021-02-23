package elvis.leetcode;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        boolean isOdd = k % 2 == 1;
        //初始滑动窗口
        double[] mid_list = new double[nums.length - k + 1];
        //滑动窗口
        for (int i = 0; i <= nums.length - k; i++) {
            int[] window = new int[k];
            System.arraycopy(nums, i, window, 0, k);
            mid_list[i] = getMdian(window, isOdd);
        }
        return mid_list;
    }

    public double getMdian(int[] nums, boolean isOdd) {
        double m0 = 0.0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return ((double) nums[0] + (double) nums[1]) / 2;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
            if (isOdd && i == (nums.length - 1) / 2)
                return (double) min;
            else if (i == nums.length / 2 - 1)
                m0 = (double) min;
            else if (i == nums.length / 2) {
                return ((double) min + m0) / 2;
            }
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianSlidingWindow msw = new MedianSlidingWindow();
//        long t0 = System.currentTimeMillis();
//        double[] mid = msw.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        double[] mid = msw.medianSlidingWindow(new int[]{1}, 1);
//        double[] mid = msw.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2);
//        System.out.println("time: " + (System.currentTimeMillis() - t0));
//        for (int i = 0; i < mid.length; i++)
//            System.out.print(mid[i] + " ");
    }
}
