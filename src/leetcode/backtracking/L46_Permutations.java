package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/////////////////////////////////////////////////////////////
// 46. Permutations
// https://leetcode.com/problems/permutations/
/////////////////////////////////////////////////////////////
public class L46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack2(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack2(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {

    }
}
