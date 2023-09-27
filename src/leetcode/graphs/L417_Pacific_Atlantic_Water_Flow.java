package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/pacific-atlantic-water-flow

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. 
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and 
bottom edges.
The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where 
heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, 
and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from 
any cell adjacent to an ocean into the ocean.
Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from 
cell (ri, ci) to both the Pacific and Atlantic oceans. 

Example 1:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

Example 2:
Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105
*/

public class L417_Pacific_Atlantic_Water_Flow {

    public record Tuple(int r, int c) {}
    int[][] heights;
    int rows;
    int cols;
    /*
    Runtime: 34ms, beats 13.07%
    Memory: 45.46MB, beats 6.67%

    time: O(n^2)
    space: O(m * n)
    */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;

        Set<Tuple> pac = new HashSet<>();
        Set<Tuple> atl = new HashSet<>();

        rows = heights.length;
        cols = heights[0].length;

        /*
        from left to right column, starting at top row going across, mark cell if it can reach pacific
        from left to right column, starting at bottom row going across, mark cell if it can reach atlantic
        */
        for(int c=0; c<cols; c++) {
            dfs(0, c, pac, heights[0][c]);
            dfs(rows-1, c, atl, heights[rows-1][c]);
        }

        /*
        from top to bottom row, starting at first row going down, mark cell if it can reach pacific
        from top to bottom row, starting at last column going down, mark cell if it can reach atlantic
        */
        for(int r=0;r<rows;r++) {
            dfs(r, 0, pac, heights[r][0]);
            dfs(r, cols-1, atl, heights[r][cols-1]);
        }

        /*
        match if cell can go to pacific and atlantic
         */
        List<List<Integer>> result = new ArrayList<>();
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                Tuple temp = new Tuple(r, c);
                if (pac.contains(temp) && atl.contains(temp)) {
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(r);
                    temp2.add(c);
                    result.add(temp2);
                }
            }
        }

        return result;
    }

    /*
     Base case: 1. already visited. 2. outside of borders 3. cannot flow to prior cell
     Recursion: add cell as visited then recurse left, right, top, bottom
     */
    private void dfs(int r, int c, Set<Tuple> visit, int prevHeight) {
        Tuple t = new Tuple(r, c);
        if (visit.contains(t) || r < 0 || c < 0 || r == rows || c == cols || heights[r][c] < prevHeight )
            return;

        visit.add(t);
        dfs(r+1, c, visit, heights[r][c]);
        dfs(r-1, c, visit, heights[r][c]);
        dfs(r, c+1, visit, heights[r][c]);
        dfs(r, c-1, visit, heights[r][c]);
        
    }

    public static void main(String[] args) {
        L417_Pacific_Atlantic_Water_Flow app = new L417_Pacific_Atlantic_Water_Flow();
        System.out.println(app.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
        System.out.println(app.pacificAtlantic(new int[][]{{1}}));

        // Tuple one = new Tuple(1,2);
        // Tuple two = new Tuple(2,1);
        // Set<Tuple> s = new HashSet<>();
        // s.add(one);
        // System.out.println(s.contains(two));

    }
}


