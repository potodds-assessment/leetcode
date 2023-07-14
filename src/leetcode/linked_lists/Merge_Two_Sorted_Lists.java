package leetcode.linked_lists;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

public class Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while ( list1 != null && list2 != null ) {
            if ( list1.val < list2.val ) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if ( list1 != null )
            tail.next = list1;
        else if ( list2 != null )
            tail.next = list2;

        return dummy.next;
    }

    public void printList(ListNode node) {
        while ( node != null ) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists app = new Merge_Two_Sorted_Lists();
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(7);
        ListNode list3 = new ListNode(9);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        ListNode list7 = new ListNode(8);
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;

//        app.printList(list1);
//        app.printList(list4);
//        System.out.println("==");
        app.printList(app.mergeTwoLists(list1, list4));
    }
}

