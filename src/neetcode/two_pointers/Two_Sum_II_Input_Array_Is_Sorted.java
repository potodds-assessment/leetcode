package neetcode.two_pointers;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */

import java.util.Arrays;

public class Two_Sum_II_Input_Array_Is_Sorted {

    /*
    Runtime: 443ms beats 5.1%
    Memory 45.7MB beats 9.5%

    time: O(n^2)
    space: O(1)
     */
    public int[] twoSum1(int[] numbers, int target) {
        for(int x = 0; x < numbers.length-1; x++) {
            for(int y = x+1; y < numbers.length; y++) {
                if (( numbers[x] + numbers[y] ) > target ) break;
                if ( (numbers[x] + numbers[y]) == target )
                    return new int[] {x+1, y+1};
            }
        }

        return null;
    }

    /*
    Runtime: 1ms beats 98.94%
    Memory: 45.6MB beats 23.85%

    Time: O(n)
    Space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        boolean done = false;
        while (!done) {
            if ((numbers[left] + numbers[right]) > target ) {
                right--;
            } else if ((numbers[left] + numbers[right]) < target ) {
                left++;
            } else {
                return new int[]{left+1, right+1};
            }
            }
        return null;
    }

    public static void main(String[] args) {
        Two_Sum_II_Input_Array_Is_Sorted app = new Two_Sum_II_Input_Array_Is_Sorted();
        System.out.println(Arrays.toString(app.twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(app.twoSum(new int[] {2,3,4}, 6)));
        System.out.println(Arrays.toString(app.twoSum(new int[] {-1,0}, -1)));
    }
}
