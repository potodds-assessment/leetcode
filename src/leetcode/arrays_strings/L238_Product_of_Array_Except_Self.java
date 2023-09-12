package leetcode.arrays_strings;

import java.util.Arrays;

/////////////////////////////////////////////////////////////
// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/
/////////////////////////////////////////////////////////////

/*
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

public class L238_Product_of_Array_Except_Self {
    public int[] productExceptSelf1(int[] nums) {

        int[] answers = new int[nums.length];
        Arrays.fill(answers, 1);

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<answers.length; j++) {
                if (i != j)
                    answers[j] = answers[j] * nums[i];
            }
        }

        return answers;   
    }

    /*
    Runtime: 2ms, beats 58.94%
    Memory: 52.93MB, beats 51.14%

    time: O(n)
    space: O(1)
     */
    public int[] productExceptSelf(int[] nums) {

        int[] answers = new int[nums.length];
        Arrays.fill(answers, 1);

        int prefix = 1;
        for(int i=0; i<nums.length; i++) {
            answers[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1; i>=0; i--) {
            answers[i] *= postfix;
            postfix *= nums[i];
        }

        return answers;   
    }


    public static void main(String[] args) {
        L238_Product_of_Array_Except_Self app = new L238_Product_of_Array_Except_Self();
        System.out.println(Arrays.toString(app.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(app.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}