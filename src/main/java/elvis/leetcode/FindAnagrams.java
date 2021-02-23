package elvis.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        int[] map = new int[26];
        int left = 0, right = p.length();
        for (int i = 0; i < p.length(); i++)
            map[s.charAt(i) - 'a']++;
        for (int i = 0; i < p.length(); i++)
            map[p.charAt(i) - 'a']--;
        boolean f = true;
        for (int i = 0; i < 26; i++)
            if (map[i] != 0) {
                f = false;
                break;
            }
        if (f)
            ans.add(left);

        while (right < s.length()) {
            map[s.charAt(left) - 'a']--;
            left++;
            map[s.charAt(right) - 'a']++;
            right++;

            f = true;
            for (int i = 0; i < 26; i++)
                if (map[i] != 0) {
                    f = false;
                    break;
                }
            if (f)
                ans.add(left);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams fa = new FindAnagrams();
//        System.out.println(fa.findAnagrams("cbaebabacd", "abc"));
        System.out.println(fa.findAnagrams("abab", "ab"));
    }
}
