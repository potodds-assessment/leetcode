package dailycodingproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Completed: 
 */

/*
This problem was asked by Amazon.
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */

public class dcr_1536_medium {
	
    int maxSum = 0;

    public int recursive(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int val = arr[0] + recursive(Arrays.copyOfRange(arr, 1, arr.length));
        maxSum = Math.max(maxSum, val);
        maxSum = Math.max(maxSum, arr[0]);

        return val;
    }

    public int maxContiguousSum(int[] arr) {
        maxSum = 0;

        for(int i=0; i<arr.length; i++) {
           recursive(Arrays.copyOfRange(arr, i, arr.length));
        }

        return maxSum;
    }
	
	public static void main(String[] args) {
		dcr_1536_medium app = new dcr_1536_medium();
        System.out.println(app.maxContiguousSum(new int[]{34,-50,42,14,-5,86}));
        System.out.println(app.maxContiguousSum(new int[]{34, -1, 100, -50})); // wrong result 100 vs 133
    }
}
