package elvis.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> l;
    int cur;

    public BSTIterator(TreeNode root) {
        l = new ArrayList<>();
        cur = 0;
        iterate(root);
    }

    public void iterate(TreeNode node) {
        if (node == null)
            return;
        iterate(node.left);
        l.add(node.val);
        iterate(node.right);
    }

    public int next() {
        return l.get(cur++);
    }

    public boolean hasNext() {
        return cur < l.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3, null, null), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
