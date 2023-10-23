package leetcode.trees;

import leetcode.utilities.TreeNode;

public class L543_Diameter_of_Binary_Tree {

    int diameter = 0;    
    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);

        if ((left + right) > diameter) {
            diameter = left + right;
        }

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root);
    }

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node = new TreeNode(1, node2, node3);

        L543_Diameter_of_Binary_Tree app = new L543_Diameter_of_Binary_Tree();
        System.out.println(app.diameterOfBinaryTree(node));

        node = new TreeNode(1, new TreeNode(2, null, null), null);
        System.out.println(app.diameterOfBinaryTree(node));
    }
}
