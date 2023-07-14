package leetcode.arrays_strings;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that
they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    /*
    time: O(n^2)
    space: O(1)
     */
    public int[] twoSum1(int[] nums, int target) {

        for(int x=0; x<nums.length-1; x++) {
            for(int y=x+1; y<nums.length; y++) {
                if (nums[x] + nums[y] == target) {
                    return new int[]{x, y};
                }
            }
        }

        return null;
    }

    /*
    time: O(n)
    space: O(n)

    Using HashMap to hold value (key) and index (value).  Single pass through array, checking difference of target value and
    current array value.  Then storing array value if it doesn't match.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            Integer offset = m.get(diff);
            if ( offset == null ) {
                m.put(nums[i], i);
            } else {
                return new int[] {i, offset};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Two_Sum app = new Two_Sum();
        System.out.println(Arrays.toString(app.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(app.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(app.twoSum(new int[]{3,3}, 6)));
    }
}
