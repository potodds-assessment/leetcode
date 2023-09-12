package leetcode.backtracking;

import java.util.Set;
import java.util.HashSet;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 
Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 
Follow up: Could you use search pruning to make your solution faster with a larger board?
*/

public class L79_Word_Search {

    char[][] board = null;
    String word = null;
    record Pair(Integer n, Integer s) {};
    Set<Pair> visited = new HashSet<>();

    public boolean dfs(int row, int col, int wIndex) {
        if (wIndex == word.length())
            return true;

        Pair coord = new Pair(row, col);
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || 
            word.charAt(wIndex) != board[row][col] || visited.contains(coord))
            return false;
            
        visited.add(coord);
        boolean res = (
            dfs(row + 1, col, wIndex+1) || 
            dfs(row - 1, col, wIndex+1) ||
            dfs(row, col + 1, wIndex+1) ||
            dfs(row, col - 1, wIndex+1));
        visited.remove(coord);

        return res;
    }

    /*
    Runtime: ms, beats %
    Memory: MB, beats %

    time: O()
    space: O()
    */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new HashSet<>();

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if (dfs(row, col, 0)) {
                    return true;
                }
            }
        }
        return false;

    }


    public boolean exist1(char[][] board, String word) {

        int wIndex = 0;
        char currChar = word.charAt(wIndex);

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {

                match(board, row, col, currChar);
                if (board[row][col] == currChar) {
                    System.out.print(board[row][col] + ",");
                    currChar = word.charAt(++wIndex);
                }
            }
        }
        System.out.println();
        return false;
    }

    public String match(char[][] board, int row, int col, char searchChar) {

        Character top = (row-1) < 0 ? null : board[row-1][col];
        Character bottom = (row+1) >= board.length ? null : board[row+1][col];
        Character left = (col-1) < 0 ? null : board[row][col-1];
        Character right = (col+1) >= board[0].length ? null : board[row][col+1];
        return null;
    }

    public static void main(String[] args) {        
        L79_Word_Search app = new L79_Word_Search();
        System.out.println(app.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(app.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(app.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
        System.out.println(app.exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
    }
}
