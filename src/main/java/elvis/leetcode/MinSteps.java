package elvis.leetcode;

public class MinSteps {
    public int minSteps(int n) {
        int step = 0, i = 2;
        while (n > 1) {
            if (n % i == 0) {
                n /= i;
                step += i;
            } else {
                i++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        MinSteps ms = new MinSteps();
        System.out.println(ms.minSteps(10));
    }
}
