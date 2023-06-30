package leetcode._general_solutions_.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class min_max_path_to_target {

    /////////////////////////////////////////////////////////////
    // Minimum (Maximum) Path to Reach a Target
    /////////////////////////////////////////////////////////////
    // Problem list: https://leetcode.com/list/55ac4kuc
    /////////////////////////////////////////////////////////////
    // Statement: Given a target find minimum (maximum) cost / path / sum to reach the target.
    // Approach: Choose minimum (maximum) path among all possible paths before the current state,
    // then add value for the current state. Generate optimal solutions for all values in the target and return the value for the target.
    /////////////////////////////////////////////////////////////
    // General solution template
    ////////////////////////////
    // routes[i] = min(routes[i-1], routes[i-2], ... , routes[i-k]) + cost[i]
    /////////////////////////////////////////////////////////////
    // Top-Down (Recursive) solution template
    ////////////////////////////
    //    for (int j = 0; j < ways.size(); ++j) {
    //        result = min(result, topDown(target - ways[j]) + cost/ path / sum);
    //    }
    //    return memo[/*state parameters*/] = result;
    /////////////////////////////////////////////////////////////
    // Bottom-Up (Iterative) solution template
    ////////////////////////////
    //    for (int i = 1; i <= target; ++i) {
    //        for (int j = 0; j < ways.size(); ++j) {
    //            if (ways[j] <= i) {
    //                dp[i] = min(dp[i], dp[i - ways[j]] + cost / path / sum) ;
    //            }
    //        }
    //    }
    //
    //    return dp[target]
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    // 746. Min Cost Climbing Stairs
    // https://leetcode.com/problems/min-cost-climbing-stairs/
    /////////////////////////////////////////////////////////////

    public int minCost(int n, int[] cost, int[] memo) {
        if ( n < 2 ) {
            memo[n] = cost[n];
            return cost[n];
        }

        if (memo[n] != -1)
            return memo[n];

        memo[n] = Math.min(minCost(n - 1, cost, memo), minCost(n - 2, cost, memo)) + (n == cost.length ? 0 : cost[n]);
        return memo[n];
    }

    /*
    Runtime: 1ms beats 57.95%
    Memory: 42.7% beats 62.29%
     */
    public int minCostClimbingStairs_r(int[] cost) {
//        int[] memo = Arrays.copyOf(cost, cost.length+1);
        int[] memo = IntStream.generate(()->-1).limit(cost.length+1).toArray();
        int n = cost.length;

        System.out.println(Arrays.toString(cost));

        int result = Math.min(minCost(n - 1, cost, memo), minCost(n - 2, cost, memo)) + (n == cost.length ? 0 : cost[n]);

        System.out.println(Arrays.toString(memo));
        return memo[n] = result;
    }

    /*
    Runtime: 1ms beats 57.95%
    Memory: 43.4% beats 20.44%
     */
    public int minCostClimbingStairs_i(int[] cost) {
        int[] dp = Arrays.copyOf(cost, cost.length+1);
        int n = cost.length;

        System.out.println(Arrays.toString(cost));

        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == n ? 0 : cost[i]);
        }

        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    /////////////////////////////////////////////////////////////
    // 64. Minimum Path Sum
    // https://leetcode.com/problems/minimum-path-sum/?envType=list&envId=55ac4kuc
    /////////////////////////////////////////////////////////////
    /**
     Top-Down
         int result = min(pathSum(i+1, j, grid, memo), pathSum(i, j+1, grid, memo)) + grid[i][j];
         return memo[i][j] = result;

     Bottom-Up
     **/



    /*
    Runtime: 3ms beats 29.1%
    Memory: 43.8% beats 94.13%
    Time: O(n * m)
    Space: O(n * m)

    Comment: keep n * m grid while other solutions added extra row and column initialized to infinity.
    Comment: if negative row or column, add positive row or column.  if both negative, keep original value.
     */
    public int minPathSum_i(int[][] grid) {

        print_array(grid);

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i-1 < 0 && j-1 < 0) continue;

                int top = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if ( i-1 >= 0 ) top = grid[i-1][j];
                if ( j-1 >= 0 ) left = grid[i][j-1];

                grid[i][j] = Math.min(top, left) + grid[i][j];
            }
        }

        print_array(grid);
        return grid[n-1][m-1];
    }

    public int pathSum(int row, int col, int[][] grid, int[][] memo) {
        return 0;
    }

    /**************************
     ** NOT DONE
     */
    public int minPathSum_r(int[][] grid) {
        int[][] memo = Arrays.copyOf(grid, grid.length);
        int i=0;
        int j=0;
        int result = Math.min(pathSum(i+1, j, grid, memo), pathSum(i, j+1, grid, memo)) + grid[i][j];
        return memo[i][j] = result;
    }

        /////////////////////////////////////////////////////////////
    // 322. Coin Change
    // https://leetcode.com/problems/coin-change/?envType=list&envId=55ac4kuc
    /////////////////////////////////////////////////////////////
    /**
     Top-Down
         for (int i = 0; i < coins.size(); ++i) {
             if (coins[i] <= target) { // check validity of a sub-problem
                 result = min(ans, CoinChange(target - coins[i], coins) + 1);
             }
         }
         return memo[target] = result;

     Bottom-Up
         for (int j = 1; j <= amount; ++j) {
             for (int i = 0; i < coins.size(); ++i) {
                 if (coins[i] <= j) {
                     dp[j] = min(dp[j], dp[j - coins[i]] + 1);
                 }
             }
         }
     **/

    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
    /**
     Top-Down

     Bottom-Up
     **/

    public void stream_init_array() {
        List<Integer> z = Stream.generate(() -> -1).limit(20).collect(Collectors.toList());
        int[] p = IntStream.generate(()->-5).limit(3).toArray();
        System.out.println(Arrays.toString(p));
    }

    public void print_array(int[][] grid){
        for(int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        min_max_path_to_target app = new min_max_path_to_target();

        ////////////////////////////////////////////////////////////
        // 746. Min Cost Climbing Stairs
        ////////////////////////////////////////////////////////////
//        System.out.println(app.minCostClimbingStairs_i(new int[]{10,15,20}) == 15);
//        System.out.println(app.minCostClimbingStairs_i(new int[]{1,100,1,1,1,100,1,1,100,1}) == 6);
//        System.out.println(app.minCostClimbingStairs_r(new int[]{10,15,20}) == 15);
//        System.out.println(app.minCostClimbingStairs_r(new int[]{1,100,1,1,1,100,1,1,100,1}) == 6);

        ////////////////////////////////////////////////////////////
        // 64. Minimum Path Sum
        ////////////////////////////////////////////////////////////
//        System.out.println(app.minPathSum_i(new int[][]{{1,3,1},{1,5,1,},{4,2,1}}) == 7);

        //        app.stream_init_array();
    }

}
