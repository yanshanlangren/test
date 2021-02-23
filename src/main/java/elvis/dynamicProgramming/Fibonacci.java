package elvis.dynamicProgramming;

public class Fibonacci {
    public int fibonacci_recursion(int n) {
        return n < 2 ? n : fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }

    public int fibonacci_dynamicProgram(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 2)
                cache[i] = i;
            else
                cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        long t0 = System.currentTimeMillis();
        System.out.println(f.fibonacci_recursion(40));
//        System.out.println(f.fibonacci_dynamicProgram(40));
        System.out.println(System.currentTimeMillis() - t0 + "ms");
    }
}
