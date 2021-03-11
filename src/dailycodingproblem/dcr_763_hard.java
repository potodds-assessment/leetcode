package dailycodingproblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Completed: 2/14/2021
 */

/*
This problem was asked by Google.
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. 
You can simply print them out as you compute them.
 
https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
Best solution uses Deque. 
 */
public class dcr_763_hard {
	
	/*
	 * First attempt: efficient solution but doesn't fully work  
	 * Pointer to largest and 2nd largest values in last k number of items in array.
	 * As it iterates to k+1 item, remove starting index in k view.
	 * 
	 * Problem: as it iterates through a large array with large k size, the largest item in kth array may
	 * have been the 3rd, 4th, etc largest item
	 * 
	 * Ex,  {20 ,14, 12, 7, 1, 2} with k=4.   Correct answer is 20,14,12.  the last item 12, was the 3rd largest item
	 * in the first k=0 array.
	 */
	public void maxValueInSubArray(int[] array, int subSize) {
		int arrayLength = array.length <= subSize ? subSize : array.length;
		int newSubSize = subSize > array.length ? array.length : subSize;
		
		int largestIndex = 0;
		boolean largestValid = false;
		int secondLargestIndex = 0;
		boolean secondLargestValid = false;

		for(int i=0; i<arrayLength; i++) {
			if ( !largestValid && !secondLargestValid ) {
				largestIndex = i;
				largestValid = true;
			} else if ( largestValid && !secondLargestValid ) {
				if ( array[i] > array[largestIndex] )
					largestIndex = i;
				else {
					secondLargestIndex = i;
					secondLargestValid = true;
				}
			} else if ( !largestValid && secondLargestValid ) {
				if ( array[i] > array[secondLargestIndex] ) {
					largestIndex = i;
					largestValid = true;
				} else {
					largestIndex = secondLargestIndex;
					largestValid = true;

					secondLargestIndex = i;
				}
			} else if ( largestValid && secondLargestValid ) {
				if ( array[i] > array[largestIndex] )
					largestIndex = i;
				else if ( array[i] > array[secondLargestIndex]) {
					secondLargestIndex = i;
				}
			}			

			if (i >= newSubSize-1) {
				System.out.println(array[largestIndex] + " ");
				
				int offset =  i - ( newSubSize - 1 );
				if ( largestIndex == offset ) {
					largestIndex = secondLargestIndex;
					secondLargestIndex = i;
				} else if ( secondLargestIndex == offset ) {
					secondLargestIndex = i;
				}
			}
		}
	}

	private Integer largestValue(List<Integer> list) {
		Integer maxValue = Integer.MIN_VALUE;
		for(Integer i : list) {
			if ( i > maxValue )
				maxValue = i;
		}
		return maxValue;
	}
	
	/*
	 * Second attempt: Working solution but slow
	 * basic list to hold k items.
	 * Problem: repeated search to find largest item in list 
	 */
	public void maxValueInSubArray2(int[] array, int subSize) {
		List<Integer> list = new ArrayList<>();
		int newSubSize = subSize <= array.length  ? subSize-1 : array.length-1; 
		
		for(int i=0; i<array.length; i++) {
			list.add( array[i] );
			
			if ( i >= newSubSize ) {
				System.out.print( largestValue( list ) + " ");
				list.remove( 0 );
			}
		}
		System.out.println();
	}
	
	/*
	 * Best solutions
	 * O(n) time, O(k) space
	 * 
	 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
	 */
	void printMax(int arr[], int n, int k) {
        Deque<Integer> Qi = new LinkedList<Integer>();
 
        int i;
        for (i = 0; i < k; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); 
 
            Qi.addLast(i);
        }
 
        for (; i < n; ++i) {
            System.out.print(arr[Qi.peek()] + " ");
 
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();
 
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
 
            Qi.addLast(i);
        }
 
        System.out.print(arr[Qi.peek()]);
    }	
	
	public static void main(String[] args) {
//		new dcr_763_hard().maxValueInSubArray2(new int[] {20 ,14, 12, 7, 1, 2}, 1);
//		new dcr_763_hard().maxValueInSubArray2(new int[] {20 ,14, 12, 7, 1, 2}, 2);
//		new dcr_763_hard().maxValueInSubArray2(new int[] {20 ,14, 12, 7, 1, 2}, 3);
//		new dcr_763_hard().maxValueInSubArray2(new int[] {20 ,14, 12, 7, 1, 2}, 4);
//		new dcr_763_hard().maxValueInSubArray2(new int[] {20 ,14, 12, 7, 1, 2}, 5);
//		new dcr_763_hard().maxValueInSubArray2(new int[] {20 ,14, 12, 7, 1, 2}, 4);
		
        int arr[] = { 14 ,20, 12, 7, 1, 2 };
        int k = 4;
        new dcr_763_hard().printMax(arr, arr.length, k);		
	}
	
}

