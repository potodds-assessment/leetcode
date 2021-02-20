package leetcode.tree_graphs;

/*
Completed: 2/20/2021
1) beats 100.00% performance
2) beats 55.52% for memory usage 
 */

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = {
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
}
Output: 1

Example 2:
Input: grid = {
  {'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'}
}
Output: 3

Constraints:
m == grid.length
n == grid{i}.length
1 <= m, n <= 300
grid{i}{j} is '0' or '1'.
 */
public class NumberOfIslands {
	
	/*
	 iterative method only goes one level deep. Will fail on this case.  
	 
    	char[][] grid = new char[][] {
    		{'1','0','1','1','1'},
    		{'1','0','1','0','1'},
    		{'1','1','1','0','1'}
    	};	 
	 
	 */
    public int numIslands2(char[][] grid) {
    	int uniqueIslands = 0;
    	
    	for(int x=0;x<grid.length;x++) {
        	for(int y=0;y<grid[0].length;y++) {
        		if ( grid[x][y] == '1' || grid[x][y] == 'a' ) {        			
        			int aboveX = x-1;
        			int bottomX = x+1;
        			int leftY = y-1;
                    int rightY = y+1;
        			
        			boolean above = !((aboveX >= 0) && ((grid[aboveX][y] == '1') || (grid[aboveX][y] == 'a')));
        			boolean left = !((leftY >= 0) && ((grid[x][leftY] == '1')  || (grid[x][leftY] == 'a'))); 
                    boolean right = (rightY < grid[0].length) ? (grid[x][rightY] != 'a') : true; 
                    boolean bottom = (bottomX < grid.length) ? (grid[bottomX][y] != 'a') : true; 
                    
        			if (above && left && right && bottom) {
        				uniqueIslands++;
        			}
                    
                    grid[x][y] = 'a';
                    if ((rightY < grid[0].length) && (grid[x][rightY] == '1')) grid[x][rightY] = 'a';
                    if ((bottomX < grid.length) && (grid[bottomX][y] == '1')) grid[bottomX][y] = 'a';
        		}
        	}    		
    	}
    	return uniqueIslands;  
    }

    private void recurse(char[][] grid, int x, int y) {
		int aboveX = x-1;
		int bottomX = x+1;
		int leftY = y-1;
        int rightY = y+1;
        
        if ((aboveX < 0 || (grid[aboveX][y] != '1')) &&
        	(leftY < 0 || (grid[x][leftY] != '1')) &&
        	(rightY >= grid[0].length || (grid[x][rightY] != '1')) &&
        	(bottomX >= grid.length || (grid[bottomX][y] != '1'))) {
        	return;
        }

    	grid[x][y] = 'a';
        if (aboveX >= 0 && (grid[aboveX][y] == '1'))
        	recurse(grid, aboveX, y);
        
        if (leftY >= 0 && (grid[x][leftY] == '1'))
        	recurse(grid, x, leftY);
        		
        if (rightY < grid[0].length && (grid[x][rightY] == '1'))
        	recurse(grid, x, rightY);
        	
        if (bottomX < grid.length && (grid[bottomX][y] == '1'))
        	recurse(grid, bottomX, y);

    }

    public int numIslands(char[][] grid) {
    	int uniqueIslands = 0;
    	
    	for(int x=0;x<grid.length;x++) {
        	for(int y=0;y<grid[0].length;y++) {
        		if ( grid[x][y] == '1' ) {
        			int aboveX = x-1;
        			int bottomX = x+1;
        			int leftY = y-1;
                    int rightY = y+1;
        			
        			boolean above = (aboveX >= 0) ? !((grid[aboveX][y] == '1') || (grid[aboveX][y] == 'a')) : true;
        			boolean left = (leftY >= 0) ? !((grid[x][leftY] == '1')  || (grid[x][leftY] == 'a')) : true; 
                    boolean right = (rightY < grid[0].length) ? (grid[x][rightY] != 'a') : true; 
                    boolean bottom = (bottomX < grid.length) ? (grid[bottomX][y] != 'a') : true; 
                    
        			if (above && left && right && bottom) {
        				uniqueIslands++;
        			}

        			recurse(grid, x, y);
        		}
        	}    		
    	}
    	return uniqueIslands;  
    }
    
    public void run() {
    	char[][] grid = new char[][] {
    		{'1','0','1','1','1'},
    		{'1','0','1','0','1'},
    		{'1','1','1','0','1'}
    	};
    	
    	grid = new char[][] { 
    		{'1'}
    	};
    	
    	grid = new char[][] {
    		{'1','1','1','1','1','1'},
    		{'1','0','0','0','0','1'},
    		{'1','0','1','1','0','1'},
    		{'1','0','0','0','0','1'},
    		{'1','1','1','1','1','1'}
    	};    	

    	System.out.println( numIslands(grid) );
//    	System.out.println( grid.length );
//    	System.out.println( grid{0}.length );
    }

    public static void main(String[] args) {
		new NumberOfIslands().run();
	}

}
