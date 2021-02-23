package elvis.leetcode;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int[] map = new int[26];
        for (int i = 0; i < len; i++)
            map[s1.charAt(i) - 'a']++;
        for (int right = 0, left = 0; right < s2.length(); right++) {
            map[s2.charAt(right) - 'a']--;
            if (right - left + 1 == len) {
                boolean flag = true;
                for (int j = 0; j < 26; j++)
                    if (map[j] != 0) {
                        flag = false;
                        break;
                    }
                if (flag)
                    return true;
                map[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
//        System.out.println(ci.checkInclusion("ab", "eidbaooo"));
//        System.out.println(ci.checkInclusion("ab", "eidboaoo"));
        System.out.println(ci.checkInclusion("adc", "dcda"));
    }
}
