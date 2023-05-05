package neetcode.linked_list;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 */

public class Linked_List_Cycle {

    /*
    Runtime 0ms beats 100%
    Memory 43.7MB beats 62.96%

    Time: O(n)
    Space: O(1)
     */
    public boolean hasCycle1(ListNode head) {

        if ( head == null )
            return false;

        ListNode first = head;

        int current_pos = 0;
        while ( head != null ) {
            ListNode tempNode = head;

            head = head.next;
            if ( head == first)
                return true;

            tempNode.next = first;

            current_pos++;
        }

//        System.out.println("pos:" + current_pos);

        return false;
    }

    /*
    Classic tortoise (slow) and rabbit (fast) solution
    Time: O(n)
    Space: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if ( head == null || head.next == null)
            return false;

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while ( slowPtr != null && fastPtr != null ) {
            if ( slowPtr == fastPtr )
                return true;

            slowPtr = slowPtr.next;
            if ( fastPtr == null || fastPtr.next == null )
                return false;
            else
                fastPtr = fastPtr.next.next;
        }

        return false;
    }

        public void printList(ListNode head) {
        while ( head != null ) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(0);
        ListNode head3 = new ListNode(4);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head1;

        Linked_List_Cycle app = new Linked_List_Cycle();
//        app.printList( head );
        System.out.println(app.hasCycle( head ));
    }
}
