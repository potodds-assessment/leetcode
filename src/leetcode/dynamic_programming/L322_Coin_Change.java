package leetcode.dynamic_programming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////
// 322. Coin Change
// https://leetcode.com/problems/coin-change/
/////////////////////////////////////////////////////////////

public class L322_Coin_Change {

    /*
    Bottoms Up approach
    1,2,5 amount 11
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2 (dp[2] + dp[1])
    dp[4] = 2 (dp[2] + dp[2])
    dp[5] = 1
    dp[6] = 2 (dp[5] + dp[1])
    dp[7] = 2 (dp[5] + dp[2])
    dp[8] = 3 (dp[7] + dp[1])
    dp[9] = 3 (dp[5] + dp[4])
    dp[10] = 2 (dp[5] + dp[5])
    dp[11] = 3 (dp[10] + dp[1])
    =========================================================================
    Top down approach
    1,2,5 amount 11
        0
      /  |  \
     1   2   5
    10   9   6
   / |\   etc..
   1 2 5
   9 8 5
     */


    /*
    Runtime: 15ms beats 89.99%
    Memory: 43.78mb beats 34.93%
    Time: O(amount * len(coin))
    Space: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1; i<amount+1; i++) {
            for(int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-c]);
                }
            }
        }

        return dp[amount] != amount+1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        L322_Coin_Change app = new L322_Coin_Change();
        System.out.println(app.coinChange(new int[]{1,2,5}, 6) == 2);
        System.out.println(app.coinChange(new int[]{2}, 3) == -1);
        System.out.println(app.coinChange(new int[]{1}, 0) == 0);
    }
}
