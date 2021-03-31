package elvis.leetcode;

public class New21Game {
    public double new21Game(int N, int K, int W) {
        // p[i][j] 表示 投掷i次,点数小于j在总体中的可能性.
        double[][] p = new double[K + 1][K + 1];
        p[0][0] = 100.0;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= K; j++) {
                for (int k = 1; k <= W; k++) {
                    if (k > j)
                        break;
                    p[i][j] += p[i - 1][j - k] / W;
                }
            }
        }
        double sum = 0.0;
//        for(int )
        return sum;
    }

    public static void main(String[] args) {
        New21Game ng = new New21Game();
//        System.out.println(ng.new21Game(10, 1, 10));
        System.out.println(ng.new21Game(6, 1, 10));
    }
}
