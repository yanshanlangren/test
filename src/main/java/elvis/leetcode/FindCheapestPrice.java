package elvis.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] best = new int[n];
        boolean[] visited = new boolean[n];
        int[] k = new int[n];
        int[][] graph = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        System.arraycopy(graph[src], 0, best, 0, n);
        for (int i = 0; i < n; i++) {
            best[i] = best[i] == 0 ? Integer.MAX_VALUE : best[i];
        }
        visited[src] = true;
        best[src] = 0;

        while (true) {
            //pick city to visit
            int city = -1, cmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && cmin > best[i]) {
                    cmin = graph[src][i];
                    city = i;
                }
            }
            if (city == -1)
                break;
            //visit city
            visited[city] = true;
            for (int i = 0; i < n; i++) {
                if (graph[city][i] != 0) {
                    if (graph[city][i] + best[city] < best[i] && k[city] + 1 <= K) {
                        best[i] = graph[city][i] + best[city];
                        k[i] = k[city] + 1;
                    }
                }
            }
        }
        if (k[dst] <= K)
            return best[dst] == Integer.MAX_VALUE ? -1 : best[dst];
        return -1;
    }

    public int findCheapestPrice_PriorityQueue(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights)
            graph[flight[0]][flight[1]] = flight[2];
        int[][] best = new int[K + 3][n];
        for (int i = 0; i < K + 3; i++)
            Arrays.fill(best[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cost = node[0], from = node[1], turn = node[2];
            if (turn > K + 1)
                continue;
            if (dst == from)
                return cost;
            for (int i = 0; i < n; i++)
                if (graph[from][i] > 0) {
                    int newcost = cost + graph[from][i];
                    if (newcost < best[turn + 1][i]) {
                        best[turn + 1][i] = newcost;
                        pq.offer(new int[]{newcost, i, turn + 1});
                    }
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindCheapestPrice fcp = new FindCheapestPrice();
//        System.out.println(fcp.findCheapestPrice_PriorityQueue(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
//        System.out.println(fcp.findCheapestPrice_PriorityQueue(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(fcp.findCheapestPrice_PriorityQueue(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1));
//        System.out.println(fcp.findCheapestPrice_PriorityQueue(10, new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7));
    }
}
