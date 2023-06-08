package neetcode._1_D_dynamic_programming;

import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class House_Robber {


    public int recurse(int[] nums) {
        if (nums.length == 0)
            return 0;

        if ( nums.length == 1 || nums.length == 2)
            return nums[0];

//        int max = 0;
//        for(int i=2; i<nums.length; i++) {
//            int val = recurse(Arrays.copyOfRange(nums, i, nums.length));
//            if ( val > max )
//                max = val;
//        }

        return nums[0] + recurse(Arrays.copyOfRange(nums, 2, nums.length));
    }

//    public int rob1(int[] nums) {
//
//        int maxValue = 0;
//
//        for(int i=0; i<nums.length; i++) {
//            int tempMaxValue = recurse(Arrays.copyOfRange(nums, i, nums.length));
////            System.out.println(tempMaxValue + ":" + maxValue);
//            if ( tempMaxValue > maxValue )
//                maxValue = tempMaxValue;
//        }
//
//        return maxValue;
//    }

    /*
    Runtime 0ms beats 100%
    Memory 40.7MB beats 9.19%
    Time: O(n)
    Space: O(1)
     */
    public int rob1(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    /*
    Runtime 0ms beats 100%
    Memory 40.1MB beats 51.69%
    Time: O(n)
    Space: O(n)
     */
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=1; i<nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }

    public static void main(String[] args) {
        House_Robber app = new House_Robber();
        System.out.println(app.rob(new int[]{1,2,3,1}));
        System.out.println(app.rob(new int[]{2,7,9,3,1}));
        System.out.println(app.rob(new int[]{2,1,1,2}));
        System.out.println(app.rob(new int[]{2,3,2}));
    }
}
