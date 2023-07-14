package leetcode.linked_lists;

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */

public class Reorder_List {

    /*
    Runtime 1ms beats 100%
    Memory 45.9MB beats 16.96%

    Time: O(n)
    Space: O(1)
     */

    public void reorderList(ListNode head) {
        if ( head == null || head.next == null )
            return;

        ListNode slow = head;
        ListNode fast = head.next;

        // find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode second =  slow.next;
        slow.next = null;
        ListNode prev = null;
        while ( second != null ) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // merge two halves
        ListNode first = head;
        second = prev;
        while ( second != null ) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }

    public void printList(ListNode node) {
        while ( node != null ) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Reorder_List app = new Reorder_List();
        app.reorderList( a );
        app.printList( a );
    }
}
