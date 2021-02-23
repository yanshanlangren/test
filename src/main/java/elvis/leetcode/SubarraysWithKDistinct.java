package elvis.leetcode;

public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct_Loop(int[] A, int K) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            int[] map = new int[A.length + 1];
            int current = 0;
            for (int j = i; j < A.length; j++) {
                if (map[A[j]]++ == 0)
                    current++;
                if (current == K) {
                    total++;
                    System.out.println("from " + i + " to " + j);
                } else if (current > K)
                    break;
            }
        }
        return total;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithMostK(A, K) - subarraysWithMostK(A, K - 1);
    }

    public int subarraysWithMostK(int[] A, int K) {
        int right = 0, left = 0, total = 0, current = 0;
        int[] map = new int[A.length + 1];
        while (right < A.length) {
            if (map[A[right++]]++ == 0)
                current++;
            while (current > K) {
                if (map[A[left++]]-- == 1)
                    current--;
            }
            total += right - left + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        SubarraysWithKDistinct swd = new SubarraysWithKDistinct();
        System.out.println(swd.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
//        System.out.println(swd.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
//        System.out.println(swd.subarraysWithKDistinct(new int[]{1, 2}, 1));

    }
}
