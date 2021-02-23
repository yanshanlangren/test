package elvis.leetcode;

public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        //init window
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += cardPoints[i];
        int max = sum;
        for (int i = 1; i <= k; i++) {
            sum += cardPoints[(cardPoints.length - i) % cardPoints.length];
            sum -= cardPoints[(k - i) % cardPoints.length];
            if (max < sum)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxScore ms = new MaxScore();
        System.out.println(ms.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(ms.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(ms.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));

    }
}
