package leetcode.stack;

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

import java.util.*;

public class Generate_Parentheses {

    Stack<String> s = new Stack<>();
    List<String> result = new ArrayList<>();

    private String convertToString() {
        StringBuffer sb = new StringBuffer();
        for (Iterator<String> it = s.iterator(); it.hasNext(); ) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    /*
    Runtime 4ms beats 14.58%
    Memory 42.3MB beats 91.99%
    Time: O(n)
    Space: O(n)
     */

    private void backtrack(int openN, int closedN, int n) {
        if ( openN == closedN && closedN == n ) {
            result.add(String.join("", s.stream().toList()));
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
    }

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return result;
    }

    public static void main(String[] args) {
        Generate_Parentheses app = new Generate_Parentheses();

        System.out.println(app.generateParenthesis(3));

//        Stack<String> test = new Stack<>();
//        test.push("(");
//        test.push("(");
//        test.push(")");
//        test.push("(");
//        test.push(")");
//        test.push(")");
//        System.out.println(test.toString());

    }
}
