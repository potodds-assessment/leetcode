package leetcode.trees;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.utilities.TreeNode;

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class Invert_Binary_Tree {

    Queue<TreeNode> q = new ArrayDeque<>();


    /*
    Runtime 0ms beats 100%
    Memory 40.4MB beats 36.77%

    Time: O(n)
    Space: O(n)
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if ( temp != null ) {
                TreeNode tmpPtr = temp.left;
                temp.left = temp.right;
                temp.right = tmpPtr;

                if ( temp.left != null ) q.add( temp.left );
                if ( temp.right != null ) q.add( temp.right );
            }
        }

        return root;
    }

    /*
    recursive solution.  queue space usage is replaced by stack space usage
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmpPtr = root.left;
        root.left = root.right;
        root.right = tmpPtr;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if ( temp != null ) {
                System.out.println(temp.val);
                if ( temp.left != null ) q.add( temp.left );
                if ( temp.right != null ) q.add( temp.right );
            }
        }
    }

    public static void main(String[] argss) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        b.left = d;
        b.right = e;
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(9);
        c.left = f;
        c.right = g;

        Invert_Binary_Tree app = new Invert_Binary_Tree();
        app.invertTree( a );
        app.printTree(a);
    }
}
