package leetcode.backtracking;

import java.util.*;

/////////////////////////////////////////////////////////////
// 78. Subsets
// https://leetcode.com/problems/subsets/
/////////////////////////////////////////////////////////////

/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
public class L78_Subsets {
    /////////////////////////////////////////////////////////////
    // 78. Subsets
    // https://leetcode.com/problems/subsets/
    // Runtime:
    // Memory:
    // Time:
    // Space:
    /////////////////////////////////////////////////////////////
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//        list.add(new ArrayList<>(tempList));
//        for(int i = start; i < nums.length; i++){
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    /////////////////////////////////////////////////////////////
    // 78. Subsets
    /////////////////////////////////////////////////////////////
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public void dfs(int i, int[] nums) {
        if ( i >= nums.length ) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i+1, nums);

        subset.remove(subset.size()-1);
        dfs(i+1, nums);

    }

    /*
        Runtime 1ms beats 74.47%
        Memory 41.7MB beats 99.60%
        Time: O(n * 2^n)
        Space: O(n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }
    public static void main(String[] args) {
        L78_Subsets s = new L78_Subsets();
        List<List<Integer>>  res = s.subsets( new int[]{1,2,3,4} );
        for(List<Integer> z : res) {
            System.out.println(z.toString());
        }
    }
}
