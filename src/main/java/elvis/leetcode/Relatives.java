package elvis.leetcode;

import java.util.*;

/**
 * 题目背景若某个家族人员过于庞大，要判断两个是否是亲戚，确实还很不容易，现在给出某个亲戚关系图，求任意给出的两个人是否具有亲戚关系。
 * 题目描述规定：x和y是亲戚，y和z是亲戚，那么x和z也是亲戚。如果x,y是亲戚，那么x的亲戚都是y的亲戚，y的亲戚也都是x的亲戚。
 * 输入格式第一行：三个整数n,m,p，（n<=5000,m<=5000,p<=5000），分别表示有n个人，m个亲戚关系，询问p对亲戚关系。
 * 以下m行：每行两个数Mi，Mj，1<=Mi，Mj<=N，表示Mi和Mj具有亲戚关系。
 * 接下来p行：每行两个数Pi，Pj，询问Pi和Pj是否具有亲戚关系。
 * 输出格式P行，每行一个’Yes’或’No’。
 * 表示第i个询问的答案为“具有”或“不具有”亲戚关系
 */

public class Relatives {
    //所有节点的父节点, 如fa[1]= 3 表示节点1的父节点是3
    int[] fa;

    /**
     * 初始化fa, 所有节点的父节点初始指向自己, 每次输入一个数组m[i], 合并m[i][0]和m[i][1]的子集
     * @param n 节点总数
     * @param m 关系, 二维数组, 第一个坐标表示数组数量, 第二个坐标表示两个子集关系, m[i][0]和m[i][1]是亲属关系
     */
    public Relatives(int n, int[][] m) {
        fa = new int[n];
        for (int i = 0; i < n; i++)
            fa[i] = i;
        for (int[] r : m)
            merge(r[0], r[1]);
    }

    /**
     * 找到x的父节点
     * 并压缩整个图, 使x的父节点指向, 子集的总父节点
     * @param x
     * @return
     */
    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    /**
     * 合并x, y两个子集, 使x子集的父节点指向y自己的总父节点
     * @param x
     * @param y
     */
    public void merge(int x, int y) {
        fa[find(x)] = find(y);
    }

    /**
     * 检测x, y是否为亲属, 判断两者的总父节点是否相同
     * @param x
     * @param y
     * @return
     */
    public boolean isRelative(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        Relatives re = new Relatives(4, new int[][]{{0, 2}, {1, 2}});
        System.out.println(re.isRelative(0, 1));
        System.out.println(re.isRelative(0, 2));
        System.out.println(re.isRelative(1, 3));
    }
}
