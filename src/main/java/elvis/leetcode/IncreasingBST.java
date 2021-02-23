package elvis.leetcode;

public class IncreasingBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode head, current;

    public TreeNode increasingBST(TreeNode root) {
        current = head = new TreeNode();
        search(root);
        return head.right;
    }

    public void search(TreeNode node) {
        if (node.left != null)
            search(node.left);

        //deal with node val
        current.right = new TreeNode(node.val);
        current = current.right;

        if (node.right != null)
            search(node.right);
    }

    public static void main(String[] args) {
        IncreasingBST ibst = new IncreasingBST();
        TreeNode n = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(
                        6,
                        null,
                        new TreeNode(
                                8,
                                new TreeNode(7),
                                new TreeNode(9)
                        )
                )
        ), n1;
        n1 = ibst.increasingBST(n);
        System.out.println(n1);
    }
}
