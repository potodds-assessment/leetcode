package neetcode.stack;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Generate_Parentheses {

    Stack<String> s = new Stack<>();
    Stack<String> result = new Stack<>();

    private void backtrack(int openN, int closedN, int n) {
        if ( openN == closedN && closedN == n ) {
            result.addAll(s);
            return;
        }

        if ( openN < n ) {
            s.push("(");
            backtrack(openN + 1, closedN, n);
            s.pop();
        }

        if ( closedN < openN ) {
            s.push( ")");
            backtrack( openN, closedN + 1, n);
            s.pop();
        }

        backtrack(0,0, n);
    }

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return result;
    }

    public static void main(String[] args) {
        Generate_Parentheses app = new Generate_Parentheses();
        System.out.println(app.generateParenthesis(2));
    }
}
