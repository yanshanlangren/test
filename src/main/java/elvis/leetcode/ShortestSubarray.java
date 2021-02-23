package elvis.leetcode;

/**
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 */
public class ShortestSubarray {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        //缓存特征值变量, 变量的实际意义依据搜索的深度而定
        int[] cache = new int[len];
        for (int i = 0; i < len; i++) {
            cache[i] = A[i];
            if (cache[i] >= K)
                return 1;
        }
        // i 表示累加的长度, i=n表示, 累加了n+1(包括本身节点)个步长,  最多为length-1
        for (int i = 1; i < len; i++) {
            // j 表示累加的起始值, j=n, cache[j]表示从j-i 到j的累加值, 等于j-i+1到j的累加值 加 j-i的累加值
            for (int j = i; j < len; j++) {
                cache[j] = cache[j] + A[j - i];
                if (cache[j] >= K)
                    return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestSubarray ss = new ShortestSubarray();
        int[] A = {2, -1, 2};
        System.out.println(ss.shortestSubarray(A, 3));
    }
}
