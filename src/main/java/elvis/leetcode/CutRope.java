package elvis.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class CutRope {
    public int cuttingRope(int n) {
        BigInteger[] max = new BigInteger[n + 1];
        Arrays.fill(max, BigInteger.valueOf(1));
        max[0] = BigInteger.valueOf(0);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2 + 1; j++) {
                max[i] = max[i].max(max[j].max(BigInteger.valueOf(j)).multiply(max[i - j].max(BigInteger.valueOf(i - j))));
            }
        }
        return max[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        CutRope cr = new CutRope();
        System.out.println(cr.cuttingRope(2));
    }
}
