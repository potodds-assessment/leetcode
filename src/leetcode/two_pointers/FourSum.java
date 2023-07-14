package leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FourSum {

    /////////////////////////////////////////////////////////////
    // 18. 4Sum - check to see if sum of 3=4 is equal to target value.
    // https://leetcode.com/problems/4sum/
    /////////////////////////////////////////////////////////////
    public void kSum(int k, int start, int target, List<List<Integer>> res, int[] nums, Stack<Integer> quad) {
        if (k != 2) {
            for(int i=start;i<nums.length-k+1;i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                quad.add(nums[i]);
                kSum(k-1, i+1, target - nums[i], res, nums, quad);
                quad.pop();
            }
            return;
        }

        int left = start;
        int right = nums.length-1;

        while (left < right) {
            if ((nums[left] + nums[right]) < target) {
                left++;
            } else if ((nums[left] + nums[right]) > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(Arrays.asList(nums[left], nums[right]));
                temp.addAll(quad);
                res.add(temp);
                left++;
                while(left < right && nums[left] == nums[left-1]) {
                    left++;
                }
            }
        }

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println("sorted" + Arrays.toString(nums));

        kSum(4,0,target,res, nums, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////
        // 18. 4Sum - check to see if sum of 3=4 is equal to target value.
        // https://leetcode.com/problems/4sum/
        /////////////////////////////////////////////////////////////
        FourSum app = new FourSum();
        System.out.println(app.fourSum(new int[]{1,0,-1,0,-2,2}, 0)); // result [[-2,-1,1,2][-2,0,0,2][-1,0,0,1]]
        System.out.println(app.fourSum(new int[]{2,2,2,2,2},8)); // [2,2,2,2]

    }
}
