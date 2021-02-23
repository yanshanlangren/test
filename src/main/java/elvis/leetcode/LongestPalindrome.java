package elvis.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String maxString = null;
        int index = 0, max = 0;
        while (index < s.length()) {
            //基数长度字符串
            int right = index, left = index;
            while (right < s.length() && left >= 0 && s.charAt(right) == s.charAt(left)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    maxString = s.substring(left, right + 1);
                }
                right++;
                left--;
            }
            //偶数长度字符串
            if (right + 1 < s.length() && s.charAt(index) != s.charAt(index + 1)) {
                index++;
                continue;
            }
            left = index;
            right = index + 1;
            while (right < s.length() && left >= 0 && s.charAt(right) == s.charAt(left)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    maxString = s.substring(left, right + 1);
                }
                right++;
                left--;
            }
            index++;
        }
        return maxString;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
//        System.out.println(lp.longestPalindrome("babad"));
//        System.out.println(lp.longestPalindrome("cbbd"));
//        System.out.println(lp.longestPalindrome("a"));
        System.out.println(lp.longestPalindrome("ac"));
    }
}
