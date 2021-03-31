package elvis.leetcode;

public class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        boolean R = false, N = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1])
                R = true;
            if (A[i] < A[i - 1])
                N = true;
        }
        return !R || !N;
    }

    public static void main(String[] args) {
        IsMonotonic im = new IsMonotonic();
        System.out.println(im.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(im.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(im.isMonotonic(new int[]{1, 3, 2}));
    }
}
