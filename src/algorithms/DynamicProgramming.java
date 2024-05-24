package algorithms;

/*
* You are given a two-dimensional integer matrix where each cell represents number of coins in that cell. 
* Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect 
* by the bottom right corner.
* 
* matrix = [[0,3,1,1], [2,0,0,4], [1,5,3,1]]
* solution = 12 ie [0, 2, 1, 5, 3, 1]
*/

public class DynamicProgramming {
    
    public int solve(int[][] matrix) {
        int x = 0, y = 0;
        for (x = 0; x < matrix.length; x++)
        {
            for (y = 0; y < matrix[x].length; y++)
            {
                int up = x == 0 ? 0 : matrix[x - 1][y];  
                int left = y == 0 ? 0 : matrix[x][y - 1]; 
                matrix[x][y] = Math.max(up, left) + matrix[x][y];  // max(above cell, left cell) + current cell. x == 0 then up == 0. y == 0 then left == 0.
            }
        }
        System.out.println(x + "," + y);
        return matrix[x - 1][y - 1];
    }

    public static void main(String[] args) {
        DynamicProgramming app = new DynamicProgramming();
        System.out.println(app.solve(new int[][] {{0,3,1,1}, {2,0,0,4}, {1,5,3,1}}));
    }
}
