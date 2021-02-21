package leetcode.dynamic_programming;

/*
Completed: 2/20/2021
1) beats 24.30% performance
2) beats 38.23% for memory usage 
 */

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104 
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
    	int maxProfit = 0;
    	int minPrice = 0;
    	int maxPrice = 0;

    	boolean first = true;
    	
    	for(int i=0; i<prices.length; i++) {
    		if ( first ) {
    			minPrice = prices[i];
    			first = false;
    		} else {
    			if ( prices[i] < minPrice ) {
    				minPrice = prices[i];
    				maxPrice = 0;
    			} else if ( prices[i] > maxPrice ) {
    				maxPrice = prices[i];
					if ((maxPrice - minPrice) > maxProfit)
						maxProfit = maxPrice - minPrice;
    			} else if ((maxPrice - minPrice) > maxProfit) 
					maxProfit = maxPrice - minPrice;
    		}
    	}

    	return maxProfit;
    }

    public void run() {
    	int[] prices = new int[] {7,1,5,3,6,4};
    	System.out.println(maxProfit(prices));
    	
    	prices = new int[] {3,2,6,5,0,3};
    	System.out.println(maxProfit(prices));
    }

    public static void main(String[] args) {
    	new BestTimeToBuyAndSellStock().run();
	}

}
