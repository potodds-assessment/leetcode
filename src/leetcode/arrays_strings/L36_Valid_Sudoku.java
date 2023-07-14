package leetcode.arrays_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/////////////////////////////////////////////////////////////
// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/
// Runtime: 10ms beats 36.28%
// Memory: 44.5MB beats 6.2%
// Time: O(9^2)
// Space: O(3 * 9^2)
/////////////////////////////////////////////////////////////

public class L36_Valid_Sudoku {
    Map<Integer, Set<Integer>> rowG = new HashMap<>();
    Map<Integer, Set<Integer>> colG = new HashMap<>();
    Map<String, Set<Integer>> gridG = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if (!Character.isDigit(board[row][col]))
                    continue;

                int value = Integer.parseInt(String.valueOf(board[row][col]));

                if (!(addRow(row, value) && addCol(col, value) && addGrid(row, col, value)))
                    return false;
            }
        }
        return true;
    }

    boolean addRow(int row, int value) {
        if (rowG.containsKey(row)) {
            Set<Integer> values = rowG.get(row);
            if (values.contains(value))
                return false;
            else
                values.add(value);
        } else {
            Set<Integer> values = new HashSet<>();
            values.add(value);
            rowG.put(row, values);
        }

        return true;
    }
    boolean addCol(int col, int value) {
        if (colG.containsKey(col)) {
            Set<Integer> values = colG.get(col);
            if (values.contains(value))
                return false;
            else
                values.add(value);
        } else {
            Set<Integer> values = new HashSet<>();
            values.add(value);
            colG.put(col, values);
        }

        return true;
    }
    boolean addGrid(int row, int col, int value) {
        String key = row/3 + "" + col/3;

        if (gridG.containsKey(key)) {
            Set<Integer> values = gridG.get(key);
            if (values.contains(value))
                return false;
            else
                values.add(value);
        } else {
            Set<Integer> values = new HashSet<>();
            values.add(value);
            gridG.put(key, values);
        }

        return true;
    }

    public static void main(String[] args) {
        L36_Valid_Sudoku app = new L36_Valid_Sudoku();

        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}                
        };  // true

        board = new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }; // false

        board = new char[][] {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };  // false

        System.out.println(app.isValidSudoku(board));
    }
}
