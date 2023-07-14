package leetcode.math_geometry;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not
contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 */

import java.util.Arrays;

public class Plus_One {

    /*
    Runtime 0ms beats 100%
    Memory 41.6MB beats 9.71%

    Time: O(n)
    Space: O(n)
     */
    public int[] plusOne1(int[] digits) {
        int[] result = new int[digits.length + 1];

        boolean carry = false;
        boolean first = true;

        for(int i=digits.length-1; i>=0; i--) {
            int num = first ? digits[i] + 1 : digits[i];
            first = false;

            num = carry ? num + 1 : num;

            if ( num == 10 ) {
                result[i+1] = 0;
                carry = true;
            } else {
                result[i+1] = num;
                carry = false;
            }
        }

        if ( carry )
            result[0] = 1;
        else {
            for(int i=0; i<digits.length; i++) {
                digits[i] = result[i+1];
            }
            return digits;
        }

        return result;
    }

    /*
    Runtime 0ms beats 100%
    Memory 41.1MB beats 47.3%

    Time: O(n)
    Space: O(1)
     */
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        boolean first = true;

        for(int i=digits.length-1; i>=0; i--) {
            int num = first ? digits[i] + 1 : digits[i];
            first = false;

            num = carry ? num + 1 : num;

            if ( num == 10 ) {
                digits[i] = 0;
                carry = true;
            } else {
                digits[i] = num;
                carry = false;
            }
        }

        if ( carry ) {
            int[] temp = new int[digits.length + 1];
            for(int i=0; i<digits.length;i++) {
                temp[i+1] =  digits[i];
            }
            temp[0] = 1;
            return temp;
        }

        return digits;
    }

    public static void main(String[] args) {
        Plus_One app = new Plus_One();
        System.out.println(Arrays.toString(app.plusOne(new int[] {9, 8})));
    }
}
