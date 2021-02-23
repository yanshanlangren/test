package elvis.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring_HashMap(String s) {
        char[] array = s.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        //init window
        int i;
        for (i = 0; i < array.length; i++) {
            if (m.containsKey(array[i]))
                break;
            m.put(array[i], 1);
        }
        int left = 0, right = i, max = i;
        HashSet<Character> repeatSet = new HashSet<>();
        while (right < array.length) {
            if (!repeatSet.isEmpty()) {
                if (m.get(array[left]) > 2)
                    m.put(array[left], m.get(array[left]) - 1);
                else if (m.get(array[left]) == 2) {
                    m.put(array[left], 1);
                    repeatSet.remove(array[left]);
                } else {
                    m.remove(array[left]);
                }
                left++;
            }
            if (m.containsKey(array[right])) {
                m.put(array[right], m.get(array[right]) + 1);
                repeatSet.add(array[right]);
            } else {
                m.put(array[right], 1);
            }
            right++;

            if (repeatSet.isEmpty() && max < right - left) {
                max = right - left;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        int[] voca = new int[128];
        while (right < s.length()) {
            voca[s.charAt(right)]++;
            while (voca[s.charAt(right)] > 1) {
                voca[s.charAt(left)]--;
                left++;
            }

            right++;

            if (right - left > max)
                max = right - left;
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
//        System.out.println(lols.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lols.lengthOfLongestSubstring("bbbb"));
        System.out.println(lols.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lols.lengthOfLongestSubstring_HashMap(""));
    }
}
