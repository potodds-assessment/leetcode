package leetcode.arrays_strings;

/*
Completed: 2/24/2021
1) beats 28.65% performance
2) beats 26.72% for memory usage 
 */

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105 
 */
public class TrappingRainWater {

	private int findLeftTallestIndex(int[] height, int currentPos) {
		int tallestIndex = currentPos-1;
		for(int i=0; i<currentPos-1; i++) {
			if ( height[i] > height[tallestIndex] )
				tallestIndex = i;				
		}
		return tallestIndex;
	}

	private int findRightTallestIndex(int[] height, int currentPos) {
		int tallestIndex = currentPos+1;
		for(int i=height.length-1; i>currentPos; i--) {
			if ( height[i] > height[tallestIndex] )
				tallestIndex = i;				
		}
		return tallestIndex;
	}

    public int trap(int[] height) {
    	if ( height == null ||  height.length < 3 ) 
    		return 0;

    	int trappedRain = 0;
    	
    	int leftTallestIndex = 0;
    	int rightTallestIndex = findRightTallestIndex(height, 0);
    	
    	for(int i=1; i<height.length-1; i++) {

    		int currentHeight = height[i];
    		int leftTallestHeight = height[leftTallestIndex];
    		int rightTallestHeight = height[rightTallestIndex];
    		
    		if ( leftTallestHeight > currentHeight && currentHeight < rightTallestHeight ) {
    			if ( leftTallestHeight > rightTallestHeight ) 
    				trappedRain += ( rightTallestHeight - currentHeight );
    			else 
    				trappedRain += ( leftTallestHeight - currentHeight );
    		} else if ( leftTallestHeight < currentHeight || currentHeight == rightTallestHeight ) {
    			leftTallestIndex = i;
    			rightTallestIndex = findRightTallestIndex(height, i);
    		} else if ( currentHeight > rightTallestHeight ) {
    			rightTallestHeight = i;
    			leftTallestIndex = findLeftTallestIndex(height, i);
    		}
    	}

    	return trappedRain;
    }

    public void run() {
    	System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    	System.out.println(trap(new int[] {4,2,0,3,2,5}));
    	System.out.println(trap(new int[] {5,4,1,2}));
    }

    public static void main(String[] args) {
    	new TrappingRainWater().run();
	}

}
