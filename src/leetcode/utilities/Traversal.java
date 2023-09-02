package leetcode.utilities;

public class Traversal {


    public void preorder_dfs(TreeNode curr) {
        if ( curr == null )
            return;

        System.out.print(curr.val + " ");
        preorder_dfs(curr.left);
        preorder_dfs(curr.right);
    }


    public static void main(String[] args) {
        Traversal app = new Traversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        app.preorder_dfs(root);
        System.out.println();
    }
}
