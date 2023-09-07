package leetcode.trees;

import leetcode.utilities.TreeNode;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

Constraints:
The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
*/

public class L124_Binary_Tree_Maximum_Path_Sum {

    int max = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        max = Math.max(max, left + right + node.val);

        return node.val + Math.max(left, right);
    }

    /*
     * Runtime: 0 ms, beats 100%
     * Memory: 43.90MB, beats 79.79%
     * 
     * time: O()
     * space: O()
     */
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    public static void main(String[] args) {

        TreeNode two = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode twenty = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode negTen = new TreeNode(-10, new TreeNode(9), twenty);

        L124_Binary_Tree_Maximum_Path_Sum app = new L124_Binary_Tree_Maximum_Path_Sum();
        int value = app.maxPathSum(two);
        System.out.println("calculated value:" + value + ", " + (value == 6));
        value = app.maxPathSum(negTen);
        System.out.println("calculated value:" + value + ", " + (value == 42));
    }
}