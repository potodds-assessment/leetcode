package leetcode.stack;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22

Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    /*
    Runtime: 6ms beats 91.8%
    Memory: 42.4MB beats 55.68%

    Time: O(n)
    Space: O(n)
     */

    public boolean isOperand(String operand) {
        switch(operand) {
            case "+":
            case "/":
            case "*":
            case "-":
                return true;
        }
        return false;
    }

    public int calculate(Integer o1, Integer o2, String token) {
        switch(token) {
            case "+":
                return o1 + o2;
            case "/":
                return o1 / o2;
            case "*":
                return o1 * o2;
            case "-":
                return o1 - o2;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {

        int res = 0;
        Stack<Integer> operands = new Stack<>();

        for(String token : tokens) {
            if (!isOperand(token))
                operands.push(Integer.parseInt(token));
            else {
                Integer o1 = operands.pop();
                Integer o2 = operands.pop();
                operands.push(calculate(o2, o1, token));
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation app = new Evaluate_Reverse_Polish_Notation();
        System.out.println(app.evalRPN(new String[]{"2","1","+","3","*"} ));
        System.out.println(app.evalRPN(new String[]{"4","13","5","/","+"} ));
        System.out.println(app.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"} ));
    }
}
