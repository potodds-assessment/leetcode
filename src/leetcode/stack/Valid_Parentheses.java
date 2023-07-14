package leetcode.stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

import java.util.EmptyStackException;
import java.util.Stack;

public class Valid_Parentheses {

    public boolean isOpen(char c) {
        if ( c == '(' || c == '[' || c == '{' )
            return true;

        return false;
    }

    public boolean doesMatch(char c1, char c2) {
        if (( c1 == '(' && c2 == ')' ) ||
            ( c1 == '[' && c2 == ']' ) ||
                ( c1 == '{' && c2 == '}' ) )
            return true;

        return false;
    }

    /*
    Runtime: 2ms beats 84.58%
    Memory: 40.9MB beats 24.73%

    Time: O(n)
    Space: O(n)
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        try {
            for (char c : s.toCharArray()) {
                if (isOpen(c))
                    stack.push(c);
                else {
                    Character v = stack.pop();
                    if ( ! doesMatch(v, c) )
                        return false;
                }
            }
        } catch(EmptyStackException e) {
            return false;
        }

        if ( stack.isEmpty() )
            return true;

        return false;
    }

    public static void main(String[] args) {
        Valid_Parentheses app = new Valid_Parentheses();
        System.out.println(app.isValid("()"));
        System.out.println(app.isValid("()[]{}"));
        System.out.println(app.isValid("(]"));
        System.out.println(app.isValid("([)]"));
    }
}
