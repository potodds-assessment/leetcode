package neetcode.linked_list;

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

    public ListNode incrList(ListNode node, int target) {
        if ( node == null )
            return null;

        ListNode tempNode = node;
        while (tempNode != null && tempNode.val < target) {
            tempNode = tempNode.next;
        }

        return tempNode;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if ( list1 == null && list2 == null ) return null;
        if ( list1 != null && list2 == null ) return list1;
        if ( list1 == null && list2 != null ) return list2;

        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode prevNode1 = null;
        ListNode prevNode2 = null;
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        while (ptr1 != null || ptr2 != null) {
            if ( ptr1.val <= ptr2.val ) {
                prevNode1 = ptr1;
                ptr1 = ptr1.next;
            } else {
                prevNode1.next = ptr2;

                prevNode2 = ptr2;
                ptr2 = ptr2.next;
            }
        }

//        printList(list1);
//        printList(list2);

        return head;
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

        app.printList(app.mergeTwoLists(list1, list4));
    }
}

