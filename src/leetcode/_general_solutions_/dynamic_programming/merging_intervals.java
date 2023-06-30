package leetcode._general_solutions_.dynamic_programming;

import java.util.Arrays;

public class merging_intervals {

    /////////////////////////////////////////////////////////////
    // Merging Intervals
    /////////////////////////////////////////////////////////////
    // Problem List: https://leetcode.com/list/55aj8s16
    /////////////////////////////////////////////////////////////
    // Statement: Given a set of numbers find an optimal solution for a problem considering the current number and
    // the best you can get from the left and right sides.
    // Approach: Find all optimal solutions for every interval and return the best possible answer.
    // Get the best from the left and right sides and add a solution for the current position.
    /////////////////////////////////////////////////////////////
    // General solution template
    ////////////////////////////
    // from i to j
    // dp[i][j] = dp[i][k] + result[k] + dp[k+1][j]
    /////////////////////////////////////////////////////////////
    // Top-Down (Recursive) solution template
    ////////////////////////////
    //    for (int k = i; k <= j; ++k) {
    //        result = max(result, topDown(nums, i, k-1) + result[k] + topDown(nums, k+1, j));
    //    }
    //    return memo[/*state parameters*/] = result;
    /////////////////////////////////////////////////////////////
    // Bottom-Up (Iterative) solution template
    ////////////////////////////
    //    for(int l = 1; l<n; l++) {
    //        for(int i = 0; i<n-l; i++) {
    //            int j = i+l;
    //            for(int k = i; k<j; k++) {
    //                dp[i][j] = max(dp[i][j], dp[i][k] + result[k] + dp[k+1][j]);
    //            }
    //        }
    //    }
    //     return dp[0][n-1];
    //
    //    for(int l = 1; l<n; l++) {
    //        for(int i = 0; i<n-l; i++) {
    //            int j = i+l;
    //            for(int k = i; k<j; k++) {
    //                dp[i][j] = max(dp[i][j], dp[i][k] + result[k] + dp[k+1][j]);
    //            }
    //        }
    //    }
    //    return dp[0][n-1]
    /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        merging_intervals app = new merging_intervals();
    }
}
