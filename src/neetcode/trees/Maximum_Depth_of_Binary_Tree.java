package neetcode.trees;

import neetcode.linked_list.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
public class Maximum_Depth_of_Binary_Tree {

    int current_depth = 0;
    int max_depth = 0;


    /*
    Runtime 2ms beats 11.16%
    Memory 42.5MB beats 37.86%
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> a = new Stack<>();
        Stack<TreeNode> b = new Stack<>();
        Stack<TreeNode> tempNode;
        int maxDepth = 0;

        a.push(root);

        do {
            maxDepth++;
            while (!a.isEmpty()) {
                TreeNode z = a.pop();
                if (z.left != null) b.push(z.left);
                if (z.right != null) b.push(z.right);
            }

            tempNode = a;
            a = b;
            b = tempNode;
        } while(!a.isEmpty() || !b.isEmpty());


        return maxDepth;
    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new ArrayDeque<>();
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

    public void printTree2(TreeNode root) {
        if (root == null)
            return;

//        current_depth++;
//        if ( current_depth > max_depth )
//            max_depth = current_depth;
//        System.out.println(root.val + ", current depth: " + current_depth + ", max depth:" + max_depth);

        printTree2(root.left);
        printTree2(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        Maximum_Depth_of_Binary_Tree app = new Maximum_Depth_of_Binary_Tree();
//        app.printTree2(a);
        System.out.println(app.maxDepth( a ));
//        app.printTree2(a);

    }
}
