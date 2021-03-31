package elvis.niuke;

import java.util.Scanner;

public class FindCitiesNearestDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] m = new int[N][N];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            m[from][to] = 1 << i;
            m[to][from] = 1 << i;
        }
        int[] minDis = new int[N];
        boolean[] visited = new boolean[N];
        visited[0] = true;
        minDis[0] = 0;
        for (int i = 1; i < N; i++) {
            minDis[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        for (int i = 0; i < N; i++)
            if (m[0][i] != 0)
                minDis[i] = m[0][i];
        while (true) {
            int min = Integer.MAX_VALUE, city = -1;
            for (int i = 1; i < N; i++) {
                if (!visited[i] && minDis[i] < min) {
                    min = minDis[i];
                    city = i;
                }
            }
            if (city == -1)
                break;
            //search city
            visited[city] = true;
            for (int i = 0; i < N; i++) {
                if (m[city][i] != 0)
                    minDis[i] = Math.min(minDis[i], minDis[city] + m[city][i]);
            }
        }
        for (int i = 1; i < N; i++) {
            System.out.println(minDis[i] == Integer.MAX_VALUE ? -1 : minDis[i]);
        }
    }
}
