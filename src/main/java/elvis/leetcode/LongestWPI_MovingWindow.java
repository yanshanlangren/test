package elvis.leetcode;

public class LongestWPI_MovingWindow {
    public int longestWPI(int[] hours) {
        if (hours.length == 0)
            return 0;
        int len = hours.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int busy = 0;
        int lazy = 0;
        while (right < len) {
            if (hours[right] > 8)
                busy++;
            else
                lazy++;

            // 找最大
            if (busy > lazy)
                max = Math.max(max, right - left);
            //左滑动
            if (max < right - left) {
                if (hours[left] > 8)
                    busy--;
                else
                    lazy--;
                left++;
            }

            //右滑动
            right++;
        }
        return right-left;
    }

    public static void main(String[] args) {
        LongestWPI_MovingWindow lw = new LongestWPI_MovingWindow();
//        System.out.println(lw.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
//        System.out.println(lw.longestWPI(new int[]{6, 6, 9}));
        System.out.println(lw.longestWPI(new int[]{6, 9, 9}));
    }
}
