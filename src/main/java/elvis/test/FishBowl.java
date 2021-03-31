package elvis.test;

import java.util.Scanner;

public class FishBowl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int c1 = sc.nextInt(), n1 = sc.nextInt(), c2 = sc.nextInt(), n2 = sc.nextInt();

        int min = Integer.MAX_VALUE, min1 = 0, min2 = 0;
        for (int i = 0; i * n1 <= n; i++) {
            for (int j = 0; j * n2 + i * n1 <= n; j++) {
                if (j * n2 + i * n1 == n && min > i * c1 + j * c2) {
                    min = i * c1 + j * c2;
                    min1 = i;
                    min2 = j;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println("failed");
        } else {
            System.out.println(min1 + " " + min2);
        }

    }

}
