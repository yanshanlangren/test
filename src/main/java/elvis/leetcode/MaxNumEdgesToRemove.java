package elvis.leetcode;

public class MaxNumEdgesToRemove {

    //节点关系数组, dest[i] = j 表示i节点可以通往j, 当dest[i] = i时, 表示i节点是子集的头节点
    int[] destAlice;
    int[] destBob;

    //可以被移除的边
    int countToRemove;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //使用并查集方法计算
        //初始化dest数组, 让所有节点为孤岛, 即dest[i] = i
        destAlice = new int[n];
        destBob = new int[n];
        countToRemove = 0;
        for (int i = 0; i < n; i++) {
            destAlice[i] = i;
            destBob[i] = i;
        }

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean _alice = mergeAlice(edge[1] - 1, edge[2] - 1);
                if (mergeBob(edge[1] - 1, edge[2] - 1) && _alice)
                    countToRemove++;
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1 && mergeAlice(edge[1] - 1, edge[2] - 1))
                countToRemove++;
            if (edge[0] == 2 && mergeBob(edge[1] - 1, edge[2] - 1))
                countToRemove++;
        }

        //判断是否所有的节点对于Alice和Bob是可达的
        int headAlice = findHeadAlice(0);
        int headBob = findHeadBob(0);

        for (int i = 1; i < n; i++)
            if (findHeadAlice(i) != headAlice || findHeadBob(i) != headBob)
                return -1;
        return countToRemove;
    }

    /**
     * 找到i节点所属子集的头节点
     * 并压缩树
     *
     * @param i 要寻找的i的头子节点
     * @return 头结点
     */
    int findHeadAlice(int i) {
        return destAlice[i] == i ? i : (destAlice[i] = findHeadAlice(destAlice[i]));
    }

    int findHeadBob(int i) {
        return destBob[i] == i ? i : (destBob[i] = findHeadBob(destBob[i]));
    }

    /**
     * 合并i和j所属的子集, 将i的头结点指向j的头节点, 返回false
     * 如果i,j 本身属于相同子集, 则返回true
     *
     * @param i
     * @param j
     */
    boolean mergeAlice(int i, int j) {
        int _i = findHeadAlice(i);
        int _j = findHeadAlice(j);
        if (_i == _j)
            return true;
        destAlice[_i] = _j;
        return false;
    }

    boolean mergeBob(int i, int j) {
        int _i = findHeadBob(i);
        int _j = findHeadBob(j);
        if (_i == _j)
            return true;
        destBob[_i] = j;
        return false;
    }

    public static void main(String[] args) {
        MaxNumEdgesToRemove mnetr = new MaxNumEdgesToRemove();
        System.out.println(mnetr.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}));
        System.out.println(mnetr.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}));
        System.out.println(mnetr.maxNumEdgesToRemove(4, new int[][]{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}));
    }
}
