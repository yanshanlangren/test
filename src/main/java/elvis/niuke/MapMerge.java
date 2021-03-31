package elvis.niuke;

import java.util.*;

public class MapMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> m = new HashMap<>();
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt(), v = sc.nextInt();
            if (m.containsKey(k)) {
                m.put(k, m.get(k) + v);
            } else {
                s.add(k);
                m.put(k, v);
            }
        }
        while (!s.isEmpty()) {
            int i = s.pollFirst();
            System.out.println(i + " " + m.get(i));
        }
    }
}
