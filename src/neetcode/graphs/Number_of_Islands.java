package neetcode.graphs;

import java.util.*;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class Number_of_Islands {

    List<List<String>> res = new ArrayList<>();

    public List<String> calcSurrounding(int x, int y) {
        List<String> ans = new ArrayList<>();
        ans.add(x-1 + "" + y); //top
        ans.add(x+1 + "" + y); //bottom
        ans.add(x + "" + (y+1)); //left
        ans.add(x + "" + (y-1)); //right
        return ans;
    }

    public void findAdd(int x, int y) {

        int clash_count = 0;
        List<List<String>> clash_list = new ArrayList<>();

        List<String> coords = calcSurrounding(x, y);
        for(List<String> curr : res) {
            for(String c : coords) {
                if (curr.contains(c)) {
                    curr.add(x + "" + y);
                    clash_count++;
                    clash_list.add(curr);
                }
            }
        }

        if ( clash_count > 1 ) {
            // merge clashing islands
        } else if ( clash_count == 1 ) {
            return;
        }

        List<String> newIsland = new ArrayList<>();
        newIsland.add(x + "" + y);
        res.add(newIsland);
    }

    /*
    First attempt solution was double loop, determining whether existing x,y coords belong to an existing island.
    Did not catch case where later x,y coord join an existing separate island.
     */
    public int numIslands1(char[][] grid) {

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                if ( grid[x][y] == '1' ) {
                    findAdd(x, y);
                }
            }
        }

        return res.size();
    }

//    public boolean contains(Set<int[]> visit, int r, int c) {
//        if ( visit == null || visit.size() == 0 )
//            return false;
//
//        int[] search = new int[]{r, c};
//        for(int[] x : visit) {
//            if ( Arrays.equals(x, search) ) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean contains(Set<Pair> visit, int r, int c) {
//        if ( visit == null || visit.size() == 0 )
//            return false;
//
//        Pair search = new Pair(r, c);
//        for(Pair x : visit) {
//            if ( x.x == search.x && x.y == search.y ) {
//                return true;
//            }
//        }
//        return false;
//    }

    ArrayDeque<Pair> que = new ArrayDeque<>();
    Set<Pair> visit = new HashSet<>();
    List<Pair> directions = new ArrayList<>();

    public void bfs(int r, int c) {
        Pair q = que.poll();
        Pair coords = new Pair(r,c);
        visit.add(coords);
        que.add(coords);

        while (!que.isEmpty()) {
            Pair z = que.poll();
            for(Pair dd : directions) {
                r = z.x + dd.x;
                c = z.y + dd.y;

                if ((r >= 0 && r < rows) &&
                    (c >= 0 && c < cols) &&
                    gridz[r][c] == '1' &&
                    (!visit.contains(new Pair(r, c)))) {

                    coords = new Pair(r,c);
                    visit.add(coords);
                    que.add(coords);

                }

            }
        }
    }

    int rows = 0;
    int cols = 0;
    char[][] gridz = null;

    /*
    NeetCode solution to use BFS to find all x,y coords belonging to current x,y.

    Runtime 30ms beats 5.10%
    Memory 55.4MB beats 5.28%
     */
    public int numIslands(char[][] grid) {
        if ( grid == null || grid.length == 0)
            return 0;

        directions.add(new Pair(1,0));
        directions.add(new Pair(-1,0));
        directions.add(new Pair(0,1));
        directions.add(new Pair(0,-1));

        rows = grid.length;
        cols = grid[0].length;
        gridz = grid;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if ( grid[r][c] == '1' && !visit.contains(new Pair(r, c))) {
                    bfs(r,c);
                    islands += 1;
                }
            }
        }
        return islands;
    }

        public static void main(String[] args) {
        Number_of_Islands app = new Number_of_Islands();

        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'0','0','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','1','0','0'}
        };

//        char[][] grid = new char[][] {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };

        System.out.println( app.numIslands( grid ) );

//            int[] z = new int[]{1,2};
//
//            Set<int[]> t = new HashSet<>();
//            t.add(new int[]{1,2});
//            t.add(new int[]{2,3});
//            t.add(new int[]{3,4});
//            t.add(new int[]{4,5});
//
//            System.out.println(app.contains(t, 4, 2));


//        app.res = new ArrayList<>();
//
//        grid = new char[][] {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };
//        System.out.println( app.numIslands( grid ) );

//        List<String> test = new ArrayList<>();
//        test.add("-1-2");
//        test.add("12");
//        System.out.println( test.contains(1 + "" + 2) );
//        System.out.println( test.contains(-1 + "" + -2) );
    }
}

class Pair  {
    int x;
    int y;

    Pair(int r, int c) {
        x = r;
        y = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
