package leetcode._general_solutions_;

import java.util.*;

public class two_pointers {

    /////////////////////////////////////////////////////////////
    // Solving Two Pointers - check link for cleaer illustrations
    // https://leetcode.com/discuss/study-guide/1688903/Solved-all-two-pointers-problems-in-100-days
    /////////////////////////////////////////////////////////////
    // Running from both ends of an array
    // The first type of problems are, having two pointers at left and right end of array, then moving them to the
    // center while processing something with them.
    /////////////////////////////////////////////////////////////
    // 2 Sum problem
    //    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    //    15. https://leetcode.com/problems/3sum/
    //    18. https://leetcode.com/problems/4sum/
    //    https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
    //    https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    //    https://leetcode.com/problems/sum-of-square-numbers/
    //    https://leetcode.com/problems/boats-to-save-people/
    //    https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
    //    923. https://leetcode.com/problems/3sum-with-multiplicity/
    // Trapping Water
    //    https://leetcode.com/problems/trapping-rain-water/
    //    https://leetcode.com/problems/container-with-most-water/
    // Next Permutation
    //    https://leetcode.com/problems/next-permutation/
    //    https://leetcode.com/problems/next-greater-element-iii/
    //    https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
    // Reversing / Swapping
    //    https://leetcode.com/problems/valid-palindrome/
    //    https://leetcode.com/problems/reverse-string/
    //    https://leetcode.com/problems/reverse-vowels-of-a-string/
    //    https://leetcode.com/problems/valid-palindrome-ii/
    //    https://leetcode.com/problems/reverse-only-letters/
    //    https://leetcode.com/problems/remove-element/
    //    https://leetcode.com/problems/sort-colors/
    //    https://leetcode.com/problems/flipping-an-image/
    //    https://leetcode.com/problems/squares-of-a-sorted-array/
    //    https://leetcode.com/problems/sort-array-by-parity/
    //    https://leetcode.com/problems/sort-array-by-parity-ii/
    //    https://leetcode.com/problems/pancake-sorting/
    //    https://leetcode.com/problems/reverse-prefix-of-word/
    //    https://leetcode.com/problems/reverse-string-ii/
    //    https://leetcode.com/problems/reverse-words-in-a-string/
    //    https://leetcode.com/problems/reverse-words-in-a-string-iii/
    // Others
    //    https://leetcode.com/problems/bag-of-tokens/
    //    https://leetcode.com/problems/di-string-match/
    //    https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
    //    https://leetcode.com/problems/sentence-similarity-iii/
    //    https://leetcode.com/problems/find-k-closest-elements/
    //    https://leetcode.com/problems/shortest-distance-to-a-character/
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    // 15. 3Sum - check to see if sum of 3 is equal to zero.
    // https://leetcode.com/problems/3sum/
    /////////////////////////////////////////////////////////////
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();  //hold results
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++) {
            if ((i>0 && nums[i] == nums[i-1])) continue; //skip if neighbors are same

            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum > 0)
                    right -= 1; //array is sorted so move right pointer left for a lower sum.
                else if (threeSum < 0)
                    left += 1; //array is sorted so move left pointer right for a higher sum.
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    while (nums[left] == nums[left-1] && left<right) { //skip if neighbors are same
                        left += 1;
                    }
                }
            }
        }

        return res;
    }

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

    /////////////////////////////////////////////////////////////
    // 923. 3Sum With Multiplicity
    // https://leetcode.com/problems/3sum-with-multiplicity/
    /////////////////////////////////////////////////////////////
    public int threeSumMulti(int[] arr, int target) {

        //////////////////////////////////////////////////
        // brute force method
        // Time: O(n^2)
        // Space: O(1)
        //////////////////////////////////////////////////
//        int mod = 1_000_000_007;
//        long result = 0;
//        for(int i=0;i<arr.length;i++) {
//            int[] count = new int[101];
//            for(int j=i+1;j<arr.length;j++) {
//                int k = target-arr[i]-arr[j];
//                if (k>=0 && k<=100 && count[k]>0) {
//                    result+=count[k];
//                    result%=mod;
//                }
//                count[arr[j]]++;
//            }
//        }
//        return (int)result;

        //////////////////////////////////////////////////
        // formula method (i==j==k, i==j!=k, i<j<k)
        // Time: O(n + 100*100)
        // Space: O(100) = O(1)
        //////////////////////////////////////////////////
        int mod = 1_000_000_007;
        long result = 0;
        long[] c = new long[101];
        for(int i:arr) c[i]++;

        for(int i=0;i<=100;i++) {
            for(int j=i;j<=100;j++) {
                int k = target - i - j;
                if (k<0 || k>100) continue;
                if (i==j && j==k)
                    result += (c[i] * (c[i]-1) * (c[i]-2) /6);
                else if (i==j && j!=k)
                    result += ((c[i] * (c[i]-1) /2) * c[k]);
                else if (i<j && j<k)
                    result += (c[i] * c[j] * c[k]);

            }
        }
        return (int)(result%mod);
    }

    /////////////////////////////////////////////////////////////
    // Slow & Fast Pointers
    // Next type is using two pointers with different speed of movement. Typically they starts from the left end,
    // then the first pointer advances fast and give some feedback to the slow pointer and do some calculation.
    /////////////////////////////////////////////////////////////
    // Linked List Operations
    //    https://leetcode.com/problems/linked-list-cycle/
    //    https://leetcode.com/problems/linked-list-cycle-ii/
    //    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    //    https://leetcode.com/problems/rotate-list/
    //    https://leetcode.com/problems/reorder-list/
    //    https://leetcode.com/problems/palindrome-linked-list/
    //
    // Cyclic Detection
    //    https://leetcode.com/problems/find-the-duplicate-number/
    //    https://leetcode.com/problems/circular-array-loop/
    //
    // Sliding Window/Caterpillar Method
    //    image
    //    https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
    //    https://leetcode.com/problems/find-k-th-smallest-pair-distance/
    //    https://leetcode.com/problems/moving-stones-until-consecutive-ii/
    //    https://leetcode.com/problems/count-pairs-of-nodes/
    //    https://leetcode.com/problems/count-binary-substrings/
    //    https://leetcode.com/problems/k-diff-pairs-in-an-array/
    //
    // Rotation
    //    https://leetcode.com/problems/rotating-the-box/
    //    https://leetcode.com/problems/rotate-array/
    //
    // String
    //    https://leetcode.com/problems/string-compression/
    //    https://leetcode.com/problems/last-substring-in-lexicographical-order/
    //
    // Remove Duplicate
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    //    https://leetcode.com/problems/duplicate-zeros/
    //
    // Others
    //    https://leetcode.com/problems/statistics-from-a-large-sample/
    //    https://leetcode.com/problems/partition-labels/
    //    https://leetcode.com/problems/magical-string/
    //    https://leetcode.com/problems/friends-of-appropriate-ages/
    //    https://leetcode.com/problems/longest-mountain-in-array/
    //    https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    // Running from beginning of 2 arrays / Merging 2 arrays
    // In this category, you will be given 2 arrays or lists, then have to process them with individual pointers.
    /////////////////////////////////////////////////////////////
    // Sorted arrays
    //    https://leetcode.com/problems/merge-sorted-array/
    //    https://leetcode.com/problems/heaters/
    //    https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
    //
    // Intersections/LCA like
    //    https://leetcode.com/problems/intersection-of-two-linked-lists/
    //    https://leetcode.com/problems/intersection-of-two-arrays/
    //    https://leetcode.com/problems/intersection-of-two-arrays-ii/
    //
    // SubString
    //    https://leetcode.com/problems/implement-strstr/
    //    https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    //    https://leetcode.com/problems/long-pressed-name/
    //    https://leetcode.com/problems/longest-uncommon-subsequence-ii/
    //    https://leetcode.com/problems/compare-version-numbers/
    //    https://leetcode.com/problems/camelcase-matching/
    //    https://leetcode.com/problems/expressive-words/
    //
    // Median Finder
    //    https://leetcode.com/problems/find-median-from-data-stream/
    //
    // Meet-in-the-middle / Binary Search
    //    https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
    //    https://leetcode.com/problems/closest-subsequence-sum/
    //    https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/
    //    https://leetcode.com/problems/3sum-closest/
    //    https://leetcode.com/problems/valid-triangle-number/
    //
    // Others
    //    https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
    //    https://leetcode.com/problems/most-profit-assigning-work/
    //    https://leetcode.com/problems/largest-merge-of-two-strings/
    //    https://leetcode.com/problems/swap-adjacent-in-lr-string/
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    // Split & Merge of an array / Divide & Conquer
    // The last one is similiar to previous category but there is one thing is added. First, you need to split the
    // given list into 2 separate lists and then do two pointers approach to merge or unify them. There aren't many tasks here.
    /////////////////////////////////////////////////////////////
    // Partition
    //    86 https://leetcode.com/problems/partition-list/
    //
    // Sorting
    //    148 https://leetcode.com/problems/sort-list/
    /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        two_pointers app = new two_pointers();

        /////////////////////////////////////////////////////////////
        // 15. 3Sum - check to see if sum of 3 is equal to zero.
        // https://leetcode.com/problems/3sum/
        /////////////////////////////////////////////////////////////
//        System.out.println(app.threeSum(new int[]{-1,0,1,2,-1,-4})); // result [[-1,-1,2][-1,0,1]]
//        System.out.println(app.threeSum(new int[]{0,1,1})); // []
//        System.out.println(app.threeSum(new int[]{0,0,0})); // [0,0,0]

        /////////////////////////////////////////////////////////////
        // 18. 4Sum - check to see if sum of 3=4 is equal to target value.
        // https://leetcode.com/problems/4sum/
        /////////////////////////////////////////////////////////////
//        System.out.println(app.fourSum(new int[]{1,0,-1,0,-2,2}, 0)); // result [[-2,-1,1,2][-2,0,0,2][-1,0,0,1]]
//        System.out.println(app.fourSum(new int[]{2,2,2,2,2},8)); // [2,2,2,2]

        /////////////////////////////////////////////////////////////
        // 923. 3Sum With Multiplicity
        // https://leetcode.com/problems/3sum-with-multiplicity/
        /////////////////////////////////////////////////////////////
        System.out.println(app.threeSumMulti(new int[]{1,1,2,2,2,2},5)); // 12

    }
}
