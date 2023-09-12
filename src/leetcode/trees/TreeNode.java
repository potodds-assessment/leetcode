package leetcode.trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void print(TreeNode curr, TTYPE order) {
        if ( curr == null )
            return;

        if (order == TTYPE.PREORDER) System.out.print(curr.val + " ");
        print(curr.left, order);
        if (order == TTYPE.INORDER) System.out.print(curr.val + " ");
        print(curr.right, order);
        if (order == TTYPE.POSTORDER) System.out.print(curr.val + " ");
    }
}

enum TTYPE {
    PREORDER, INORDER, POSTORDER;
}