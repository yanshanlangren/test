package elvis.leetcode;

public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, current = 0, max = 0;
        while (right < A.length) {
            // move right
            if (A[right] == 1)
                current++;
            right++;

            //move left
            while (current + K < right - left) {
                if (A[left] == 1)
                    current--;
                left++;
            }

            //calc
            if (current + K >= right - left && right - left > max) {
                max = right - left;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestOnes lo = new LongestOnes();
//        System.out.println(lo.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(lo.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
