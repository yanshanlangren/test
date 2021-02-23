package elvis.leetcode;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String x_str = String.valueOf(x);
        char[] x_ch = x_str.toCharArray();
        for (int i = 0; i < x_ch.length / 2 + 1; i++) {
            if (x_ch[i] != x_ch[x_ch.length - 1 - i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome(10));
//        System.out.println();
    }
}
