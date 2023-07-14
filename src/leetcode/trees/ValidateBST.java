package leetcode.trees;

/////////////////////////////////////////////////////////////
// 98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/
/////////////////////////////////////////////////////////////

/*
Completed: 2/16/2021
1) beats 100% performance
2) beats 89.69% for memory usage 
 */

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false

Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */

public class ValidateBST {

	private boolean isValidBoundary(Integer value, Integer min, Integer max) {
		boolean result = false;
		result = min==null ? true : value > min;
		result = result && ( max==null ? true : value < max );
		return result;
	}
	
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
    	if ( root == null )
    		return true;
    	
    	if (!(
    			( root.left == null || ( root.left.val < root.val && isValidBoundary(root.left.val, min, max) ) ) && 
    			( root.right == null || ( root.val < root.right.val && isValidBoundary(root.right.val, min, max) ) )
    		))
    		return false;
    	
    	return isValidBST(root.left, min, root.val ) && 
    			isValidBST(root.right, root.val, max ); 
    }

	public boolean isValidBST(TreeNode root) {
		if ( root == null ) 
			return true;
		return isValidBST(root, null, null);
    }
    
    public void run() {
    	TreeNode l = new TreeNode(3);
    	TreeNode r = new TreeNode(7);
    	TreeNode right = new TreeNode(6, l, r);
		TreeNode left = new TreeNode(4);
		TreeNode root = new TreeNode(5, left, right);    	
		System.out.println("Expecting false.  Actual value: " + isValidBST(root));
    	
    	l = new TreeNode(3);
    	r = new TreeNode(6);
    	right = new TreeNode(4, l, r);
		left = new TreeNode(1);
		root = new TreeNode(5, left, right);
		System.out.println("Expecting false.  Actual value: " + isValidBST(root));
    
    	right = new TreeNode(3);
		left = new TreeNode(1);
		root = new TreeNode(2, left, right);
		System.out.println("Expecting true.  Actual value: " + isValidBST(root));

    	l = new TreeNode(4);
    	r = new TreeNode(6);
    	right = new TreeNode(5, l, r);
    	l = new TreeNode(0);
    	r = new TreeNode(2);
		left = new TreeNode(1, l, r);
		root = new TreeNode(3, left, right);
		System.out.println("Expecting true.  Actual value: " + isValidBST(root));
		
		right = new TreeNode(2147483647);
		root = new TreeNode(-2147483648, null, right);
		System.out.println("Expecting true.  Actual value: " + isValidBST(root));
    }
	
	public static void main(String[] args) {		
		new ValidateBST().run();
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
