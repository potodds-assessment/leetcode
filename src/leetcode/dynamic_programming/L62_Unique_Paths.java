package leetcode.dynamic_programming;

import java.util.Arrays;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down 
or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the 
bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:
1 <= m, n <= 100
*/

public class L62_Unique_Paths {
/*
    Initial solution too slow. Timed out in LC.

    int rows_border = 0;
    int cols_border = 0;
    int max_counter = 0;

    public int uniquePaths(int m, int n) {
        max_counter = 0;
        rows_border = m-1;
        cols_border = n-1;
        dfs(0, 0);
        return max_counter;
    }

    private void dfs(int m, int n) {
        if ((m==rows_border) && (n==cols_border)) {
            max_counter++;
            return;
        }
        if (m < rows_border)
            dfs(m+1,n);

        if (n < cols_border)
            dfs(m,n+1);
    }
 */

    /*
    Runtime: 20ms, beats 8.84%
    Memory: 42.63MB, beats 5.61%

    time: O(m*n)
    space: O(n)
    */
    public int uniquePaths(int m, int n) {
        int row[] = new int[n];
        Arrays.fill(row, 1);

        for(int i=0; i<m-1;i++) {
            int newRow[] = new int[n];
            Arrays.fill(newRow, 1);
            System.out.println("row:" + Arrays.toString(row));

            for(int j=n-2; j>-1; j--) {
                newRow[j] = newRow[j+1] + row[j];
                System.out.println("newRow:" + Arrays.toString(newRow));
            }

            row = newRow;
        }

        return row[0];
    }


    public static void main(String[] args) {
        L62_Unique_Paths app = new L62_Unique_Paths();
        System.out.println(app.uniquePaths(7,7));// == 28);
        // System.out.println(app.uniquePaths(3,7));// == 28);
        // System.out.println(app.uniquePaths(3,2));// == 3);
    }
}