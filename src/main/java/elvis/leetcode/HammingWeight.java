package elvis.leetcode;

public class HammingWeight {
    public int hammingWeight(int n) {
        int c = n - 1, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (c & 1);
            c >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight h = new HammingWeight();
        System.out.println(h.hammingWeight(-2147483637));
        System.out.println(h.hammingWeight(-3));
    }
}
