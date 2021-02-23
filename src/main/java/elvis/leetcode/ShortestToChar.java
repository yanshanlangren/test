package elvis.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                q.offerLast(i);
                ans[i] = 0;
            } else ans[i] = -1;
        }
        int left = -s.length(), right = q.pollFirst();
        for (int i = 0; i < s.length(); i++) {
            if (ans[i] != 0) {
                ans[i] = Math.min(Math.abs(i - left), Math.abs(right - i));
            } else {
                left = right;
                Integer tmp = q.pollFirst();
                if (tmp == null)
                    right = Integer.MAX_VALUE;
                else
                    right = tmp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortestToChar stc = new ShortestToChar();
        System.out.println(stc.shortestToChar("loveleetcode", 'c'));
    }
}
