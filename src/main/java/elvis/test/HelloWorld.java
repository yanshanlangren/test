package elvis.test;

import java.math.BigInteger;

public class HelloWorld {
    public String pow(String a, String b) {
        if (b.equals("0"))
            return "1";
        return times(pow(a, String.valueOf(Integer.parseInt(b) - 1)), a);
    }

    public String times(String a, String b) {
        int[] res = new int[a.length() + b.length() + 1];
        char[] a_char = a.toCharArray();
        char[] b_char = b.toCharArray();
        for (int i = b_char.length - 1; i >= 0; i--)
            for (int j = a_char.length - 1; j >= 0; j--)
                res[b_char.length - 1 - i + a_char.length - 1 - j] += (b_char[i] - '0') * (a_char[j] - '0');
        int c = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] += c;
            c = res[i] / 10;
            res[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = res.length - 1;
        while (res[i] == 0)
            i--;
        for (; i >= 0; i--)
            sb.append(res[i]);
        return sb.toString();
    }

    public static BigInteger bigIntegerPow(BigInteger a, BigInteger b) {
        return a.multiply(a).multiply(bigIntegerPow(a, b.subtract(BigInteger.valueOf(1))));
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        System.out.println(hw.pow("2", "1000"));
    }
}
