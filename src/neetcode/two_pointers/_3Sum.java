package neetcode.two_pointers;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

import java.util.*;

public class _3Sum {

    /*
    brute force method O(n^3) is very slow
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if ( nums == null || nums.length == 0 )
            return null;

        List<List<Integer>> existing = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int a=0; a<nums.length-2; a++) {
            for(int b=a+1; b<nums.length-1; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    if (nums[a] + nums[b] + nums[c] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);

                        Collections.sort(list);
                        if (!existing.contains(list)) {
                            existing.add(list);
                            ans.add(list);
                        }
                    }
                }
            }
        }

        return ans;
    }

    /*
    Runtime 37ms beats 86.7%
    Memory 51.1MB beats 5.83%
    Time: O(n^2) -- 2 nested loops
    Space: O(n) -- sorting could use O(n) space otherwise it's O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if ((i > 0) && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length - 1;
            while  (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum > 0)
                    right -= 1;
                else if (threeSum < 0)
                    left += 1;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    while (nums[left] == nums[left -1] && left < right) {
                        left += 1;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _3Sum app = new _3Sum();
        List<List<Integer>> ans = app.threeSum(new int[]{-1,0,1,2,-1,-4});
        if ( ans != null )
            System.out.println(Arrays.deepToString(ans.toArray()));
        ans = app.threeSum(new int[]{0,1,1});
        if ( ans != null )
            System.out.println(Arrays.deepToString(ans.toArray()));
        ans = app.threeSum(new int[]{0,0,0});
        if ( ans != null )
            System.out.println(Arrays.deepToString(ans.toArray()));

    }
}
