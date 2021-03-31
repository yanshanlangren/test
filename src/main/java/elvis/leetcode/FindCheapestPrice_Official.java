package elvis.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindCheapestPrice_Official {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //航班图
        int[][] graph = new int[n][n];
        for (int[] flight : flights)
            graph[flight[0]][flight[1]] = flight[2];
        Map<Integer, Integer> best = new HashMap();
        //优先队列, 堆顶是花费最小的航班
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, src});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int cost = info[0], k = info[1], place = info[2];
            if (k > K + 1 || cost > best.getOrDefault(k * 1000 + place, Integer.MAX_VALUE))
                continue;
            if (place == dst)
                return cost;

            for (int nei = 0; nei < n; ++nei)
                if (graph[place][nei] > 0) {
                    int newcost = cost + graph[place][nei];
                    if (newcost < best.getOrDefault((k + 1) * 1000 + nei, Integer.MAX_VALUE)) {
                        pq.offer(new int[]{newcost, k + 1, nei});
                        best.put((k + 1) * 1000 + nei, newcost);
                    }
                }
        }

        return -1;
    }
    public static void main(String[] args) {
        FindCheapestPrice_Official fcp = new FindCheapestPrice_Official();
        System.out.println(fcp.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
//        System.out.println(fcp.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
//        System.out.println(fcp.findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
//        System.out.println(fcp.findCheapestPrice(10, new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7));
    }
}
