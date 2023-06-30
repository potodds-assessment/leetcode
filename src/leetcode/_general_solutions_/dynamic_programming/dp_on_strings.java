package leetcode._general_solutions_.dynamic_programming;

import java.util.Arrays;

public class dp_on_strings {

    /////////////////////////////////////////////////////////////
    // DP on Strings
    /////////////////////////////////////////////////////////////
    // Problem List: https://leetcode.com/list/55afh7m7
    /////////////////////////////////////////////////////////////
    // Statement: General problem statement for this pattern can vary but most of the time you are
    // given two strings where lengths of those strings are not big.
    // Given two strings s1 and s2, return some result.
    // Approach: Most of the problems on this pattern requires a solution that can be accepted in O(n^2) complexity.
    /////////////////////////////////////////////////////////////
    // General solution template
    ////////////////////////////
    // i - indexing string s1
    // j - indexing string s2
    //    for (int i = 1; i <= n; ++i) {
    //        for (int j = 1; j <= m; ++j) {
    //            if (s1[i-1] == s2[j-1]) {
    //                dp[i][j] = /*code*/;
    //            } else {
    //                dp[i][j] = /*code*/;
    //            }
    //        }
    //    }
    // If you are given one string s the approach may little vary
    //    for (int l = 1; l < n; ++l) {
    //        for (int i = 0; i < n-l; ++i) {
    //            int j = i + l;
    //            if (s[i] == s[j]) {
    //                dp[i][j] = /*code*/;
    //            } else {
    //                dp[i][j] = /*code*/;
    //            }
    //        }
    //    }
    /////////////////////////////////////////////////////////////
    // Top-Down (Recursive) solution template
    ////////////////////////////
    /////////////////////////////////////////////////////////////
    // Bottom-Up (Iterative) solution template
    ////////////////////////////
    /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        dp_on_strings app = new dp_on_strings();
    }
}
