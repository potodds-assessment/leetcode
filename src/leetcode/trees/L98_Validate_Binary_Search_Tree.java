package leetcode.trees;

import leetcode.utilities.TreeNode;

/////////////////////////////////////////////////////////////
// 98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/
/////////////////////////////////////////////////////////////
public class L98_Validate_Binary_Search_Tree {

    /*
    Runtime: -ms beats 100%
    Memory: 43.74mb beats 84.71%
    Time: O(n)
    Space: O(1)
     */
    public boolean isValid(TreeNode root, double valid_low,  double valid_high) {
        if (root == null)
            return true;

        if (!(root.val > valid_low && root.val < valid_high))
            return false;

        double left = root.left == null ? Double.NEGATIVE_INFINITY : root.left.val;
        double right = root.right == null ? Double.POSITIVE_INFINITY : root.right.val;

        if (!(root.val > left && root.val < right))
            return false;


        return isValid(root.left, valid_low, root.val) && isValid(root.right, root.val, valid_high);
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        return isValid(root.left, Double.NEGATIVE_INFINITY, root.val) && isValid(root.right, root.val, Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args) {
        L98_Validate_Binary_Search_Tree app = new L98_Validate_Binary_Search_Tree();

        TreeNode n = new TreeNode(-2147483648);
        n.right = new TreeNode(2147483647);

        System.out.println(app.isValidBST(n) == true);


        n = new TreeNode(2);
        n.left = new TreeNode(1);
        n.right = new TreeNode(3);

        System.out.println(app.isValidBST(n) == true);

        n = new TreeNode(5);
        n.left = new TreeNode(1);
        n.right = new TreeNode(4);

        n.right.left = new TreeNode(3);
        n.right.right = new TreeNode(6);

        System.out.println(app.isValidBST(n) == false);
    }
}
