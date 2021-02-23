package elvis.leetcode;

public class Reverse {
    public int reverse(int x) {
        int flag = x < 0 ? 1 : 0;
        String str = String.valueOf(x);
        char[] arr = str.toCharArray();
        char[] reverse_arr = new char[arr.length - flag];
        for (int i = 0; i < arr.length - flag; i++)
            reverse_arr[i] = arr[arr.length - i - 1];
        String reverse_str = new String(reverse_arr);
        long ret = Long.parseLong(reverse_str);
        if (ret > Integer.MAX_VALUE) {
            return 0;
        } else {
            return flag == 1 ? 0 - Integer.parseInt(reverse_str) : Integer.parseInt(reverse_str);
        }
    }

    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(120));
    }
}
