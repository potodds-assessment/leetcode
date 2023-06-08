package neetcode._1_D_dynamic_programming;

import java.util.Arrays;

public class House_Robber_II {

    public int rob1(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int rob1 = 0, rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    /*

     */
    public int robHelper(int[] nums) {
        System.out.println(Arrays.toString(nums));

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=1; i<nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        return dp[nums.length];
    }


    /*
    Runtime 0ms beats 100%
    Memory 40.4MB beats 20.25%
    Time: O(n)
    Space: O(n)
     */
    public int rob(int[] nums) {
        int value1 = robHelper(Arrays.copyOfRange(nums, 1, nums.length));
        int value2 = robHelper(Arrays.copyOfRange(nums, 0, nums.length-1));
        return Math.max(nums[0], Math.max(value1, value2));
    }

    public static void main(String[] args) {
        House_Robber_II app = new House_Robber_II();
//        System.out.println(app.rob(new int[]{1,2,3,1}));
//        System.out.println(app.rob(new int[]{2,7,9,3,1}));
//        System.out.println(app.rob(new int[]{2,1,1,2}));
        System.out.println(app.rob(new int[]{1,2,1,1}));
    }
}
