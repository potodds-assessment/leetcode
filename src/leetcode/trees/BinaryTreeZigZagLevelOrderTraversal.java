package leetcode.trees;

/////////////////////////////////////////////////////////////
// 103. Binary Tree Zigzag Level Order Traversal
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
/////////////////////////////////////////////////////////////

/*
Completed: 2/26/2021
1) beats 100.00% performance
2) beats 96.30% for memory usage 
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
(i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100 
 */
public class BinaryTreeZigZagLevelOrderTraversal {

	Queue<TreeNode> zigQ = new ArrayDeque<>();
	Queue<TreeNode> zagQ = new ArrayDeque<>();
	
	private void printNode(TreeNode node) {
		if ( node == null )
			return;

		zigQ.add( node );

		boolean nextLevel = false;
		Queue<TreeNode> tmpProcessingQ = zigQ;
		Queue<TreeNode> tmpAddQ = zagQ;

		while ( !tmpProcessingQ.isEmpty() ) {
			TreeNode currentNode = tmpProcessingQ.poll();
			System.out.print(currentNode.val + " ");
			
			if ( nextLevel ) {
				if ( currentNode.left != null )
					tmpAddQ.add(currentNode.left);
				if ( currentNode.right != null )
					tmpAddQ.add(currentNode.right);
			} else {
				if ( currentNode.right != null )
					tmpAddQ.add(currentNode.right);
				if ( currentNode.left != null )
					tmpAddQ.add(currentNode.left);
			}
			
			if ( tmpProcessingQ.isEmpty() ) {
				nextLevel = !nextLevel;
				tmpAddQ = tmpProcessingQ;
				tmpProcessingQ = ( tmpProcessingQ == zagQ ? zigQ : zagQ );
			}
		}
		System.out.println();
	}

	private void printList(List<List<Integer>> result) {
    	for(List<Integer> list : result) {
    		System.out.println(list.toString());
    	}
    }
    
    private TreeNode constructTestNode1() {
    	TreeNode root = new TreeNode(3);
    	TreeNode currentPtr = root;
    	
    	currentPtr.left = new TreeNode(9);    	
    	currentPtr.right = new TreeNode(20);
    	
    	currentPtr = currentPtr.left;
    	currentPtr.left = new TreeNode(1);
    	currentPtr.right = new TreeNode(2);
    	
    	currentPtr = currentPtr.right;
    	currentPtr.left = new TreeNode(15);
    	currentPtr.right = new TreeNode(7);
    	
    	return root;
    }
    
    private TreeNode constructTestNode2() {
    	TreeNode root = new TreeNode(1);
    	TreeNode currentPtr = root;
    	
    	currentPtr.right = new TreeNode(2);
    	return root;
    }    

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> answer = new ArrayList<>(); 
    	if ( root == null ) {
    	} else if (root.left == null && root.right == null) {
    		List<Integer> list = new ArrayList<>();
    		list.add( root.val );
    		answer.add(list);
    	} else {
    		zigQ.add( root );

    		boolean nextLevel = false;
    		Queue<TreeNode> tmpProcessingQ = zigQ;
    		Queue<TreeNode> tmpAddQ = zagQ;

    		List<Integer> list = new ArrayList<>();
    		while ( !tmpProcessingQ.isEmpty() ) {
    			TreeNode currentNode = tmpProcessingQ.poll();
    			
    			if ( currentNode.left != null ) tmpAddQ.add(currentNode.left);
    			if ( currentNode.right != null ) tmpAddQ.add(currentNode.right);    			
    			list.add(currentNode.val);    			
    			
    			if ( tmpProcessingQ.isEmpty() ) {
    				if ( nextLevel ) {
    					Collections.reverse(list);
    					answer.add( list );
    				} else
    					answer.add(list);
    				list = new ArrayList<>();
    				nextLevel = !nextLevel;
    				tmpAddQ = tmpProcessingQ;
    				tmpProcessingQ = ( tmpProcessingQ == zagQ ? zigQ : zagQ );
    			}
    		}
    	}
    	return answer;
    }

    public void run() {
//    	printList(zigzagLevelOrder(new TreeNode(1)));
//    	printList(zigzagLevelOrder(null));
    	TreeNode node = constructTestNode2();
//    	printNode(node);
    	printList(zigzagLevelOrder(node));
	}

	public static void main(String[] args) {
		new BinaryTreeZigZagLevelOrderTraversal().run();
	}

	 public class TreeNode {
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
