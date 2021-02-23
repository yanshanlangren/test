package elvis.leetcode;

import scala.xml.Null;

import java.util.ArrayList;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int len = target / 2 + 1;
        int[] cache = new int[len];
        for (int i = 0; i < len; i++) {
            cache[i] = i + 1;
        }
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 1; i <= len; i++) {
            for (int j = i; j < len && cache[j] < target; j++) {
                cache[j] = cache[j] + j - i + 1;
                if (cache[j] == target) {
                    int[] result = new int[i + 1];
                    for (int k = j - i; k <= j; k++)
                        result[k - j + i] = k + 1;
                    res.add(result);
                }
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        FindContinuousSequence fcs = new FindContinuousSequence();
        int[][] result = fcs.findContinuousSequence(15);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i].toString());
    }
}
