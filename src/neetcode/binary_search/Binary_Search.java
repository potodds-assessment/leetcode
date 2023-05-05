package neetcode.binary_search;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */

public class Binary_Search {


    /*
    Runtime 0ms beats 100%
    Memory 43.1MB beats 77.3%

    Time: O(log n)
    Space: O(1)
    */
    public int search1(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        boolean run = true;

        do {
            if ((target >= nums[left]) && (target <= nums[right])) {
                int mid = ( left + right ) / 2;
                if ( target == nums[mid] ) {
                    return mid;
                } else if (target > nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
                if ( right-left == 1 && (nums[right] != target || nums[left] != target)) {
                    if ( nums[right] == target ) return right;
                    if ( nums[left] == target ) return left;
                    run = false;
                }
            } else
                run = false;
        } while(run);

        return -1;
    }

    /*
    Runtime 0ms beats 100%
    Memory 43.2MB beats 52.68%
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while ( left <= right ) {
            int mid  = left + ((right - left) / 2);
            if ( nums[mid] > target )
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        Binary_Search app = new Binary_Search();
        System.out.println(app.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(app.search(new int[]{2,5}, 5));
    }
}
