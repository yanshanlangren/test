package elvis.test;

import java.util.Stack;

public class MonoToneStack {
    public int findMaxMonoTone(int[] f) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for (int i = 0; i < f.length; i++) {
            while (!s.isEmpty() && f[i] > s.peek()) {
                s.pop();
            }
            s.push(f[i]);
            max = Math.max(max, s.size());
        }
        return max;
    }

    public static void main(String[] args) {
        MonoToneStack mts = new MonoToneStack();
        System.out.println(mts.findMaxMonoTone(new int[]{5, 3, 4, 2, 1}));
    }
}
