package leetcode.linked_lists;

/////////////////////////////////////////////////////////////
// 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/
/////////////////////////////////////////////////////////////
// First attempt: reuse merge 2 sorted lists
/////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class L23_Merge_k_Sorted_Lists {

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


    /*
    Runtime: 105ms beats 18.80%
    Memory: 43.32mb beats 73.55%
    Time: O(k * n)
    Space: O(1)
    Comment: Brute force
     */
    public ListNode mergeKListsSlow(ListNode[] lists) {
        if ( lists == null || lists.length == 0 )
            return new ListNode();

        if ( lists.length == 1 )
            return lists[0];

        ListNode res = lists[0];
        for(int i=1;i<lists.length;i++) {
            res = mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    /*
    Runtime: 3ms beats 83.3%
    Memory: 43.79mb beats 33.26%
    Time: O(log k * n)
    Space: O(1)
    Comment: mergesort method is faster
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0 )
            return null;

        List<ListNode> listsL = Arrays.asList(lists);

        while(listsL.size() > 1) {
            List<ListNode> mergedList = new ArrayList<>();
            for(int i=0; i<listsL.size(); i++, i++) {
                ListNode l1 = listsL.get(i);
                ListNode l2 = null;

                if (i+1 < listsL.size())
                    l2 = listsL.get(i+1);

                mergedList.add(this.mergeTwoLists(l1, l2));
            }
            listsL = mergedList;
        }

        return listsL.get(0);
    }


    public void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        L23_Merge_k_Sorted_Lists app = new L23_Merge_k_Sorted_Lists();

        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        app.printNode(app.mergeKLists(new ListNode[]{node, node2, node3}));
    }
}
