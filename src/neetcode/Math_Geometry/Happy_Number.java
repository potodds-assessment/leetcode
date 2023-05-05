package neetcode.Math_Geometry;

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false

Constraints:
1 <= n <= 231 - 1
 */

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

    /*
    Runtime 3ms beats 8.79%
    Memory 41.6% beats 5.15%
    Time: O(n + k)
    Space: O(n)
     */
    public boolean isHappy1(int n) {
        Set<Integer> s = new HashSet<>();

        while (true) {
            char[] intString = Integer.toString(n).toCharArray();
            int sum = 0;
            for (char c : intString) {
                sum += Math.pow(Integer.parseInt(Character.toString(c)),2);
            }

            if (s.contains(sum))
                return false;
            else
                s.add(sum);

            if (sum == 1)
                return true;

            n = sum;
        }
    }

    /*
    Optimized digit calculation using MOD and DIV.

    Runtime 1ms beats 90.95%
    Memory 40.1MB beats 32.66%
     */
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        while (true) {
            int sum = 0;

            while ( n != 0 ) {
                int digit = n % 10;
                digit *= digit;
                sum += digit;
                n /= 10;
            }

            if (s.contains(sum))
                return false;
            else
                s.add(sum);

            if (sum == 1)
                return true;

            n = sum;
        }
    }

    public static void main(String[] args) {
        Happy_Number app = new Happy_Number();
        System.out.println(app.isHappy(19));
        System.out.println(app.isHappy(2));
        System.out.println(app.isHappy(7));
    }
}
