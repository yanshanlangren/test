package elvis.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class RemoveStones {
    public int removeStones(int[][] stones) {
        //如果A和B在同一条直线/横线上, 则A与B直接关联, 如果A通过n(n>1)直接关联的棋子关联到B, 则A间接关联B
        //把相互关联的棋子定义成块, 找出当前石头的块数
        //棋子数
        int len = stones.length;
//        class Stone {
//            int x;
//            int y;
//
//            public Stone(int x, int y) {
//                this.x = x;
//                this.y = y;
//            }
//        }
//        Stone[] a = new Stone[len];
//        for (int i = 0; i < len; i++)
//            a[i] = new Stone(stones[i][0], stones[i][1]);
        ArrayList list = (ArrayList) Arrays.asList(stones);


        //棋子搜索状态 false 未搜索  true 搜索过
        boolean[] status = new boolean[len];

        // 棋盘x轴下标
        int x0 = 10000;
        // 棋盘y轴下标
        int y0 = 10000;
        // 棋盘x轴上标
        int x1 = 0;
        // 棋盘y轴上标
        int y1 = 0;
        for (int i = 0; i < len; i++) {
            status[i] = false;
            if (stones[i][0] < x0)
                x0 = stones[i][0];
            if (stones[i][0] > x1)
                x1 = stones[i][0];
            if (stones[i][1] < y0)
                y0 = stones[i][1];
            if (stones[i][1] > y1)
                y1 = stones[i][1];
        }
        int[][] plate = new int[x1 - x0 + 1][y1 - y0 + 1];
        for (int[] stone : stones) {
            plate[stone[0] - x0][stone[1] - y0] = 1;
        }
        int block = 0;
        int used_stone = 0;
//        while (used_stone < len) {
//            for (int[] stone : stones) {
////                stones.
//            }
//        }

        return len - block;
    }

    public static void main(String[] args) {
        RemoveStones rs = new RemoveStones();
//        String[][] a = new String[][]{{"asda", "asda"}};
        rs.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}});
    }

}
