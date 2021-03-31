package elvis.niuke;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long i = 2, max = (long) Math.sqrt(num);
        while (num > 1 && i <= max) {
            if (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            } else {
                i++;
            }
        }
        if (num > 1)
            System.out.print(num);
    }

    public static int GCD(int a, int b) {
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }
}
