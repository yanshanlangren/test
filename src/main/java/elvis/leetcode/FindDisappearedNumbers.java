package elvis.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        for (int i = 0; i < nums.length; i++)
            if (!set.contains(i + 1))
                list.add(i + 1);
        return list;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers fdn = new FindDisappearedNumbers();
//        List<Integer> list = fdn.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        List<Integer> list = fdn.findDisappearedNumbers(new int[]{1, 1});
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}
