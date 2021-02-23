package elvis.leetcode;

public class LongestWPI {
    public int longestWPI(int[] hours) {
        int len = hours.length;
        // 初始化状态数组 1为"劳累的一天", -1为"不劳累的一天"
        int[] status = new int[len];
        // 初始化缓存, cache[n] = 第一天到第n天的值
        int cache[] = new int[len];
        status[0] = hours[0] > 8 ? 1 : -1;
        cache[0] = status[0];
        for (int i = 1; i < len; i++) {
            status[i] = hours[i] > 8 ? 1 : -1;
            cache[i] = cache[i - 1] + status[i];
        }

        // i 为"表现良好的时间段"长度, 从长到短搜索, 初始值为数组长度-1
        for (int i = len - 1; i >= 0; i--) {
            if (cache[i] > 0)
                return i + 1;
            // j 为索引起始值, j=n 表示计算从 n-i 起到n的特征值
            for (int j = i + 1; j < len; j++) {
                cache[j] = cache[j] - status[j - i - 1];
                if (cache[j] > 0)
                    return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestWPI lw = new LongestWPI();
        System.out.println(lw.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
    }
}
