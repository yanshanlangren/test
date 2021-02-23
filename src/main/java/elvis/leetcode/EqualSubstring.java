package elvis.leetcode;

public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] s_arr = s.toCharArray(), t_arr = t.toCharArray();
        //init window
        int sum = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            int diff = Math.abs(s_arr[i] - t_arr[i]);
            if (sum + diff > maxCost)
                break;
            sum += diff;
        }
        int left = 0, right = i, maxLength = i;
        while (right < s.length()) {
            sum += Math.abs(s_arr[right] - t_arr[right]);
            right++;
            if (sum > maxCost) {
                sum -= Math.abs(s_arr[left] - t_arr[left]);
                left++;
            } else if (right - left > maxLength) {
                maxLength = right - left;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        EqualSubstring es = new EqualSubstring();
        System.out.println(es.equalSubstring("abcd", "bcdf", 3));
        System.out.println(es.equalSubstring("abcd", "cdef", 3));
        System.out.println(es.equalSubstring("abcd", "acde", 0));
        System.out.println(es.equalSubstring("krrgw", "zjxss", 19));
        System.out.println(es.equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }
}
