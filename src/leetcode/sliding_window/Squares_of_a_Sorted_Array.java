package leetcode.sliding_window;

import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
    /////////////////////////////////////////////////////////////
    // 977. Squares of a Sorted Array
    // https://leetcode.com/problems/squares-of-a-sorted-array/
    // Runtime: 1ms beats 100%
    // Memory: 45MB beats 34.28%
    // Time: O(n)
    // Space: O(n)
    /////////////////////////////////////////////////////////////
    public int[] sortedSquares(int[] nums) {
        if ( nums == null || nums.length == 0 )
            return nums;

        int[] res = new int[nums.length];

        int first_index = 0;
        int last_index = nums.length-1;
        int res_index = nums.length-1;

        while (first_index <= last_index) {
            int first_sq = nums[first_index] * nums[first_index];
            int last_sq = nums[last_index] * nums[last_index];

            if (first_sq < last_sq) {
                res[res_index] = last_sq;
                res_index--;
                last_index--;
            } else if (first_sq >= last_sq) {
                res[res_index] = first_sq;
                res_index--;
                first_index++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Squares_of_a_Sorted_Array app = new Squares_of_a_Sorted_Array();

        /////////////////////////////////////////////////////////////
        // 977. Squares of a Sorted Array
        /////////////////////////////////////////////////////////////
        System.out.println(Arrays.toString(app.sortedSquares(new int[]{-4,-1,0,3,10}))); // [0,1,9,16,100]
        System.out.println(Arrays.toString(app.sortedSquares(new int[]{-7,-3,2,3,11}))); // [4,9,9,49,121]
    }
}
