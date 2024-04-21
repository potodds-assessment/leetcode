package leetcode.arrays_strings;

import java.util.Arrays;

/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */

public class L416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for(int c : nums) {
            total += c;
        }

        if ((total % 2) != 0) 
            return false;

        int half = total/2;
        int count = 0;
        for(int t : nums) {
            count += t;
            if (count == half) return true;
            if (count > half) return false;
        }
        return false;
    }    

    public static void main(String[] args) {
        L416_Partition_Equal_Subset_Sum app = new L416_Partition_Equal_Subset_Sum();
        System.out.println(app.canPartition(new int[]{1,5,11,5}));
        System.out.println(app.canPartition(new int[]{1,2,3,5}));
        System.out.println(app.canPartition(new int[]{1,2,1,2}));
    }
}
