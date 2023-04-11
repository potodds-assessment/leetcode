package neetcode.arrays_hashing;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contains_Duplicate {

// too slow
    public boolean containsDuplicate_TooSlow(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            for(int y=i+1; y<nums.length; y++) {
                if (nums[i] == nums[y]) return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dupList = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if (dupList.contains(nums[i]))
                return true;
            else
                dupList.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Contains_Duplicate().containsDuplicate( new int[] {1,2,3,1} ));
    }
}
