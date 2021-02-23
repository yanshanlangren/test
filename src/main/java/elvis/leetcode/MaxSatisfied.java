package elvis.leetcode;

public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int window = 0;
        for (int i = 0; i < X; i++)
            window += customers[i];
        for (int i = X; i < customers.length; i++)
            window += (1 - grumpy[i]) * customers[i];
        int max = window;
        for (int i = 1; i <= customers.length - X; i++) {
            window -= grumpy[i - 1] * customers[i - 1];
            window += grumpy[i + X - 1] * customers[i + X - 1];
            if (window > max)
                max = window;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSatisfied ms = new MaxSatisfied();
//        System.out.println(ms.maxSatisfied(new int[]{1, 2, 3, 4}, new int[]{1, 1, 1, 0}, 2));
        System.out.println(ms.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
