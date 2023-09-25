package leetcode.math_geometry;

import java.util.Arrays;

/*
 You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
public class L48_Rotate_Image {
    /*
    Runtime: 0ms, beats 100%
    Memory: 41.20MB, beats 63.20%

    time: O(n^2)
    space: O(1)
    */
    public void rotate(int[][] matrix) {
        // Neetcode solution

        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for(int i=0; i<(right-left); i++) {
                int top = left;
                int bottom = right;

                // save the topLeft
                int topLeft = matrix[top][left+i];

                // move bottom left into top left
                matrix[top][left+i] = matrix[bottom-i][left];

                // move bottom right into bottom left
                matrix[bottom-i][left] = matrix[bottom][right-i];
 
                // move top right into bottom right
                matrix[bottom][right-i] = matrix[top+i][right];

                // move top left into top right
                matrix[top+i][right] = topLeft;
            }
            right -= 1;
            left += 1;
        }

        System.out.println(Arrays.deepToString(matrix));        
    }

    public static void main(String[] args) {
        L48_Rotate_Image app = new L48_Rotate_Image();
        app.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        app.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}