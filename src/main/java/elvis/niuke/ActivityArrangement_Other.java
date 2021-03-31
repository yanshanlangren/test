package elvis.niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ActivityArrangement_Other {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] arr = new int[T][2];
        for (int i = 0; i < T; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();

        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int end = 0;
        for (int i = 0; i < T; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                res++;
            }
        }
        System.out.println(res);
    }
}
