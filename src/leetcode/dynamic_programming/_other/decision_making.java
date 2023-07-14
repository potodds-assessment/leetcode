package leetcode.dynamic_programming._other;

public class decision_making {

    /////////////////////////////////////////////////////////////
    // Decision Making
    /////////////////////////////////////////////////////////////
    // Problem List: https://leetcode.com/list/55af7bu7
    /////////////////////////////////////////////////////////////
    // Statement: The general problem statement for this pattern is forgiven situation decide whether to use or not to
    // use the current state. So, the problem requires you to make a decision at a current state.
    // Given a set of values find an answer with an option to choose or ignore the current value.
    // Approach: If you decide to choose the current value use the previous result where the value was ignored; vice-versa,
    /////////////////////////////////////////////////////////////
    // General solution template
    ////////////////////////////
    // if you decide to ignore the current value use previous result where value was used.
    // i - indexing a set of values
    // j - options to ignore j values
    //    for (int i = 1; i < n; ++i) {
    //        for (int j = 1; j <= k; ++j) {
    //            dp[i][j] = max({dp[i][j], dp[i-1][j] + arr[i], dp[i-1][j-1]});
    //            dp[i][j-1] = max({dp[i][j-1], dp[i-1][j-1] + arr[i], arr[i]});
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
        decision_making app = new decision_making();
    }
}
