package leetcode.sort_search;

/*
Completed: 2/16/2021
1) beats 99.81% performance
2) beats 81.49% for memory usage 
 */

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
Follow up: The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000

Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000

Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if ( ( nums1 == null || nums1.length == 0 ) && ( nums2 == null || nums2.length == 0 ))
    		return 0.0;
 
    	int totalLength = ( nums1 == null ? 0 : nums1.length ) + ( nums2 == null ? 0 : nums2.length );
    	int medianIndex = totalLength / 2;

    	Integer arr1Index = 0;
    	Integer arr2Index = 0;
    	double currentValue = 0.0;
    	double priorValue = 0.0;

    	for(int i=0; i<medianIndex+1; i++) {
    		Integer curr1Value = ( nums1 != null && arr1Index<nums1.length ? nums1[arr1Index] : null ); 
    		Integer curr2Value = ( nums2 != null && arr2Index<nums2.length ? nums2[arr2Index] : null );
    		
    		if ( curr1Value == null ) {
    			priorValue = currentValue;
    			currentValue = curr2Value;
    			arr2Index++; 
    		} else if ( curr2Value == null ) {
    			priorValue = currentValue;
    			currentValue = curr1Value;
    			arr1Index++;
    		} else {
    			priorValue = currentValue;
    			if ( curr1Value > curr2Value ) {
    				currentValue = curr2Value;
        			arr2Index++; 
    			} else {
    				currentValue = curr1Value;
        			arr1Index++;
    			}    				
    		}
    	}
    	
    	return totalLength % 2 != 0 ? currentValue : (currentValue + priorValue) / 2;
    }
	
    public void run() {
    	System.out.println(findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
    	System.out.println(findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    	System.out.println(findMedianSortedArrays(new int[] {0,0}, new int[] {0,}));
    	System.out.println(findMedianSortedArrays(new int[] {}, new int[] {1}));
    	System.out.println(findMedianSortedArrays(new int[] {2}, new int[] {}));
    }
    
	public static void main(String[] args) {
		new MedianTwoSortedArrays().run();
	}

}

