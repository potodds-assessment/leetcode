package leetcode.trees;

import leetcode.utilities.TreeNode;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
*/

public class L235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    /*
     * Runtime: 5ms, beats 98.83%
     * Memory: 44.1MB, beats 46.35%
     * 
     * time: O(log n)
     * space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }    

    public static void main(String[] args) {
        L235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree app = new L235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4, three, five);

        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2, zero, four);

        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8, seven, nine);

        TreeNode root = new TreeNode(6, two, eight);

        int value = app.lowestCommonAncestor(root, two, eight).val;
        System.out.println("" + (value == 6) + ", value=" + value);
        value = app.lowestCommonAncestor(root, two, four).val;
        System.out.println("" + (value == 2) + ", value=" + value);
 
        TreeNode one = new TreeNode(1);
        root = new TreeNode(2, one, null);
        value = app.lowestCommonAncestor(root, root, one).val;
        System.out.println("" + (value == 2) + ", value=" + value);
        System.out.println("Hi");

    }
}