package elvis.niuke;


import java.util.Scanner;

public class ActivityArrangement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i][1]);
        }
        int[] best = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int start = a[i][0], end = a[i][1];
            if (best[end] < best[start] + 1)
                for (int j = end; j <= max; j++)
                    best[j] = best[start] + 1;
        }
        System.out.println(best[max]);
    }
}
