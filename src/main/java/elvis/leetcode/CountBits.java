package elvis.leetcode;


public class CountBits {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 0; i <= num; i++)
            count[i] = count[i >> 1] + (i & 1);
        return count;
    }

    public static void main(String[] args) {
        CountBits cb = new CountBits();
        int[] res = cb.countBits(5);
        for (int a : res)
            System.out.println(a);
    }
}
