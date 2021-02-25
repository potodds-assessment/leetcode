package leetcode.linked_lists;

/*
A linked list of length n is given such that each node contains an additional random pointer, 
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
where each new node has its value set to the value of its corresponding original node. 
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the 
original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Example 4:
Input: head = []
Output: []
Explanation: The given linked list is empty (null pointer), so return null.

Constraints:
0 <= n <= 1000
-10000 <= Node.val <= 10000
Node.random is null or is pointing to some node in the linked list. 
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	Map<Node, Node> lookupMap = new HashMap<>();
//	Node[] lookupMap = new Node[20000];
	
    public Node copyRandomList(Node head) {

    	Node newList = null;
    	Node header = null;
    	Node ptr = head;
    	int index = 0;
    	do {
    		if ( newList == null ) {
    			newList = new Node(ptr.val);
    			if ( ptr.random != null ) {
    				newList.random = new Node(ptr.random.val);
    				lookupMap.put(newList.random.val, newList.random);
    			} else
    				newList.random = null;

    			
    			lookupMap.put(newList.val, newList);
    			header = newList;
    		} else {
				Node newNode = lookupMap.get(ptr.val);
				if ( newNode == null ) {
					newList.next = new Node(ptr.val);
					lookupMap.put(ptr.val, newList.next);
				} else
					newList.next = newNode;
    			newList = newList.next;
    			
    			if ( ptr.random != null ) {
    				Node randomNode = lookupMap.get(ptr.random.val);
    				if ( randomNode == null ) {
    					newList.random = new Node(ptr.random.val);
        				lookupMap.put(ptr.random.val, newList.random);
    				} else 
    					newList.random = randomNode;
    			} else
    				newList.random = null;
    		}

    		ptr = ptr.next;
    		index++;
    	} while( ptr != null );
    	
        return header;
    }

    public void run() {
//    	Node a = new Node(7);
//    	Node b = new Node(13);
//    	Node c = new Node(11);
//    	Node d = new Node(10);
//    	Node e = new Node(1);
//    	
//    	a.next = b;
//    	a.random = null;
//    	b.next = c;
//    	b.random = a;
//    	c.next = d;
//    	c.random = e;
//    	d.next = e;
//    	d.random = c;
//    	e.next = null;
//    	e.random = a;

    	Node a = new Node(3);
    	Node b = new Node(3);
    	Node c = new Node(3);
    	
    	a.next = b;
    	a.random = null;
    	b.next = c;
    	b.random = a;
    	c.next = null;
    	c.random = null;

    	Node ptr = copyRandomList(a);
    	do {
    		System.out.println("val[" + ptr.val + "], "
    				+ "ptr.random.val[" + ( ptr.random == null ? null : ptr.random.val ) + "], "
    				+ "ptr.next.val[" + ( ptr.next == null ? null : ptr.next.val ) + "]");
    		ptr = ptr.next;
    	} while( ptr != null );
    	
//    	val[7], ptr.random.val[null], ptr.next.val[13]
//		val[13], ptr.random.val[7], ptr.next.val[11]
//		val[11], ptr.random.val[1], ptr.next.val[10]
//		val[10], ptr.random.val[11], ptr.next.val[1]
//		val[1], ptr.random.val[7], ptr.next.val[null]    	
    }
    
    public static void main(String[] args) {
    	new CopyListWithRandomPointer().run();
	}

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }    
}
