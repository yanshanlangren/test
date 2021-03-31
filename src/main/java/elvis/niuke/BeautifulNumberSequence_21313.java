package elvis.niuke;

import java.util.Scanner;

public class BeautifulNumberSequence_21313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int total = nums[0], decrease = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                System.out.println(0);
                return;
            }
            if (nums[i] == nums[i - 1]) {
                decrease = 0;
                dp[i] = dp[i - 1];
                total += nums[i];
            }
            if (nums[i] < nums[i - 1] && nums[i] >= 0) {
                decrease++;
                dp[i] = dp[i - 1];
                total += nums[i];
            }
            if (nums[i] == -1) {
                if (decrease == 1) {
                    dp[i] = dp[i - 1];
                    total += nums[i];
                    decrease = 0;
                } else {
                    int ave_former = total / i;
                    int cur_max = ave_former;
//                    dp[i] =
                }
            }
        }
    }
}
