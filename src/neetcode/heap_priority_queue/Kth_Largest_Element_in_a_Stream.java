package neetcode.heap_priority_queue;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

Constraints:
1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */

import java.util.*;

public class Kth_Largest_Element_in_a_Stream {

    List<Integer> l = new ArrayList<>();
    int kth_index;

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        /*
        kth_index = k;
        for(int c : nums) {
            l.add(c);
        }
        Collections.sort(l);
         */

        kth_index = k;

        if ( nums.length > 0 ) {

            for (int c : nums) {
                pq.add(c);
            }

            for (int i = 0; i < nums.length - k; i++) {
                pq.poll();
            }

        }
    }

    /*
    Using ArrayList and Collections.sort()
    Runtime 1769ms beats 5.2%
    Memory 50.2MB beats 5.3%;
     */

    /*
    Using PriorityQueue
    Runtime 17ms beats 45.4%
    Memory 46.7MB beats 65.64%;
     */

    public int add1(int val) {
        l.add(val);
        Collections.sort(l);

        return l.get( l.size() - kth_index );
    }

    public int add(int val) {
        pq.add(val);

        if ( pq.size() > kth_index )
            pq.poll();

        return pq.peek();
    }

    public static void main(String[] args) {
        Kth_Largest_Element_in_a_Stream app = new Kth_Largest_Element_in_a_Stream(3, new int[]{4,5,8,2});
        System.out.println(app.add(3));
        System.out.println(app.add(5));
        System.out.println(app.add(10));
        System.out.println(app.add(9));
        System.out.println(app.add(4));
    }
}
