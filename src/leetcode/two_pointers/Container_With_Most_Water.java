package leetcode.two_pointers;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */

public class Container_With_Most_Water {
    public int maxArea1(int[] height) {
        int maxHeight = 0;

        for(int x=0; x<height.length-1; x++) {
            for(int y=x+1; y<height.length; y++) {
                int area = (y-x) * Math.min(height[x], height[y]);
                if (area > maxHeight) {
                    maxHeight = area;
                }
            }
        }

        return maxHeight;
    }

    /*
    Runtime: 4ms beats 77.11%
    Memory: 52.7MB beats 47.30%

    Time: O(n)
    Space: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxHeight = 0;

//        boolean done = false;
        while (left < right) {
            int area = (right-left) * Math.min(height[right], height[left]);
            if ( area > maxHeight )
                maxHeight = area;

            if (height[left] > height[right]) {
                right--;
            } else if ( (height[right] > height[left]) || (height[right] == height[left]) ) {
                left++;
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        Container_With_Most_Water app = new Container_With_Most_Water();
        System.out.println(app.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(app.maxArea(new int[]{1,1}));
    }
}
