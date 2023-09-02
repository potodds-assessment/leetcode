package leetcode.trees;

/////////////////////////////////////////////////////////////
// 102. Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/
/////////////////////////////////////////////////////////////

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import leetcode.utilities.TreeNode;

public class L102_Binary_Tree_Level_Order_Traversal {

    /*
    Runtime: 1ms beats 99.33%
    Memory: 44.17mb beats 55.15%
    Time: O(n)
    Space: O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();  // important part to delimit each level
            List<Integer> list = new ArrayList<>();

            for(int i=1;i<=len;i++) {
                TreeNode curr = q.remove();
                list.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        L102_Binary_Tree_Level_Order_Traversal app = new L102_Binary_Tree_Level_Order_Traversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(app.levelOrder(root));

        root = new TreeNode(1);
        System.out.println(app.levelOrder(root));

        root = null;
        System.out.println(app.levelOrder(root));
    }
}

