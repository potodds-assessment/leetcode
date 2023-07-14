package leetcode.dynamic_programming._other;

public class distinct_ways {

    /////////////////////////////////////////////////////////////
    // Distinct Ways
    /////////////////////////////////////////////////////////////
    // Problem List: https://leetcode.com/list/55ajm50i
    /////////////////////////////////////////////////////////////
    // Statement: Given a target find a number of distinct ways to reach the target.
    // Approach: Sum all possible ways to reach the current state.
    /////////////////////////////////////////////////////////////
    // General solution template
    ////////////////////////////
    // routes[i] = routes[i-1] + routes[i-2], ... , + routes[i-k]
    /////////////////////////////////////////////////////////////
    // Top-Down (Recursive) solution template
    ////////////////////////////
    //    for (int j = 0; j < ways.size(); ++j) {
    //        result += topDown(target - ways[j]);
    //    }
    //    return memo[/*state parameters*/] = result;
    /////////////////////////////////////////////////////////////
    // Bottom-Up (Iterative) solution template
    ////////////////////////////
    //    for (int i = 1; i <= target; ++i) {
    //        for (int j = 0; j < ways.size(); ++j) {
    //            if (ways[j] <= i) {
    //                dp[i] += dp[i - ways[j]];
    //            }
    //        }
    //    }
    //    return dp[target]
    /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        distinct_ways app = new distinct_ways();
    }
}
