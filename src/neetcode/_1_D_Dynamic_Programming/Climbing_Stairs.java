package neetcode._1_D_Dynamic_Programming;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */

public class Climbing_Stairs {

    /*
    Solution: decision tree.  left and right nodes of 1 or 2 steps, culminating in end nodes equaling target steps.
    In addition,  redundant branches for n-1, n-2, n-3, etc steps.

    Runtime 0ms beats 100%
    Memory 39.8% beats 22.16%

    Time: O(n)
    Space: O(1)
     */

    public int climbStairs(int n) {

        int first = 1, second = 1;

        for(int i=0; i<n-1; i++) {
            int temp = first;
            first = first + second;
            second = temp;
        }

        return first;
    }

    public static void main(String[] args) {
        Climbing_Stairs app = new Climbing_Stairs();
        System.out.println(app.climbStairs( 2 ));
        System.out.println(app.climbStairs( 3 ));
        System.out.println(app.climbStairs( 5 ));
        System.out.println(app.climbStairs( 6 ));
        System.out.println(app.climbStairs( 7 ));
    }
}
