package elvis.leetcode;

import java.util.Arrays;

public class MaxEnvelopes {

    public int maxEnvelopes_Other(int[][] envelopes) {
        if (envelopes.length < 1)
            return 0;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        //求最长递增子序列长度
        int ans = 1;
        //dp数组 含义为在长度为index的情况下的最长递增子序列  dp[index]内存满足这一条件的最小值
        int[] dp = new int[envelopes.length];
        dp[0] = envelopes[0][1];
        for (int[] enveolpe : envelopes)
            loop1:{
                if (enveolpe == envelopes[0])
                    continue;
                int l = 0, r = ans - 1;//左右指针
                if (dp[r] < enveolpe[1]) {//如果当前值比最大值还大，那么就拓展
                    dp[ans] = enveolpe[1];
                    ans++;
                    continue;
                } else {//否则就二分搜索，核心思路为为了能够让最长递增子序列够长，需要保证在值递增的情况下每个值尽可能的小
                    int res = r;
                    while (l <= r) {//找最小的递增位置
                        int mid = l + (r - l) / 2;
                        if (dp[mid] < enveolpe[1]) {//如果当前值更大，不符合要求
                            l = mid + 1;
                        } else if (dp[mid] > enveolpe[1]) {//如果当前值小，记录当前的值，同时改变右指针继续搜索
                            res = mid;
                            r = mid - 1;
                        } else {//如果有相等就不用考虑了 继续搜下一个
                            break loop1;
                        }
                    }
                    dp[res] = enveolpe[1];
                }
            }
        return ans;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        return 0;
    }

    public static void main(String[] string) {
        MaxEnvelopes me = new MaxEnvelopes();
//        System.out.println(me.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}
