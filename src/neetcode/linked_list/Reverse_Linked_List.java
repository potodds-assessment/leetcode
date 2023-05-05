package neetcode.linked_list;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Reverse_Linked_List {

    /*
    Runtime 0ms beats 100%
    Memory 42.9MB beats 10.57%

    Time: O(n)
    Space: O(1)
     */

    public ListNode reverseList1(ListNode head) {
        if ( head == null || head.next == null )
            return head;

        ListNode firstPtr = head;
        ListNode nextPtr = firstPtr.next;
        ListNode tempNode = firstPtr;

        while ( nextPtr != null ) {
            firstPtr.next = nextPtr.next;
            nextPtr.next = tempNode;

            tempNode = nextPtr;
            nextPtr = firstPtr.next;
        }

        return tempNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }

        return prev;
    }

    public ListNode reverseListRexursive(ListNode head) {

        if ( head == null )
            return head;

        ListNode newHead = head;
        if ( head.next != null ) {
            newHead = this.reverseListRexursive(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }

    public void printList(ListNode node) {
        while ( node != null ) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Reverse_Linked_List app = new Reverse_Linked_List();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
//        app.printList(node1);
        app.printList(app.reverseListRexursive( node1 ));
    }
}

