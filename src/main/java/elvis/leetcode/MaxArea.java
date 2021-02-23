package elvis.leetcode;

public class MaxArea {
    public int maxArea_FullSearch(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++)
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
        }
        return max;
    }

    public int maxArea(int[] height) {
        if (height.length <= 1)
            return -1;
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        System.out.println(ma.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
