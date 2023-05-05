package neetcode.stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the Min_Stack class:

Min_Stack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["Min_Stack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
Min_Stack Min_Stack = new Min_Stack();
Min_Stack.push(-2);
Min_Stack.push(0);
Min_Stack.push(-3);
Min_Stack.getMin(); // return -3
Min_Stack.pop();
Min_Stack.top();    // return 0
Min_Stack.getMin(); // return -2

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Min_Stack {

    /*
    Runtime: 175ms beats 5.8%
    Memory: 46.2 beats 5.88%
    Note: prior implementation used single stack and a sorted list which was slow and used lots of memory
     */

    /*
    Runtime: 6ms beats 45.12%
    Memory: 44.2MB beats 70.53%
     */

    Stack<Integer> s;
    Stack<Integer> minS;
    int lastVal;

    public Min_Stack() {
        s = new Stack<>();
        minS = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        int minValue = minS.isEmpty() ? val : Math.min(minS.peek(), val);
        minS.push(minValue);
    }

    public void pop() {
        s.pop();
        int val = minS.pop();
        if ( minS.isEmpty() )
            lastVal = val;
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.isEmpty() ? lastVal : minS.peek();
    }
    
    public static void main(String[] args) {
/*
        Min_Stack Min_Stack = new Min_Stack();
        Min_Stack.push(-2);
        Min_Stack.push(0);
        Min_Stack.push(-3);
        System.out.println(Min_Stack.getMin()); // return -3
        Min_Stack.pop();
        System.out.println(Min_Stack.top()); // return -2
        System.out.println(Min_Stack.getMin()); // return -2
*/
        Min_Stack Min_Stack = new Min_Stack();
        Min_Stack.push(2);
        Min_Stack.push(0);
        Min_Stack.push(3);
        System.out.println(Min_Stack.getMin()); // return -3
        Min_Stack.pop();
        System.out.println(Min_Stack.getMin()); // return -3
        Min_Stack.pop();
        System.out.println(Min_Stack.getMin()); // return -3
        Min_Stack.pop();
        System.out.println(Min_Stack.getMin()); // return -3

    }
}
