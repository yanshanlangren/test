package elvis.leetcode;

public class FindMaxForm_Other {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] max = new int[m + 1][n + 1];
        for (String str : strs) {
            int M = 0, N = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    M++;
                else
                    N++;
            }
            for (int i = m; i >= M; i--)
                for (int j = n; j >= N; j--)
                    max[i][j] = Math.max(max[i][j], max[i - M][j - N] + 1);
        }
        return max[m][n];
    }

    public static void main(String[] args) {
        FindMaxForm_Other fmf = new FindMaxForm_Other();
        System.out.println(fmf.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(fmf.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
//        System.out.println(fmf.findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3));
    }
}
