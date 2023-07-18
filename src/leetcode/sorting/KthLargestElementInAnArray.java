package leetcode.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Completed: 2/20/2021
1) beats 98.06% performance
2) beats 56.02% for memory usage 
 */

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 <= k <= array's length. 
 */
public class KthLargestElementInAnArray {

    public int findKthLargest2(int[] nums, int k) {    	
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }

    public int findKthLargest(int[] nums, int k) {    	
        if(nums == null || nums.length == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums)
        {
            pq.offer(num);
            System.out.print(pq.toString() + " - ");
            
            if(pq.size() > k)
                pq.poll();

            System.out.println(pq.toString());
        }
        
        return pq.peek();
    }

    public void run() {
    	System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    	System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

    public static void main(String[] args) {
    	new KthLargestElementInAnArray().run();
	}

}
