package elvis.leetcode;

public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        //init window
        int i = 2;
        boolean isOdd = arr[0] < arr[1];
        for (; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && (i % 2 == 0 ^ !isOdd))
                continue;
            if (arr[i] < arr[i - 1] && (i % 2 == 1 ^ !isOdd))
                continue;
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}
