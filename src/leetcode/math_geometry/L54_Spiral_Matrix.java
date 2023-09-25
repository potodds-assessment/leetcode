package leetcode.math_geometry;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

public class L54_Spiral_Matrix {

    /*
    Runtime: ms, beats %
    Memory: MB, beats %

    time: O(m*n)
    space: O(1)
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while ((left<right) && (top<bottom)) {
            // get every i in the top row
            for(int i=left; i<right; i++) {
                result.add(matrix[top][i]);
            }
            top += 1;

            // get every i in the right col
            for(int i=top; i<bottom; i++) {
                result.add(matrix[i][right-1]);
            }
            right -= 1;

            if (!((left<right) && (top<bottom))) break;

            // get every i in the bottom row
            for(int i=right-1; i>(left-1); i--) {
                int value = matrix[bottom-1][i];
                result.add(value);
            }
            bottom -= 1;

            // get every i in the left col
            for(int i=bottom-1; i>(top-1); i--) {
                result.add(matrix[i][left]);                
            }
            left += 1;

        }

        return result;
    }    

    public static void main(String[] args) {
        L54_Spiral_Matrix app = new L54_Spiral_Matrix();
        System.out.println(app.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(app.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}