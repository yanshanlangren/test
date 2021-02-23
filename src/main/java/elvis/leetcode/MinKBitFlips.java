package elvis.leetcode;

public class MinKBitFlips {
    public int minKBitFlips_DoubleLoop(int[] A, int K) {
        int count = 0;
        int[] changed = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if ((A[i] + changed[i]) % 2 == 0) {
                if (i > A.length - K)
                    return -1;
                count++;
                for (int j = i; j < i + K; j++) {
                    changed[j]++;
                }
            }
        }
        return count;
    }

    public int minKBitFlips(int[] A, int K) {
        int count = 0, s = 0;
        int[] changed = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            s += changed[i];
            if ((s + A[i]) % 2 == 0) {
                if (i > A.length - K)
                    return -1;
                count++;
                changed[i]++;
                s++;
                changed[i + K]--;
            }
        }
        return count;
    }

    int minKBitFlips_C(int[] A, int K) {
        int n = A.length;
        int[] dif = new int[n + 1];
        int s = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            s += dif[i];
            if ((s + A[i]) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                dif[i]++;
                dif[i + K]--;
                ret++;
                s++;
            }

        }

        return ret;
    }

    public static void main(String[] args) {
        MinKBitFlips mbf = new MinKBitFlips();
//        System.out.println(mbf.minKBitFlips(new int[]{0, 1, 0}, 1));
        System.out.println(mbf.minKBitFlips(new int[]{1, 1, 0}, 2));
//        System.out.println(mbf.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
//        int[] A = new int[30000];
//        for (int i = 0; i < 3000; i++) {
//            for (int j = 0; j < 10; j++)
//                A[i * 10 + j] = Math.random() > 0.5 ? 1 : 0;
//        }
//        long t0 = System.currentTimeMillis();
//        System.out.println(mbf.minKBitFlips(A, 14750));
//        System.out.println((System.currentTimeMillis() - t0) + " ms");

    }
}
