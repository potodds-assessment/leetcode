package leetcode.dynamic_programming;

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class L53_Maximum_Subarray {

    /*
    Runtime: 1ms, beats 100%
    Memory: 57.69MB, beats 88.91%

    time: O()
    space: O()
    */
    public int maxSubArray(int[] nums) {

        int currMax = 0;
        int maxValue = nums[0];

        for(int currValue : nums) {
            currMax = Math.max(currMax + currValue, currValue);
            maxValue = Math.max(currMax, maxValue);
            System.out.println(currMax + ":" + maxValue);
        }

        return maxValue;
            
    }

    public static void main(String[] args) {
        L53_Maximum_Subarray app = new L53_Maximum_Subarray();
        System.out.println(app.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6);
        System.out.println(app.maxSubArray(new int[]{1}) == 1);
        System.out.println(app.maxSubArray(new int[]{5,4,-1,7,8}) == 23);
    }
}