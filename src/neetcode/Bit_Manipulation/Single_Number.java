package neetcode.Bit_Manipulation;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */

public class Single_Number {

    /*
    XOR all values will leave the non-duplicate single number

    Runtime 1ms beats 100%
    Memory 42.5MB beats 83.72%
     */

    public int singleNumber(int[] nums) {
        int finalValue = 0;

        for (int c : nums) {
            finalValue ^= c;
        }

        return finalValue;
    }

    public static void main(String[] args) {
        Single_Number app = new Single_Number();
        System.out.println(app.singleNumber(new int[]{2,2,1}));
        System.out.println(app.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(app.singleNumber(new int[]{1}));
    }
}