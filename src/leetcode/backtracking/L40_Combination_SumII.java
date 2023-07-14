package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/////////////////////////////////////////////////////////////
// 40. Combination Sum II
// https://leetcode.com/problems/combination-sum-ii/
/////////////////////////////////////////////////////////////

public class L40_Combination_SumII {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack5(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack5(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack5(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {

    }
}
