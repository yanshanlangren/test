package elvis.niuke;

import java.util.Scanner;

public class ReverseRedundentInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res = 0;
        int[] c = new int[10];
        for (; n > 0; ) {
            if (c[n % 10] == 0) {
                res *= 10;
                res += n % 10;
                c[n % 10]++;
            }
            n /= 10;
        }
        System.out.println(res);
    }
}
