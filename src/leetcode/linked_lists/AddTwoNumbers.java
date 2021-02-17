package leetcode.linked_lists;

/*
Not Completed: 2/15/2021
1) beats performance
2) beats for memory usage 
 */

/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */
public class AddTwoNumbers {

	private int addTwoStrings(char n1, char n2, boolean remainder ) {
		int num1 = Integer.parseInt( Character.toString(n1) );
		int num2 = Integer.parseInt( Character.toString(n2) );		
		return remainder ? num1 + num2 + 1 : num1 + num2;
	}
		
	private String addTwoStrings(String n1, String n2) {
		int maxLength = n1.length() > n2.length() ? n1.length() : n2.length();
		int shortLength = n1.length() > n2.length() ? n2.length() : n1.length();
		
		StringBuffer sb = new StringBuffer();
		boolean remainder = false;
		boolean add_two_nums = true;
		for(int i=0;i<maxLength;i++) {
			add_two_nums = (i < shortLength);
			if ( add_two_nums ) {
				int sum = addTwoStrings(  n1.charAt(i), n2.charAt(i), remainder);
				if ( sum > 9 ) {
					remainder = true;
					sb.append( sum - 10 );
				} else {
					remainder = false;
					sb.append( sum );
				}
			} else {
				if ( n2.length() > n1.length() ) {
					int sum = addTwoStrings(  n2.charAt(i), '0', remainder);
					if ( sum > 9 ) {
						remainder = true;
						sb.append( sum - 10 );
					} else {
						remainder = false;
						sb.append( sum );
					}
				} else {
					int sum = addTwoStrings(  n1.charAt(i), '0', remainder);
					if ( sum > 9 ) {
						remainder = true;
						sb.append( sum - 10 );
					} else {
						remainder = false;
						sb.append( sum );
					}
				}
			}			
		}
		if ( remainder ) 
			sb.append('1');
		return sb.toString();
	}
	
	private String reverse(String number) {
    	StringBuffer str = new StringBuffer(number);
    	for(int i=0; i<str.length()/2; i++) {
    		char temp = str.charAt(i);
    		str.setCharAt(i, str.charAt(str.length()-i-1));
    		str.setCharAt(str.length()-i-1, temp);
    	}
    	return str.toString();
	}
	
	private long convert(ListNode node) {
    	ListNode tempPtr = node;
    	StringBuffer str = new StringBuffer();
    	do {
    		str.append( Integer.toString( tempPtr.val  ) );
    		tempPtr = tempPtr.next;
    	} while ( tempPtr != null );

		return Long.parseLong(reverse(str.toString()));
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	long number1 = convert(l1);
    	long number2 = convert(l2);
    	
    	long result = number1 + number2;
    	String number = reverse(Long.toString(result));

    	ListNode node = null;
    	ListNode header = null;
    	for(int i=0; i<number.length(); i++) {
    		if ( node == null )
    			node = header = new ListNode(Integer.parseInt(String.valueOf(number.charAt(i))));
    		else {
    			node.next = new ListNode(Integer.parseInt(String.valueOf(number.charAt(i))));
    			node = node.next;
    		}    		
    	}
    	
    	return header;
    }	
	
    public void run() {
//    	ListNode node = new ListNode(3);
//    	ListNode node2 = new ListNode(4, node);
//    	ListNode node3 = new ListNode(2, node2);
//
//    	ListNode node4 = new ListNode(4);
//    	ListNode node5 = new ListNode(6, node4);
//    	ListNode node6 = new ListNode(5, node5);

//    	ListNode node3 = new ListNode(9);
//
//    	ListNode node4 = new ListNode(9);
//    	ListNode nodea = new ListNode(9, node4);
//    	ListNode nodeb = new ListNode(9, nodea);
//    	ListNode nodec = new ListNode(9, nodeb);
//    	ListNode noded = new ListNode(9, nodec);
//    	ListNode nodee = new ListNode(9, noded);
//    	ListNode nodef = new ListNode(9, nodee);
//    	ListNode nodeg = new ListNode(9, nodef);
//    	ListNode nodeh = new ListNode(9, nodeg);
//    	ListNode nodei = new ListNode(1, nodeh);
//    	
//    	ListNode result = addTwoNumbers(node3, nodei);
//    	ListNode tempPtr = result;
//    	do {
//        	System.out.print(tempPtr.val);
//    		tempPtr = tempPtr.next;
//    	} while ( tempPtr != null );
//    	System.out.println();

    	System.out.println(addTwoStrings("564","1000000000000000000000000000001")); 
    }
    
    public static void main(String[] args) {
    	new AddTwoNumbers().run();
    }

    class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}	
}
