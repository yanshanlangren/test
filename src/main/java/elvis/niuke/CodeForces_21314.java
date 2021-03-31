package elvis.niuke;

import java.util.Scanner;

public class CodeForces_21314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), T = sc.nextInt();
        int[] maxPoints = new int[N], pointsPerMinutes = new int[N], requiredTime = new int[N];
        for (int i = 0; i < N; i++)
            maxPoints[i] = sc.nextInt();
        for (int i = 0; i < N; i++)
            pointsPerMinutes[i] = sc.nextInt();
        for (int i = 0; i < N; i++)
            requiredTime[i] = sc.nextInt();

        int[][] dp = new int[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if(requiredTime[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
//                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-])
                }
            }
        }
    }

    public static int getScore(int t, int maxPoint, int pointPerminit) {
        return maxPoint - t * pointPerminit;
    }
}
