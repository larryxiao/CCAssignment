/*********************************************************************************
*     File Name           :     Solution05.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-18 15:36]
*     Last Modified       :     [2015-09-19 14:59]
*     Description         :     Sort Stack  
**********************************************************************************/

import java.util.Stack;

public class Solution05
{
    public Stack<Integer> sortStack(Stack<Integer> stack) {
        // similar to insertion sort, use stack as buffer
        Stack<Integer> ret = new Stack<Integer>();
        while (!stack.isEmpty()) {
            Integer tmp = stack.pop();
            while (!ret.isEmpty() && ret.peek() < tmp) {
                stack.push(ret.pop());
            }
            ret.push(tmp);
        }
        return ret;
    }

    public static void main(String [] args) {
        Solution05 foo = new Solution05();
        Stack<Integer> bar = new Stack<Integer>();
        bar.push(1);
        bar.push(3);
        bar.push(2);
        bar = foo.sortStack(bar);
        assert bar.pop() == 1;
        assert bar.pop() == 2;
        assert bar.pop() == 3;
        bar = foo.sortStack(bar);
        assert bar.isEmpty();
    }
}

